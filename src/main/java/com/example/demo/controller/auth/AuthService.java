package com.example.demo.controller.auth;

import com.example.demo.configuration.JwtService;
import com.example.demo.model.Token;
import com.example.demo.model.Users;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository repository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager manager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user= Users.builder()
                .nom(request.getFirstname())
                .prenom(request.getLastname())
                .login(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

   

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword() ));
        var user = repository.findByLogin(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }

    private void revokeAllUserTokens(Users user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);

    }

    private void saveUserToken(Users user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType("Bearer ")
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);

    }
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByLogin(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

}

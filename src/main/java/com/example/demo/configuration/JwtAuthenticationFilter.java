package com.example.demo.configuration;

import com.example.demo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    private  final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private UsersService usersService;


    @Override
    protected void doFilterInternal( HttpServletRequest request,
                                     HttpServletResponse response,
                                     FilterChain filterChain)
            throws ServletException, IOException {
        final String auth = request.getHeader("Authorization");
        final String jwt;
        final String email;
        if (auth == null ||!auth.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        //length "bearer " = 7 -- token
        jwt= auth.substring(7);
        email= jwtService.extractUsername(jwt);//todo later
        // extract the email from jwt token ;
        if (email != null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= this.userDetailsService.loadUserByUsername(email);

           //check if user and the token are valid or not
            if ((jwtService.isTokenValid(jwt, userDetails))){
                UsernamePasswordAuthenticationToken tokenAuth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               //enforce the tokenAuth with the details of our request

                tokenAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               //to update the authToken
                SecurityContextHolder.getContext().setAuthentication(tokenAuth);
            }
        }
        //to pass the hand to the next filters to be executed
        filterChain.doFilter(request,response);

    }
}

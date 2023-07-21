package com.example.demo.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final  String SECRET_KEY ="5A9323C820D6B906A849B0137071D0E12A378E69989B39EBD464BA04958B74D7";
    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }
    public  String generateToken(UserDetails userDetails){
        return  generateToken(new HashMap<>(), userDetails);
    }
    public Boolean isValidToken (String token , @NotNull UserDetails userDetails){
        final  String username= extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }
    public  String generateToken(Map<String,Object> extraClaims,
                                 @NotNull UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // function: pour extracter de toutes les revendications de mon jeton
    public <T> T extractClaim(String token, @NotNull Function<Claims,T> function){
        final  Claims claims= extractAllClaims(token);
        return function.apply(claims);
    }

    private Claims extractAllClaims (String token){
        return Jwts
                .parserBuilder()
                //signInKey utilisée pour créer la partie signature du JWT pour verifier l'expéditeur du JWT que le meme personne qui envoi le clé jwt est celui qui veut s'authentifié
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @NotNull
    private Key getSignInKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }
}

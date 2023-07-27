package com.example.demo.configuration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JwtService {

        private String secretKey= "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
        private long jwtExpiration=60000;
        private long refreshExpiration=604800000;

        public String extractUsername(String token) {
            return extractClaim(token, Claims::getSubject);
        }
    // function: pour extracter de toutes les revendications de mon jeton
        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        public String generateToken(UserDetails userDetails) {
            Map<String,Object> claims =new HashMap<>();
            return createToken(claims, userDetails);
        }

    private String createToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("authorities",userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    public String generateToken(
                Map<String, Object> claims,
                UserDetails userDetails
        ) {
            return createToken(claims, userDetails);
        }

        public String generateRefreshToken(
                UserDetails userDetails
        ) {
            return buildToken(new HashMap<>(), userDetails, refreshExpiration);
        }

        private String buildToken(
                Map<String, Object> extraClaims,
                UserDetails userDetails,
                long expiration
        ) {
            return Jwts
                    .builder()
                    .setClaims(extraClaims)
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(SignatureAlgorithm.HS256,secretKey)
                    .compact();
        }

        public boolean isTokenValid(String token, UserDetails userDetails) {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            return extractExpiration(token).before(new Date());
        }

        private Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
        }
        public Boolean hasClaim(String token, String claimName){
            final Claims claims=extractAllClaims(token);
            return claims.get(claimName) != null;
        }

    private Claims extractAllClaims(String token) {
            return Jwts
                    .parser()
                    //signInKey utilisée pour créer la partie signature du JWT pour verifier l'expéditeur du JWT que le meme personne qui envoi le clé jwt est celui qui veut s'authentifié
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }

//        private Key getSignInKey() {
//            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//            return Keys.hmacShaKeyFor(keyBytes);
//        }

}

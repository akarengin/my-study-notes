package rest$api.authentication$authorization;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenUtil {

    private static final String SECRET_KEY = "mySecretKey123";

    public String generateJwtToken(String username, List<String> roles) {
        // User will write code here
        String token = Jwts.builder()
                .setSubject(username)
                .claim("roles", roles.stream().collect(Collectors.joining(",")))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }

    public static void main(String[] args) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String username = "user1";
        List<String> roles = List.of("ROLE_USER");
        String token = jwtTokenUtil.generateJwtToken(username, roles);
        System.out.println("Generated Token: " + token);
    }

    public boolean validateToken(String token) {
        try {
            // The 'parser()' method from the Jwts class creates a JWT parser instance.
            // This parser is used to parse and validate the JWT token using the provided secret key.
            // If the token is valid, parsing succeeds; otherwise, an exception is thrown.
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package rest$api.authentication$authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

@SpringBootApplication
public class OAuth2RestApi {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2RestApi.class, args);
    }

    @RestController
    public class SecureController {

        // In a real application, you would store this in a secure location
        // For example, in a Spring Boot application, you would use @Value("${jwt.secret}")
        // to inject the secret key from your application.properties file or a secret manager.
        // Example: In a real app, inject this from config or env variable
        private final String SECRET_KEY = "example-super-secret-key-1234567890";
        private final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        private final JWTVerifier verifier = JWT.require(algorithm).withIssuer("my-auth-server")
                .build();
        

        @GetMapping("/secure-data")
        public ResponseEntity<String> getSecureData(@RequestHeader("Authorization") String authorizationHeader) {
            // Extract the token from the Authorization header
            String token = authorizationHeader.replace("Bearer ", "");

            // Validate the token (mock function)
            if (validateToken(token)) {
                return ResponseEntity.ok("Access Granted");
            } else {
                return ResponseEntity.status(401).body("Access Denied");
            }
        }

        // Mock token validation function
        private boolean validateToken(String token) {
            // User will implement this logic
            try {
                // This will throw an exception if the token is invalid
                // Invalid scenario:
                // 1. Token is expired
                // 2. Token is not signed with the correct algorithm
                // 3. Token is not issued by the correct issuer
                verifier.verify(token);
                return true;
            } catch (Exception e) {
                // Log the exception for debugging
                System.err.println("Token validation failed: " + e.getMessage());
                return false;
            }
        }
    }
}

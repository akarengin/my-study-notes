package rest$api.ratelimiting$throttling;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
    @RequestMapping("/test")
    public class RateLimitingController {

        private final Map<String, CopyOnWriteArrayList<Long>> clientRequests = new ConcurrentHashMap<>();

        @GetMapping
        public ResponseEntity<Map<String, String>> testEndpoint(
                @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor,
                HttpServletRequest request) {

            String clientIp = (xForwardedFor != null && !xForwardedFor.isEmpty()) ? xForwardedFor : request.getRemoteAddr();
            long currentTime = System.currentTimeMillis() / 1000L;

            clientRequests.putIfAbsent(clientIp, new CopyOnWriteArrayList<>());

            // Clean up old requests
            clientRequests.get(clientIp).removeIf(timestamp -> currentTime - timestamp >= 60);

            // Check if the client has exceeded the limit
            if (clientRequests.get(clientIp).size() >= 5) {
                return ResponseEntity.status(429).body(Map.of("error", "Rate limit exceeded. Try again later."));
            }

            // Record the current request
            clientRequests.get(clientIp).add(currentTime);

            // Simulate some processing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Return a success response
            return ResponseEntity.ok(Map.of("message", "Success"));
        }
    }
package rest$api.authentication$authorization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public String greet(HttpServletRequest request) {
        // User will write code here
        String version = request.getHeader("version");
        if (version == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "API version is required");
        }
        if (version.equals("1.0")) {
            return "Hello! World";
        } else if (version.equals("2.0")) {
            return "Hello! Universe";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid API version");
        }
    }
}
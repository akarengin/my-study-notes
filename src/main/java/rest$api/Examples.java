package rest$api;

import org.springframework.beans.factory.annotation.Value;

public class Examples {
    @Value("${my.property}") // Injects a string from properties file
    private String myString;

    public static void main(String[] args) {

    }
}

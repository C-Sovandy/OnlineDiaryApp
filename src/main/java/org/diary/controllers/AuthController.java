package org.diary.controllers;
import org.diary.model.AuthRequest;
import org.diary.model.Users;
import org.diary.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserServices userService;

//    @Autowired
    public AuthController(UserServices userService) {
        this.userService = userService;
    }
    
    @CrossOrigin(origins = "*") // Allow requests from any origin
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        Users authenticatedUser = userService.authenticateUser(username, password);

        if (authenticatedUser != null) {
            // You can generate a JWT token here if using token-based authentication
            // For simplicity, this example returns the authenticated user's details
            return ResponseEntity.ok(authenticatedUser);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}

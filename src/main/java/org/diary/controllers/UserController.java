package org.diary.controllers;

import org.diary.model.Users;
import org.diary.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    
    //Register User by Username and Email
    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        Users registeredUser = userService.registerUser(user);
        
        //If users or email is already existed, Users Object will be null
        if (registeredUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser); //create new user
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // return null//
        }
    }
    
    //Login Exist User
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestParam String username, @RequestParam String password) {
        Users authenticatedUser = userService.authenticateUser(username, password);

        if (authenticatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    
    
    //Get All Users
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
    
    //Get User By ID
    @CrossOrigin(origins = "*")
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Users user = userService.getUserById(userId);

        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    //Update User By ID
    @CrossOrigin(origins = "*")
    @PutMapping("/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable Long userId, @RequestBody Users updatedUser) {
        Users user = userService.updateUser(userId, updatedUser);

        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    
    //Delete User By ID
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

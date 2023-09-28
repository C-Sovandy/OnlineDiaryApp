package org.diary.services;

import java.util.List;
import java.util.Optional;

import org.diary.model.Users;
import org.diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	@Autowired
    private UserRepository userRepository;

	public Users createUser(Users user) {
	        // Implement user creation logic
	        return userRepository.save(user);
	 }
	 
	 
	 public Users getUserById(Long userId) {
	        // Retrieve user by ID
	        Optional<Users> optionalUser = userRepository.findById(userId);
	        return optionalUser.orElse(null);
	 }
	 
	 
	    public Users updateUser(Long userId, Users updatedUser) {
	        // Check if the user exists
	        Optional<Users> optionalUser = userRepository.findById(userId);

	        if (optionalUser.isPresent()) {
	            Users existingUser = optionalUser.get();

	            // Update user information
	            existingUser.setUsername(updatedUser.getUsername());
	            existingUser.setPassword(updatedUser.getPassword());
	            existingUser.setEmail(updatedUser.getEmail());

	            // Save the updated user
	            return userRepository.save(existingUser);
	        } else {
	            return null; // User not found
	        }
	    }
	 


//    public Users authenticateUser(String username, String password) {
//         Implement user authentication logic
//         Return the authenticated user or null if not authenticated
//    }

    public List<Users> getAllUsers() {
        // Implement logic to fetch all users
        return userRepository.findAll();
    }
    
    public void deleteUser(Long userId) {
        // Delete user by ID
        userRepository.deleteById(userId);
    }
    
    
    public Users authenticateUser(String username, String password) {
        // Implement user authentication logic
        // Return the authenticated user or null if not authenticated
        Users user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
    
    public Users registerUser(Users user) {
        // Check if the username or email is already in use
        if (userRepository.existsByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail())) {
            return null; // Username or email already exists
        } else {
            // Create and save the new user
            return userRepository.save(user);
        }
    }

    // Additional methods for user-related operations

}

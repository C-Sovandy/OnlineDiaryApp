package org.diary.model;

public class AuthRequest {

	 private String username;
	    private String password;

	    // Default constructor (needed for JSON deserialization)
	    public AuthRequest() {}

	    // Constructor with parameters
	    public AuthRequest(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    // Getter and setter methods
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

}

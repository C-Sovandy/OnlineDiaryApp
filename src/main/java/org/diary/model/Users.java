package org.diary.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;
	     	

	    @Column(unique = true)
	 	private String username;
	 	
	 	@Column
	    private String password;
	 	
	 	@Column(unique = true)
	    private String email;
	 	
	 	@Column
	 	private Boolean verified;
	 
	 
	    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Diary> diary;
//
//	     
//	 
//	    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//  	    private List<DiaryEntry> entry;
   
	   	 
	 	
	 	
		public Users(Long userId, List<Diary> diary, String username, String password,
				String email, Boolean verified) {
			super();
			this.userId = userId;
			this.diary = diary;
//			this.entry = entry;
			this.username = username;
			this.password = password;
			this.email = email;
			this.verified = verified;
		}
		
		
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		public List<Diary> getDiary() {
			return diary;
		}



		public void setDiary(List<Diary> diary) {
			this.diary = diary;
		}




		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Boolean getVerified() {
			return verified;
		}

		public void setVerified(Boolean verified) {
			this.verified = verified;
		}

	

}

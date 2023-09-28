package org.diary.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;
    
	@Column
    private String title;

	
    @Column
    private Date creationDate;
    
    @Column
    private Date happendDate;
 	
 	@Column
    private String content;
   
//    @OneToMany(mappedBy = "diary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<DiaryEntry> entries;
    
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usersId")
    private Users users;
    

    
    
	public Diary(Long diaryId, Users users, String title, String content, Date creationDate, Date happendDate) {
		super();
		this.diaryId = diaryId;
		this.users = users;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.happendDate = happendDate;

	}

	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	 public void setUsersId(Long usersId) {
	        if (this.users == null) {
	            this.users = new Users();
	        }
	        this.users.setUserId(usersId);
	    }

	 public Long getUsersId() {
	        if (this.users != null) {
	            return this.users.getUserId();
	        } else {
	            return null;
	        }
	 }
	
/*
	public void setEntries(List<DiaryEntry> entries) {
		this.entries = entries;
	}

	public List<DiaryEntry> getEntries() {
	        return entries;
	}


*/
	public Long getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(Long diaryId) {
		this.diaryId = diaryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getHappendDate() {
		return happendDate;
	}
	public void setHappendDate(Date happendDate) {
		this.happendDate = happendDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	






}

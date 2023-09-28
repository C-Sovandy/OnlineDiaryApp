package org.diary.model;

import java.sql.Date;
import org.diary.model.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


/*
public class DiaryEntry {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long entryId;
	 	
	 	@Column
	    private Date entryDate;
	 	
	 	@Column
	    private String content;
	 	
	 	@JsonIgnore
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "diaryId")
	    private Diary diary;
   
	
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "usersId")
//	    private Users users;
//	    
	 	public void setDiaryid(Long diaryId) {
	 		if (diaryId != null) {
	 		this.diary = new Diary();
	 		this.diary.setDiaryId(diaryId);
	 		
	 		}else {
	 			
	 			System.out.println("The diaryId" +"has value "+diaryId);
	 		}
	 		
	 	}
	 	
	 	public Long getDiaryId() {
	 		
	 		if (this.diary != null) {
	 			return this.diary.getDiaryId();
	 		}else {
	 			return null;
	 		}
	 		
	 	}
	    

		public Long getEntryId() {
			return entryId;
		}

		public void setEntryId(Long entryId) {
			this.entryId = entryId;
		}

		public Date getEntryDate() {
			return entryDate;
		}

		public void setEntryDate(Date entryDate) {
			this.entryDate = entryDate;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Diary getDiary() {
			return diary;
		}

		public void setDiary(Diary diary) {
			this.diary = diary;
		}



		/**
		 * @param entryId
		 * @param entryDate
		 * @param content
		 * @param diary
		 * @param user
		 */
/*
		public DiaryEntry(Long entryId, Date entryDate, String content, Diary diary) {
			super();
			this.entryId = entryId;
			this.entryDate = entryDate;
			this.content = content;
			this.diary = diary;
//			this.users = users;
		}


		public DiaryEntry() {
			super();
			// TODO Auto-generated constructor stub
		}


}

*/


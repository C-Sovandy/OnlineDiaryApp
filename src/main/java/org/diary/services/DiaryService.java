package org.diary.services;

import java.util.List;
import java.util.Optional;
import java.util.function.IntToLongFunction;

import org.diary.model.Diary;
import org.diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.diary.model.Users;
@Service
public class DiaryService {
	
	  @Autowired
	  private DiaryRepository diaryRepository;

	  
	  public Diary createDiary(Diary diary) {
	        // Implement diary creation logic
		  	
	        return diaryRepository.save(diary);
	    }

	  
	  
	    public Diary getDiaryById(Long diaryId) {
	        // Retrieve diary by ID
	        Optional<Diary> optionalDiary = diaryRepository.findById(diaryId);
	        return optionalDiary.orElse(null);
	    }
	    
	
	    public List<Diary> getDiariesByUser(Users user) {
	        return diaryRepository.findByUsers(user);
	    }
	    
	    
	   
	    public Diary updateDiary(Long diaryId, Diary updatedDiary) {
	        // Check if the diary exists
	    	 Diary existingDiary =   diaryRepository.findById(diaryId).orElse(null);

	        if (existingDiary!= null) {
	       

//	            // Update diary information
	        	 existingDiary.setTitle(updatedDiary.getTitle());
	        	 existingDiary.setContent(updatedDiary.getContent());
	        	 existingDiary.setCreationDate(updatedDiary.getCreationDate());
	        	 existingDiary.setHappendDate(updatedDiary.getHappendDate());
	        	 return diaryRepository.save( existingDiary);

	            // Save the updated diary

	        } else {
	            return null; // Diary not found
	        }
	    }


	    public List<Diary> getAllDiaries() {
	        // Retrieve all diaries
	        return diaryRepository.findAll();
	    }
	    
	    
	    public List<Diary> findByDateBetween(Date startDate, Date endDate){
//	    	Users user = new Users();

	    	//Diary diary = new Diary();
	    	

			List<Diary> diaries = diaryRepository.findByCreationDateBetween(startDate, endDate );
	    	 return diaries;
	    }
	    
	    public List<Diary> findByUsersAndCreationDateBetween(Users userId, Date startDate, Date endDate){
//	    	Users user = new Users();

	    	//Diary diary = new Diary();
	    	

			List<Diary> diaries = diaryRepository.findByUsersAndCreationDateBetween(userId, startDate, endDate );
	    	 return diaries;
	    }
	    

	    public void deleteDiary(Long diaryId) {
	        // Delete diary by ID
	        diaryRepository.deleteById(diaryId);
	    }

	    
}

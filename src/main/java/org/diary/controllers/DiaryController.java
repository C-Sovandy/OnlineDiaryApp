package org.diary.controllers;

import org.diary.services.DiaryService;
import org.diary.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import org.diary.model.Diary;
import org.diary.model.Users;

@RestController
@RequestMapping("/diary")
public class DiaryController {
	 @Autowired
	 private DiaryService diaryService;
	 
	 @Autowired
	 private UserServices userServices;

	 @CrossOrigin(origins = "*") // Allow requests from any origin
	 @PostMapping("/create")
	 public ResponseEntity<Diary> createDiary(@RequestBody Diary diary) {
	      Diary createdDiary = diaryService.createDiary(diary);
	      return ResponseEntity.status(HttpStatus.CREATED).body(createdDiary);
	 }
	 
	 @CrossOrigin(origins = "*") // Allow requests from any origin
	 @GetMapping("/all")
	 public ResponseEntity<List<Diary>> getAllDiaries() {
	        List<Diary> diaries = diaryService.getAllDiaries();
	        return ResponseEntity.status(HttpStatus.OK).body(diaries);
	 }
	 @CrossOrigin(origins = "*") // Allow requests from any origin
	 @GetMapping("/by-user")
	    public ResponseEntity<List<Diary>> getDiariesByUser(@RequestParam Users usersId) {

	        List<Diary> diaries = diaryService.getDiariesByUser(usersId);

	        if (diaries.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        } else {
	            return ResponseEntity.status(HttpStatus.OK).body(diaries);
	        }
	    }

	 @CrossOrigin(origins = "*")
	 @GetMapping("/{diaryId}")
	 public ResponseEntity<Diary> getDiaryById(@PathVariable Long diaryId) {
	    Diary diary = diaryService.getDiaryById(diaryId);

	    if (diary != null) {
	            return ResponseEntity.status(HttpStatus.OK).body(diary);
	    } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	  }
	 
	  @CrossOrigin(origins = "*")
	  @PutMapping("/{diaryId}")
	  public ResponseEntity<Diary> updateDiary(@PathVariable Long diaryId, @RequestBody Diary updatedDiary) {
	     Diary diary = diaryService.updateDiary(diaryId, updatedDiary);

	     if (diary != null) {
	            return ResponseEntity.status(HttpStatus.OK).body(diary);
	     } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	     }
	    }
	  
	 	@CrossOrigin(origins = "*")
	    @DeleteMapping("/{diaryId}")
	    public ResponseEntity<Void> deleteDiary(@PathVariable Long diaryId) {
	        diaryService.deleteDiary(diaryId);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }	
	    
	 	@CrossOrigin(origins = "*")
	    @GetMapping("/filter-by-date-range")
	    public ResponseEntity<List<Diary>> findByDateBetween(
//	    		@RequestParam Long usersId,
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)   {
	        
	    	

	        List<Diary> diaries = diaryService.findByDateBetween(startDate, endDate);

	        if (diaries.isEmpty()) {
	           // return ResponseEntity.noContent().build();
	        	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        } else {
	            return ResponseEntity.status(HttpStatus.OK).body(diaries); //ok(diaries);
	        }
	    }
	    
	 	@CrossOrigin(origins = "*")
	    @GetMapping("/filter-by-user-date-range")
	    public ResponseEntity<List<Diary>> findByByUsersAndCreationDateBetween(
	    		@RequestParam Long usersId,
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
	            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)   {
	        
	    	
	    	Users user = userServices.getUserById(usersId);
	    	
	    	if (user == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    	
	        List<Diary> diaries = diaryService.findByUsersAndCreationDateBetween(user, startDate, endDate);

	        if (diaries.isEmpty()) {
	           // return ResponseEntity.noContent().build();
	        	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        } else {
	            return ResponseEntity.status(HttpStatus.OK).body(diaries); //ok(diaries);
	        }
	    }
}

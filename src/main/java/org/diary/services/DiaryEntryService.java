package org.diary.services;

import java.util.Date;
import java.util.List;

import org.diary.model.Diary;
//import org.diary.model.DiaryEntry;
//import org.diary.repository.DiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*
@Service


public class DiaryEntryService {

	@Autowired
    private DiaryEntryRepository entryRepo;

	 	 

	
	 public List<DiaryEntry> getAllDiaryEntries() {
	        return entryRepo.findAll();
	 }

	
	 public List<DiaryEntry> getDiaryEntriesByDiary(Diary diary) {
	        return entryRepo.findByDiary(diary);
	 }

	
	 public DiaryEntry getDiaryEntryById(Long entryId) {
	        return entryRepo.findById(entryId).orElse(null);
	 }

	 
	 public DiaryEntry createDiaryEntry(DiaryEntry diaryEntry) {
	        return entryRepo.save(diaryEntry);
	 }

	 
	 public DiaryEntry updateDiaryEntry(Long entryId, DiaryEntry updatedDiaryEntry) {
		 DiaryEntry existingEntry = entryRepo.findById(entryId).orElse(null);
	     if (existingEntry != null) {
	        	 
	             // Perform updates to existingEntry based on updatedDiaryEntry
	             // You may want to add more fields to update as needed
	             existingEntry.setContent(updatedDiaryEntry.getContent());
	             // Save the updated diary entry
	             return entryRepo.save(existingEntry);
	             
	     }else{
	         
	        
	         return null; // Diary entry not found
	         
	      }
	    }

	 
	 public void deleteDiaryEntry(Long entryId) {
	    	entryRepo.deleteById(entryId);
	 }
	 
	 
	 public List<DiaryEntry> getDiariesInDateRange(Date startDate, Date endDate){
	    	 List<DiaryEntry> diaryEntries = entryRepo.findByEntryDateBetween(startDate, endDate);
	    	 return diaryEntries;
	    }
}

*/

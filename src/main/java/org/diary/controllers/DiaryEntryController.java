package org.diary.controllers;

//import org.diary.services.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

//import org.diary.model.DiaryEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/*
@RestController
@RequestMapping("/diaryentries")
public class DiaryEntryController {
	
	@Autowired
	private  DiaryEntryService diaryEntryService;



    @GetMapping
    public ResponseEntity<List<DiaryEntry>> getAllDiaryEntries() {
        List<DiaryEntry> diaryEntries = diaryEntryService.getAllDiaryEntries();
        return new ResponseEntity<>(diaryEntries, HttpStatus.OK);
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<DiaryEntry> getDiaryEntryById(@PathVariable Long entryId) {
        DiaryEntry diaryEntry = diaryEntryService.getDiaryEntryById(entryId);
        if (diaryEntry != null) {
            return new ResponseEntity<>(diaryEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    

    @PostMapping("/create")
    public ResponseEntity<DiaryEntry> createDiaryEntry(@RequestBody DiaryEntry diaryEntry) {
        DiaryEntry createdEntry = diaryEntryService.createDiaryEntry(diaryEntry);
        return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
    }
    
    

    @PutMapping("/{entryId}")
    public ResponseEntity<Void> updateDiaryEntry(
            @PathVariable Long entryId,
            @RequestBody DiaryEntry updatedDiaryEntry) {
        diaryEntryService.updateDiaryEntry(entryId, updatedDiaryEntry);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    

    @DeleteMapping("/{entryId}")
    public ResponseEntity<Void> deleteDiaryEntry(@PathVariable Long entryId) {
        diaryEntryService.deleteDiaryEntry(entryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

    @GetMapping("/filter-by-date-range")
    public ResponseEntity<List<DiaryEntry>> getDiaryEntriesInDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        
        List<DiaryEntry> diaryEntries = diaryEntryService.getDiariesInDateRange(startDate, endDate);

        if (diaryEntries.isEmpty()) {
            //return ResponseEntity.noContent().build();
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        	 
        } else {
            //return ResponseEntity.ok(diaryEntries);
        	
        	return ResponseEntity.status(HttpStatus.OK).body(diaryEntries); //ok(diaries);
        }
    }
		
}

*/

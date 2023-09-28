package org.diary.repository;
import org.diary.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import org.diary.model.Users;



@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

	 List<Diary> findByUsers(Users users); //Be careful with method name be matching with the Entity Attribute name 
	 List<Diary> findByCreationDateBetween(Date startDate, Date endDate );
	 List<Diary> findByUsersAndCreationDateBetween(Users users, Date startDate, Date endDate);
	
}
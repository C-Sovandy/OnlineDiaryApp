package org.diary.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.diary.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}

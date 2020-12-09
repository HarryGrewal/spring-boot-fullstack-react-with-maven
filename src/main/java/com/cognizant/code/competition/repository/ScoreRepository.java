package com.cognizant.code.competition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.code.competition.model.Score;

import java.util.ArrayList;

@Repository
public interface ScoreRepository extends JpaRepository<Score, String> {

	@Query(value = "SELECT u.name FROM score s INNER JOIN USERS u ON s.user_id =  u.id  WHERE s.success = true GROUP BY s.user_id order by count(*) desc limit 3", nativeQuery = true)
	ArrayList<String> findTopUsersBySuccess();

	@Query(value = "SELECT t.name FROM SCORE s INNER JOIN TASK t ON s.TASK_ID = t.id INNER JOIN USERS u ON s.USER_ID = u.id  where u.name = :name and s.success = true", nativeQuery = true)
	ArrayList<String> findTasksByUserName(@Param("name") String name);

}

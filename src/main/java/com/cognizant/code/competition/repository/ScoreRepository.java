package com.cognizant.code.competition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.code.competition.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, String> {
	
	/*
	 * @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2") Score
	 * findTopScoresBySuccessAndCount(Integer status, String name);
	 */

}

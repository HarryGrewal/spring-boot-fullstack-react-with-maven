package com.cognizant.code.competition.service.impl;

import com.cognizant.code.competition.model.rest.TopScoreResponse;
import com.cognizant.code.competition.repository.ScoreRepository;
import com.cognizant.code.competition.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	public List<TopScoreResponse> listTopScoreDetails() {
		List<String> userNames = scoreRepository.findTopUsersBySuccess();
		System.out.println("userNames" + userNames);
		List<TopScoreResponse> topScores = new ArrayList<TopScoreResponse>();


		for(String name: userNames) {
			TopScoreResponse response = new TopScoreResponse();
			List<String> tasks = scoreRepository.findTasksByUserName(name);
			response.setTasks(tasks);
			response.setSuccessCount(tasks.size());
			response.setUserName(name);
			topScores.add(response);
		}
		return topScores;
	}



}

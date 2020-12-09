package com.cognizant.code.competition.service.impl;

import com.cognizant.code.competition.model.rest.TopScoreResponse;
import com.cognizant.code.competition.repository.ScoreRepository;
import com.cognizant.code.competition.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	public List<TopScoreResponse> listTopScoreDetails() {
		// TODO Auto-generated method stub
		return null;
	}


}

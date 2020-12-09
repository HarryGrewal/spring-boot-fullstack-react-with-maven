package com.cognizant.code.competition.service;

import java.util.List;

import com.cognizant.code.competition.model.rest.TopScoreResponse;

public interface ScoreService {

	List<TopScoreResponse> listTopScoreDetails();

}

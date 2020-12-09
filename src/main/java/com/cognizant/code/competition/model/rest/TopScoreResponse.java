package com.cognizant.code.competition.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopScoreResponse {

	private String userName;
	
	private List<String> tasks;
	
	private int successCount;	
	
}

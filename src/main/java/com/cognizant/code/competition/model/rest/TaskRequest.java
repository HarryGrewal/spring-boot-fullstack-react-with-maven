package com.cognizant.code.competition.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskRequest {
	
	private String userName;

    private String languageChoice;
	
	private String compilerArgs;
	
	private String program;
	
	private String testInput;
	
	private String testOutput;
	
}

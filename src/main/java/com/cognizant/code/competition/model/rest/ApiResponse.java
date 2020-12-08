package com.cognizant.code.competition.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse {

	private String warnings;

	private String errors;

	private String result;
	
	private String stats;
	
	private String files;
	
	private String notLoggedIn;

}

package com.cognizant.code.competition.model.rest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApiRequest {

    private String languageChoice;

    private String compilerArgs;

    private String program;

    private String input;
}

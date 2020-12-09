package com.cognizant.code.competition.model.rest;

import lombok.*;

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

    private String taskId;

    private String testInput;

    private String testOutput;

}

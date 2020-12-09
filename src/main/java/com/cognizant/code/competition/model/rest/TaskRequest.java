package com.cognizant.code.competition.model.rest;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskRequest {

    private long userId;

    private long taskId;

    private String languageChoice;

    private String compilerArgs;

    private String program;

    private String testInput;

    private String testOutput;

}

package com.cognizant.fullstack.test.springbootfullstackreactwithmaven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    private String task;
    private String description;
    private String testInput;
    private String testOutput;

}

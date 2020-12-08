package com.cognizant.code.competition.model;

import javax.persistence.*;

@Entity
@Table(name = "OPERATIONS")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private String taskId;
    private String success;
}

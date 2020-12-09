package com.cognizant.code.competition.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.code.competition.model.rest.TopScoreResponse;
import com.cognizant.code.competition.service.ScoreService;

@RestController
@RequestMapping("score/")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("topScoreDetails")
    public List<TopScoreResponse> getTopScores() {
        return scoreService.listTopScoreDetails();
    }
}

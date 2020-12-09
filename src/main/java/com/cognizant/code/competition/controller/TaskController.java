package com.cognizant.code.competition.controller;

import com.cognizant.code.competition.model.Task;
import com.cognizant.code.competition.model.rest.TaskRequest;
import com.cognizant.code.competition.model.rest.TaskResponse;
import com.cognizant.code.competition.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("task/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("submitTask")
    public TaskResponse submitTask(@RequestBody TaskRequest taskRequest) throws IOException, InterruptedException {
        return taskService.submitTask(taskRequest);
    }


}

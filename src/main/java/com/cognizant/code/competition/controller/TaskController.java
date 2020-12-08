package com.cognizant.code.competition.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.code.competition.model.Task;
import com.cognizant.code.competition.model.rest.TaskRequest;
import com.cognizant.code.competition.model.rest.TaskResponse;
import com.cognizant.code.competition.service.TaskService;

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

   /* @GetMapping("getTask/{id}")
    public List<Task> getTaskByName(@PathVariable("id") String id) {
        return taskRepository.findById(id);
    }*/

    @PostMapping("submitTask")
    public TaskResponse submitTask(@RequestBody TaskRequest taskRequest) throws IOException, InterruptedException {
        return taskService.submitTask(taskRequest);
    }


}

package com.cognizant.fullstack.test.springbootfullstackreactwithmaven.controller;

import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.model.Task;
import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("task/")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("getAllTasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}

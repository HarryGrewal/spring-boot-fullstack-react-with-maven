package com.cognizant.code.competition.service;

import com.cognizant.code.competition.model.Task;
import com.cognizant.code.competition.model.rest.TaskRequest;
import com.cognizant.code.competition.model.rest.TaskResponse;

import java.io.IOException;
import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    TaskResponse submitTask(TaskRequest taskRequest) throws IOException, InterruptedException;

}

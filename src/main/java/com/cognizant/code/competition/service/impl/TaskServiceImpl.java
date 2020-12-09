package com.cognizant.code.competition.service.impl;

import java.io.IOException;
import java.util.List;

import com.cognizant.code.competition.model.User;
import com.cognizant.code.competition.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.code.competition.model.Score;
import com.cognizant.code.competition.model.Task;
import com.cognizant.code.competition.model.rest.ApiRequest;
import com.cognizant.code.competition.model.rest.TaskRequest;
import com.cognizant.code.competition.model.rest.TaskResponse;
import com.cognizant.code.competition.repository.ScoreRepository;
import com.cognizant.code.competition.repository.TaskRepository;
import com.cognizant.code.competition.service.TaskService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static com.cognizant.code.competition.util.Constants.rexterApi;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskResponse submitTask(TaskRequest taskRequest) throws IOException, InterruptedException {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setInput(taskRequest.getTestInput());
        apiRequest.setCompilerArgs(taskRequest.getCompilerArgs());
        apiRequest.setLanguageChoice(taskRequest.getLanguageChoice());
        apiRequest.setProgram(taskRequest.getProgram());

        TaskResponse taskResponse = new TaskResponse();
        try {
            String postUrl = rexterApi;
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(apiRequest));
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity, "UTF-8");

            System.out.println("content :" + content);
            JsonElement element = gson.fromJson (content, JsonElement.class);
            JsonObject res = element.getAsJsonObject();
            //API return with result as below which contains \n in result
            //content :{"Warnings":null,"Errors":null,"Result":"true\n","Stats":"Compilation time: 1.02 sec, absolute running time: 0.26 sec, cpu time: 0.26 sec, memory peak: 41 Mb, absolute service time: 1,42 sec","Files":null,"NotLoggedIn":false}
            String result = res.get("Result").toString().replace("\"", "");
            result  = result.replace("\\n", "");

            String error = res.get("Errors").toString();

            if(res != null && res.get("Errors").isJsonNull() &&  StringUtils.equals(result, taskRequest.getTestOutput())) {
                taskResponse.setSuccess(true);
                //Save item to DB
                System.out.println("Result: " + result + " & testOutput: " + taskRequest.getTestOutput() + " is matching");
            } else {
                taskResponse.setSuccess(false);
                taskResponse.setError(error);
                System.out.println("Result: " + result + " & testOutput: " + taskRequest.getTestOutput() + " is not matching");
            }


            Score score = populateScoreDetails(taskRequest, taskResponse);
            scoreRepository.save(score);
            System.out.println(error);
        } catch (Exception ex) {
        } finally {
        }
        return taskResponse;
    }

    private Score populateScoreDetails(TaskRequest taskRequest, TaskResponse taskResponse) {
        Score score = new Score();
        score.setTaskId(taskRequest.getTaskId());
        final User user = userRepository.findByName(taskRequest.getUserName());
        score.setUserId(user.getId());
        score.setSuccess(taskResponse.isSuccess());
        return score;
    }

}

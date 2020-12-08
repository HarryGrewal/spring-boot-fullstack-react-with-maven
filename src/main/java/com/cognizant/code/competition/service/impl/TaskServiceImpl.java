package com.cognizant.code.competition.service.impl;

import java.io.IOException;
import java.util.List;

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

import com.cognizant.code.competition.model.Task;
import com.cognizant.code.competition.model.rest.ApiRequest;
import com.cognizant.code.competition.model.rest.TaskRequest;
import com.cognizant.code.competition.model.rest.TaskResponse;
import com.cognizant.code.competition.repository.TaskRepository;
import com.cognizant.code.competition.service.TaskService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

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
			String postUrl = "https://rextester.com/rundotnet/api";// put in your url
			Gson gson = new Gson();
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(postUrl);
			StringEntity postingString = new StringEntity(gson.toJson(apiRequest));
			post.setEntity(postingString);
			post.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			entity.getContent().toString();
			// Read the contents of an entity and return it as a String.
			String content = EntityUtils.toString(entity, "UTF-8");

			System.out.println("content :" + content);
			JsonElement element = gson.fromJson (content, JsonElement.class); 
			JsonObject res = element.getAsJsonObject();
			//API return with result as below which contains \n in result
			//content :{"Warnings":null,"Errors":null,"Result":"true\n","Stats":"Compilation time: 1.02 sec, absolute running time: 0.26 sec, cpu time: 0.26 sec, memory peak: 41 Mb, absolute service time: 1,42 sec","Files":null,"NotLoggedIn":false}
			String result = res.get("Result").toString().replace("\"", "");
			result  = result.replace("\\n", "");
			
			if(res != null && res.get("Errors").isJsonNull() &&  StringUtils.equals(result, taskRequest.getTestOutput())) {
				taskResponse.setSuccess(true);
				
				//Save item to DB
				System.out.println("Result: " + result + " & testOutput: " + taskRequest.getTestOutput() + " is matching");
			} else {
				taskResponse.setSuccess(false);
				System.out.println("Result: " + result + " & testOutput: " + taskRequest.getTestOutput() + " is not matching");
			}
			
		} catch (Exception ex) {
		} finally {
		}
		return taskResponse;
	}

}

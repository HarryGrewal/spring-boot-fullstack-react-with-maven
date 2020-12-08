package com.cognizant.code.competition;

import com.cognizant.code.competition.model.User;
import com.cognizant.code.competition.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeCompetitionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CodeCompetitionApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Harry", "test", "harbans_grewal@hotmail.com"));
		this.userRepository.save(new User("Tom","test", "tom_cruise@yahoo.com"));
		this.userRepository.save(new User("Tony", "test","tony@gmail.com"));

	}
}

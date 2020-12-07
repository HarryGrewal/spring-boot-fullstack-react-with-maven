package com.cognizant.fullstack.test.springbootfullstackreactwithmaven.repository;

import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

}

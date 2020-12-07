package com.cognizant.fullstack.test.springbootfullstackreactwithmaven.repository;

import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

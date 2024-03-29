package com.ledinh.springdatamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ledinh.springdatamysql.entity.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepoitory extends JpaRepository<User, Integer>{
	
}

package com.dinhle.testmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinhle.testmicroservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

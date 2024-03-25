package com.dinhle.testmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinhle.testmicroservice.model.Student;
import com.dinhle.testmicroservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(int id){
		return studentRepository.findById(id);
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}

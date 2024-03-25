package com.dinhle.testmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dinhle.testmicroservice.model.Student;
import com.dinhle.testmicroservice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int student_id){
		return studentService.getStudentById(student_id)
				.orElseThrow(() -> new RuntimeException("Not found student!" + student_id));
	}
	
	@PostMapping("")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
	}
}

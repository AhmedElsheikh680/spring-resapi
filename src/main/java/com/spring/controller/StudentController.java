package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.StudentError;
import com.spring.exception.StudentException;
import com.spring.model.Student;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	private List<Student> students = new ArrayList<>();
	
	@PostConstruct
	public void start() {
		Student s1 = new Student(1, "Ahmed", "010");
		Student s2 = new Student(2, "Mohamed", "010");
		Student s3 = new Student(3, "Ayman", "010");
		Student s4 = new Student(4, "Sayed", "010");
		Student s5 = new Student(5, "Hassan", "010");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
	}

	// http://localhost:8085/spring-restapi/api/v1/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		if(id <=0 || id> students.size()) {
			throw new StudentException("Student Not Found ID: " + id);
		}
		
		return students.get(id-1);
	}
	
	@GetMapping("/studentId")
	public Student getStudentById(@RequestParam int id) {
		return students.get(id -1);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentError> getExceptionNotFound(StudentException studentException) {
		StudentError studentError = new StudentError();
		studentError.setStatuscode(HttpStatus.NOT_FOUND.value());
		studentError.setMessage(studentException.getMessage());
		studentError.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentError>(studentError, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<StudentError> getException(Exception e) {
		StudentError studentError = new StudentError();
		studentError.setStatuscode(HttpStatus.BAD_REQUEST.value());
		studentError.setMessage(e.getMessage());
		studentError.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentError>(studentError, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

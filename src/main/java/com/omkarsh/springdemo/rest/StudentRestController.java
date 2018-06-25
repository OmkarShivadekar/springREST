package com.omkarsh.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omkarsh.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	
	
	//define @Postconstruct to load the student data... only once!
	@PostConstruct
	public void loadData()
	{
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Omkar", "Shivadekar"));
		theStudents.add(new Student("Himanshu", "Patel"));
		theStudents.add(new Student("Sarang", "Kamble"));
	}
	
	//define endpoint for /students
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return theStudents;
	}

	//define endpoint for "/students/{studentId}" return student at index 
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		
		//check the student id against list size
		if((studentId >= theStudents.size()) || (studentId<0))
		{
			throw new StudentNotFoundException("Student not found - "+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

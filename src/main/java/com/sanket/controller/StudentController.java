package com.sanket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.service.StudentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getListOfCourse() throws CourseException{ 
		
		List<Course> listOfCourse = studentService.listOfCourses();
		
		return new ResponseEntity<List<Course>>(listOfCourse, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getSpecificCourse(@PathVariable Integer id) throws CourseException {
		
		Course registerCourse = studentService.getCourseUsingId(id);
		
		
		return new ResponseEntity<Course>(registerCourse, HttpStatus.OK);
		
	}
	
}






























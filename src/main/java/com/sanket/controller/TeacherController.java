package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	
	@PostMapping("/course")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) throws CourseException {
		
		Course registerCourse = teacherService.createCourse(course);
		
		return new ResponseEntity<Course>(registerCourse, HttpStatus.CREATED);
	}
	
	@PutMapping("/course")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseException{
		
		Course updatedCourse = teacherService.updateCourse(course);
		
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.CREATED);
	}

}

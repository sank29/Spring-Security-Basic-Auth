package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.service.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable Integer id) throws CourseException {
		
		
	 	Course deletedCourse = adminService.deleteCourse(id);
	 	
	 	
	 	return new ResponseEntity<Course>(deletedCourse, HttpStatus.ACCEPTED);
	 	
	 	
	}

}

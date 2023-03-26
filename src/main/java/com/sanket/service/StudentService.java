package com.sanket.service;

import java.util.List;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;

public interface StudentService {
	
	public List<Course> listOfCourses() throws CourseException;
	
	public Course getCourseUsingId(Integer id) throws CourseException;

}

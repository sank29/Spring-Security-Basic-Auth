package com.sanket.service;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;

public interface TeacherService {
	
	Course createCourse(Course course) throws CourseException;
	
	Course updateCourse(Course course) throws CourseException;

}

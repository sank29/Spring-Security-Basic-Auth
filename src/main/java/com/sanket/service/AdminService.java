package com.sanket.service;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;

public interface AdminService {
	
	Course deleteCourse(Integer courseId)throws CourseException;

}

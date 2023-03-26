package com.sanket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.repository.CourseDao;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	CourseDao courseDao;

	@Override
	public Course createCourse(Course course) throws CourseException {
		
		Optional<Course> registerCourse = courseDao.findById(course.getCourseId());
		
		
		if(registerCourse.isEmpty()) {
			
			return courseDao.save(course);
			
		}else {
			
			 throw new CourseException("Course already register with this id " + course.getCourseId());
		}
		
		
	}

	@Override
	public Course updateCourse(Course course) throws CourseException {
		
		Optional<Course> registerCourse = courseDao.findById(course.getCourseId());
		
		
		if(registerCourse.isPresent()) {
			
			
			return courseDao.save(course);
			
		}else {
			
			throw new CourseException("No course fond with this id " + course.getCourseId() + " to update");
			
		}
		
	}
	
	

}

package com.sanket.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.repository.CourseDao;



@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	CourseDao courseDao;

	@Override
	public Course deleteCourse(Integer courseId) throws CourseException {
		
		
		Optional<Course> findCourse = courseDao.findById(courseId);
		
		
		
		if(findCourse.isPresent()) {
			
			courseDao.delete(findCourse.get());
			
			return findCourse.get();
			
			
		}else {
			
			throw new CourseException("No course fond with this id " + courseId);
			
		}
	}

}

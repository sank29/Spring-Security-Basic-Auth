package com.sanket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.entity.Course;
import com.sanket.exception.CourseException;
import com.sanket.repository.CourseDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	CourseDao courseDao;

	@Override
	public List<Course> listOfCourses() throws CourseException {
		
		List<Course> listOfCourse = courseDao.findAll();
		
		if(!listOfCourse.isEmpty()) {
			
			return listOfCourse;
			
		}else {
			
			throw new CourseException("No course found in database");
		}
		
		
	}

	@Override
	public Course getCourseUsingId(Integer id) throws CourseException {
		
		Optional<Course> returnCourse = courseDao.findById(id);
		
		
		if(returnCourse.isPresent()) {
			
			
			return returnCourse.get();
			
		}else {
			
			throw new CourseException("Not course found with this id " + id);
		}
	}

}








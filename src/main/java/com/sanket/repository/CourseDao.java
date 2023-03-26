package com.sanket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{

}

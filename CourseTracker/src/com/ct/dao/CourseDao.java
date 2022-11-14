package com.ct.dao;

import java.util.List;


import com.ct.model.Course;
import com.ct.model.CoursePlan;

public interface CourseDao {

	public  String createCourse(Course c);
	
	public List<Course> viewCourse();
	
	public String updateCourse(String coursename ,String newCourseName, int fee,String courseDesc);
	
	public String deleteCourse(String courseName);
	
	public boolean courseExists(String courseName);
	
	
}


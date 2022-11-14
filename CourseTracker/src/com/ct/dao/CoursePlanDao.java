package com.ct.dao;

import java.util.List;


import com.ct.model.CoursePlan;

public interface CoursePlanDao {

	public String createCoursePlan(CoursePlan c);
	
	public String updateCoursePlan(String batchid,int dayNumber,CoursePlan c);
	
	public List<CoursePlan> viewCourseByFaculty( int id);
	
}


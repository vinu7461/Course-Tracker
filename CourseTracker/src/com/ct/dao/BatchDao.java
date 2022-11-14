package com.ct.dao;

import java.util.List;


import com.ct.exceptions.CourseException;
import com.ct.model.Batch;
import com.ct.model.Batch_Course;
import com.ct.model.Batch_CoursePlan;
import com.ct.model.Batch_Report;

public interface BatchDao {

	public String createBatch(Batch b)throws CourseException;
	
	public String updateBatch(String course,int facultyid,int numberOfStudents,String batchStart,int duration,String oldbid);
	
	public boolean batchExists(String batchid);
	
	public List<Batch_Course> viewBatch(String s);
	
	public String delectBatch(String bid);
	
	public List<Batch_CoursePlan> dayWiseUpdate(int daynumber);
	
	public List<Batch_Report> batchReport();
}


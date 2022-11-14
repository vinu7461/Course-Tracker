package com.ct.dao;

import java.util.List;


import com.ct.exceptions.FacultyException;
import com.ct.exceptions.PatternException;
import com.ct.model.Faculty;

public interface FacultyDao {

	public String createFaculty(Faculty f)throws PatternException;
	
    public boolean facultyExists(int fid);
	
	public String updateFaculty(int id,Faculty f) throws PatternException, FacultyException;
	
	public String allocateFaculty(int fid, String batchid);
	
	public int facultyLogin(String usernsme,String password);
	
	public String fillDayPlan(String batchid,int day,int facultyid,String x);
	
	public String updateFacultyPassword (int id,String oldpassword,String newPassword); 

    public List<Faculty> viewAllFaculty();
    
    public String deleteFaculty(int fid);
}


package com.ct.dao;

import com.ct.exceptions.EmployeeException;

public interface AdministratorDao {

	public boolean adminLogin(String username,String password)throws EmployeeException;
	
	
	
}


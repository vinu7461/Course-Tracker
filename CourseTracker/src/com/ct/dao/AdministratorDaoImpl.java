package com.ct.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ct.exceptions.EmployeeException;
import com.ct.utility.DButil;
//import com.mysql.cj.xdevapi.PreparableStatement;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public boolean adminLogin(String username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from admin where username=? AND password=?");
			
		ps.setString(1, username);
		ps.setString(2, password);
		
	ResultSet	rs=ps.executeQuery();
	
	boolean flag=false;
	
	while(rs.next()) {
		flag= true;
		return true;
	}
			if(flag==false) {
				throw  new EmployeeException("Invalid Credentials ");
			}
	
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();

		}
		
		
		
		return false;
	}

}

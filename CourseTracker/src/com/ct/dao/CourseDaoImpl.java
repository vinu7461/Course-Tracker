package com.ct.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.model.Course;
import com.ct.model.CoursePlan;
import com.ct.utility.DButil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String createCourse(Course c) {
		// TODO Auto-generated method stub
		
		String message="course already present";
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement ps=conn.prepareStatement("insert into course (courseName,fee,courseDescription) values(?,?,?)");
			
		        ps.setString(1, c.getCourseName());
		        ps.setInt(2,c.getFee());
		        ps.setString(3, c.getDescription());
		        
		       int x= ps.executeUpdate();
		       
		       if(x>0) {
		    	   message="course added successfully";
		       }
		       
		        
		
		} catch (SQLException e) {
			// TODO: handle exception
//			System.out.println(e.getMessage());
			e.getMessage();
		}
		
		return message;
	}

//============================viewCourse================================	

	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		
		List<Course> lic=new ArrayList<>();
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from course");
		
	ResultSet rs=ps.executeQuery();
	
	   while(rs.next()) {
		   
		   int cid=rs.getInt("courseid");
		   String cn=rs.getString("courseName");
		   int fee=rs.getInt("fee");
		   String desc=rs.getString("courseDescription");
		   
		   
		   Course c=new Course(cid, cn, fee, desc);
		   
		   lic.add(c);
		   
	   }
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		return lic;
	}
//================================updateCourse=============================


	@Override
	public String updateCourse(String coursename, String newCourseName, int fee, String courseDesc) {
		// TODO Auto-generated method stub
		
		String msg="course not found";
		
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update course set coursename=?,fee=?,courseDescription=? where courseName=?");
			
			                      ps.setString(1, newCourseName);
			                      ps.setInt(2, fee);
			                      ps.setString(3, courseDesc);
			                      ps.setString(4, coursename);
			                      
			                      int x=ps.executeUpdate();
			                      
			                      if(x>0) {
			                    	  msg="course updated successfully";
			                      }
			                        
			
				
			     
			       }
			       
			         catch (SQLException e) {
				// TODO: handle exception
				msg="This course already present";
			}
		
		
		return msg;
	}

//================================delectCourse===========================

	@Override
	public String deleteCourse(String courseName) {
		// TODO Auto-generated method stub


    String msg="course not found";
	
    
    try (Connection conn=DButil.provideConnection()){
		
		PreparedStatement ps=conn.prepareStatement("delete from course where coursename=? ");
		
		     ps.setString(1,courseName);
		     
		    int x= ps.executeUpdate();
		    
		    if(x>0) {
		    	msg="Course Delect Successfully";
		    }
			
		     
		       }
		       
		         catch (SQLException e) {
			// TODO: handle exception
			msg=e.getMessage();
		}
    
		return msg;
	}

//=================================courseExists===========================

	@Override
	public boolean courseExists(String courseName) {
		// TODO Auto-generated method stub
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement	ps=conn.prepareStatement("select * from course where courseName=?");
			
			 ps.setString(1,courseName);
			 
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				return true;
			}
			
			
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			return false;
			
	}



	

}

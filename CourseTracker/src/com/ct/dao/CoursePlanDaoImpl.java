package com.ct.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.model.CoursePlan;
import com.ct.utility.DButil;

public class CoursePlanDaoImpl implements CoursePlanDao {

	@Override
	public String createCoursePlan(CoursePlan c) {
		// TODO Auto-generated method stub
		
		String msg="CoursePlan not Generated";
		
		try (Connection conn = DButil.provideConnection()){
			
			
		PreparedStatement	ps=conn.prepareStatement("insert into courseplan (batchid,daynumber,topic,status) values (?,?,?,?)");
			
		ps.setString(1, c.getBatchId());
		ps.setInt(2, c.getDaynumber());
		ps.setString(3, c.getTopic());
		ps.setString(4, c.getStatus());
		
		  int x=ps.executeUpdate();
		  
		  if(x>0) {
			  msg="coursePlan Generated";
		  }
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("course plan exists");
		}
		
		return msg;
	}

	@Override
	public String updateCoursePlan(String batchid, int dayNumber,CoursePlan c) {
		// TODO Auto-generated method stub
		
		String msg=" No coursePlan generated for this day ";
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("update courseplan set batchid=?,daynumber=?,topic=?,status=?"
				                 	+ " where batchid=? AND daynumber=?");
			ps.setString(1, c.getBatchId());
			ps.setInt(2, c.getDaynumber());
			ps.setString(3, c.getTopic());
			ps.setString(4, c.getStatus());
			ps.setString(5, batchid);
			ps.setInt(6, dayNumber);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				msg="course plan updated";
			}
		  
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		return msg;
	}
	
	@Override
	public List<CoursePlan> viewCourseByFaculty(int id) {
		// TODO Auto-generated method stub
		
		List<CoursePlan> li= new ArrayList<>();
		
		
		try (Connection conn = DButil.provideConnection()){

			   PreparedStatement ps =conn.prepareStatement("select planid,batch.batchid,coursename,daynumber,"
			     		             + "topic,status from faculty inner join batch inner join"
			     		             + " courseplan inner join course on faculty.facultyid=batch.facultyid"
			     		             + " AND batch.batchid=courseplan.batchid AND Course.courseid=batch.courseid"
			     		             + " where faculty.facultyid=?");
			     
	                      
			   ps.setInt(1, id);
			   
			 ResultSet rs =ps.executeQuery();
			 
			 while(rs.next()) {
				 
				 
			     int	planId =rs.getInt(1);
				 String batchId =rs.getString(2);
				 String courseName=rs.getString(3);
				 int	daynumber =rs.getInt(4);
				 String	topic = rs.getString(5);
			     String	status = rs.getString(6);
			     
			     CoursePlan cp=new CoursePlan(planId, batchId, daynumber, topic, status, courseName);
			     
			     li.add(cp);
				 
				 
			 }
			            
			
			 
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		
		return li;
	}

	@Override
	public List<CoursePlan> viewAllCoursePlan() {
		// TODO Auto-generated method stub
		
		List<CoursePlan> li =new ArrayList<>();
		
		try (Connection conn =DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from courseplan");
			
		ResultSet rs=ps.executeQuery();
			
		while(rs.next()) {
			
			int planid=rs.getInt(1);;
			String batchid=rs.getString(2);
			int day=rs.getInt(3);
			String topic =rs.getString(4);
			String status=rs.getString(5);
			
			CoursePlan cp=new CoursePlan(planid, batchid, day, topic, status);
			
			li.add(cp);
			
		}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Invalid input");
		}
		
		return li;
	}
	
	

}


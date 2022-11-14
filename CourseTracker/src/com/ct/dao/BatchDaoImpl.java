package com.ct.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.exceptions.CourseException;
import com.ct.model.Batch;
import com.ct.model.Batch_Course;
import com.ct.model.Batch_CoursePlan;
import com.ct.model.Batch_Report;
import com.ct.utility.DButil;

public class BatchDaoImpl implements BatchDao {

	@Override
	public String createBatch(Batch b) throws CourseException {
		// TODO Auto-generated method stub
		
		String msg="Batch Not Added";
		
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("insert into batch (batchid,courseid,numberOfStudents,batchStartDate,duration) values (?,?,?,?,?)");
			
		      ps.setString(1, b.getBatchid());
		      
		      try {
		    PreparedStatement	ps1 = conn.prepareStatement("select courseid from course where courseName=? ");
		    	  
		    ps1.setString(1, b.getCourseid());
		    
		   ResultSet rs=ps1.executeQuery();
		   
		   if(rs.next()) {
			   
			   ps.setInt(2, rs.getInt("courseid"));
			   
		   }else {
			   throw new CourseException("course not found");
		   }
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new CourseException("course not found");
			}
		      
		      
		      
		      ps.setInt(3, Integer.parseInt(b.getNumberOfStudents()));
		      
		      ps.setString(4, b.getBatchStartDate());
		      
		      ps.setInt(5, Integer.parseInt(b.getDuration()));
		      
		   int x=ps.executeUpdate();
		   
		   if(x>0) {
			   msg="batch added successfully";
		   }
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg="batch already exists";
			
		}
		
		return msg;
	}

//	============================update batch=============================

	@Override
	public String updateBatch(String course,int facultyid,int numberOfStudents,String batchStart,int duration,String oldbid) {
		
		// TODO Auto-generated method stub
		
		String msg="Batch not updated";
		
		try (Connection conn=DButil.provideConnection()){
			
			BatchDao bd=new BatchDaoImpl();
			CourseDao cd=new CourseDaoImpl();
			FacultyDao fd=new FacultyDaoImpl();
			try {
				int courseid=0;
				if(bd.batchExists(oldbid)) {
					
					if(cd.courseExists(course)) {
						
				PreparedStatement	ps1=conn.prepareStatement("select courseid from course where coursename=?");
				                        
				                      ps1.setString(1, course);
				                      
				                      ResultSet rs=ps1.executeQuery();
				                      
				                      if(rs.next()) {
				                    	   courseid=rs.getInt(1);
				                      }
						
						if(fd.facultyExists(facultyid)) {
							
							
							
							PreparedStatement	ps=conn.prepareStatement("update batch set "
	                                  + " courseid=?,facultyid=?,numberOfStudents=?,batchStartDate=?,duration=? where batchid=? ");

                     
                       ps.setInt(1, courseid);
                       ps.setInt(2, facultyid);
                       ps.setInt(3, numberOfStudents);
                       ps.setString(4, batchStart);
                       ps.setInt(5, duration);
                       ps.setString(6, oldbid);
                       
                       
                       int x=ps.executeUpdate();
                       
                       if(x>0) {
                    	   msg="batch updated";
                       }
						}else {
							msg="faculty not exists";
						}
					}else {
						msg="course not exists";
					}
					
				}else {
					msg="batch not exists";
				}
				
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				msg="Invalid Input";
			}
			
			
			
		
		                  
		
		} catch (SQLException e) {
			// TODO: handle exception
			msg="Invalid Input";
		}
		
		return msg;
	}

//============================view batch===============================	
	
	@Override
	public List<Batch_Course> viewBatch(String c) {
		// TODO Auto-generated method stub
		
		List<Batch_Course> li=new ArrayList<>();
		
		
		try(Connection conn = DButil.provideConnection()) {
			
		PreparedStatement	ps=conn.prepareStatement(" select batchid,course.courseid,coursename,facultyid,"
				                                     + "numberOfStudents,batchStartDate,Duration from batch "
				                                     + "Inner Join course on batch.courseid=course.courseid "
				                                     + "where coursename=?");
		
		                 ps.setString(1, c);
		                 
		                ResultSet rs=ps.executeQuery();
		                
		                while(rs.next()) {
		                	
		                	String bid=rs.getString(1);
		                	int cid=rs.getInt(2);
		                	String cname=rs.getString(3);
		                	int fid=rs.getInt(4);
		                	int ns=rs.getInt(5);
		                	String bsd=rs.getString(6);
		                	int d=rs.getInt(7);
		                	
		                	Batch_Course bc=new Batch_Course(bid, cid, cname, fid, ns, bsd, d);
		                	
		                	li.add(bc);
		                	
		                }
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		return li;
	}
	
//=================================delete batch============================	
	
	@Override
	public String delectBatch(String bid) {
		// TODO Auto-generated method stub
		
		String msg="batch not delect";
		
		try (Connection conn =DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from batch where batchid=?");
			
			ps.setString(1,bid);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				msg="batch delect successfully";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Invalid Input");
		}
		
		
		return msg;
	}

	
	
//=============================batch exists=============================	

	@Override
	public boolean batchExists(String batchid) {
		// TODO Auto-generated method stub
		

		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from batch where batchid=?");
		
		 ps.setString(1,batchid);
		 
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
//===========================day plan================================	

	@Override
	public List<Batch_CoursePlan> dayWiseUpdate(int daynumber) {
		// TODO Auto-generated method stub
		
	List<Batch_CoursePlan> li=new ArrayList<>();
	
        
	try(Connection conn=DButil.provideConnection()) {
		
	PreparedStatement ps=conn.prepareStatement(" select batch.batchid,daynumber,topic,status from "
			                	+ "batch inner join courseplan on batch.batchid=courseplan.batchid"
			                	+ " group by batch.batchid,daynumber having daynumber=? order by batch.batchid");
		
	 
	                ps.setInt(1, daynumber);

	               ResultSet rs=ps.executeQuery();
	               
	               while(rs.next()) {
	            	
	            	   String batchid=rs.getString(1);
	            	   int day=rs.getInt(2);
	            	   String topic=rs.getString(3);
	            	   String statu=rs.getString(4);
	            	   
	            	   Batch_CoursePlan bcd=new Batch_CoursePlan(batchid, day, topic, statu);
	            	   
	            	  li.add(bcd);
	            	  
	            	   
	               }
	                
		
		
		
	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
		
		return li;
	}

//================================batch report=============================	
	
	@Override
	public List<Batch_Report> batchReport() {
		// TODO Auto-generated method stub
		
		List<Batch_Report> br=new ArrayList<>();
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select batch.batchid,coursename,facultyname,numberOfStudents,"
				                                    + "batchStartDate ,count(*) from faculty inner join batch inner join"
				                                    + " course inner join courseplan on course.courseid=batch.courseid"
				                                    + " AND batch.facultyid=faculty.facultyid AND batch.batchid=courseplan.batchid "
				                                    + "group by batch.batchid order by batch.batchid");
			
		                       ResultSet rs1=ps.executeQuery();
		                       
		                   ;
		                       
		   while(rs1.next()) {
			   
			   String batchid=rs1.getString(1);
			   String coursename=rs1.getString(2);
			   String facultyname=rs1.getString(3);
			   int noOfStudents =rs1.getInt(4);
			   String batchStartDate=rs1.getString(5);
			   int totalDaysGen=rs1.getInt(6);
			
			   
			  PreparedStatement ps1=conn.prepareStatement("select count(*)  from faculty inner join batch inner join course inner join courseplan on course.courseid=batch.courseid AND batch.facultyid=faculty.facultyid AND batch.batchid=courseplan.batchid where status=\"completed\" AND batch.batchid=?  group by batch.batchid order by batch.batchid ");
			  
			       ps1.setString(1,batchid);
			  
			     ResultSet rs2=ps1.executeQuery();
			     
			     double completed=0;
			     
			     while(rs2.next()) {
			    	 
			    	 completed=rs2.getInt(1);
			    	 
			     }
			     
			     double completionPercent=0;
			     
			     if(completed!=0) {
			     
			     completionPercent=((completed/(double)totalDaysGen)*100);
			     
			     }
			
			     Batch_Report br1=new Batch_Report(batchid, coursename, facultyname, noOfStudents, batchStartDate, totalDaysGen, completionPercent);
			     
			     br.add(br1);
			     
			     
			   
			   
			   
		   }
		
		
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return br;
	}

	
}

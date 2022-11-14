package com.ct.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ct.exceptions.FacultyException;
import com.ct.exceptions.PatternException;
import com.ct.model.Batch_Course;
import com.ct.model.Faculty;
import com.ct.utility.DButil;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public String createFaculty(Faculty f) throws PatternException {
		// TODO Auto-generated method stub
		
		String msg="Not added";
		
		try(Connection conn=DButil.provideConnection()) {
			
			
		PreparedStatement	ps=conn.prepareStatement("insert into faculty (facultyname,facultyaddress"
				                                   + ",mobile,email,username,password) values "
				                                   + "(?,?,?,?,?,?)");
		
		 ps.setString(1, f.getFacultyname());
		 ps.setString(2, f.getFacultyaddress());
		 
		 try {
			 
		 if(Pattern.matches("[789]{1}[0-9]{9}", f.getMobile())) {
			 
			 ps.setString(3, f.getMobile());
		 }else {
			 throw new PatternException("enter valid mobile number");
		 }
		 
		 }catch (PatternException e) {
			// TODO: handle exception
			 System.out.println(e.getMessage());
			 throw new PatternException("enter  valid cred");
			
			
		}  
		 
		 
		 try {
			 
			 if(Pattern.matches("[a-zA-Z0-9._]{3,}@[a-zA-Z]{3,}[.]{1}[a-zA-Z.]{2,6}", f.getEmail())) {
				 
				 ps.setString(4, f.getEmail());
			 }else {
				 throw new PatternException("enter valid email");
			 }
			 
			 }catch (PatternException e) {
				// TODO: handle exception
				 throw new PatternException("enter  val email");
				
			}  
		 
        try {
			 
			 if(Pattern.matches("[a-zA-Z0-9]{4,}", f.getUsername())) {
				 
				 ps.setString(5, f.getUsername());
			 }else {
				 throw new PatternException("enter valid username");
			 }
			 
			 }catch (SQLException e) {
				// TODO: handle exception
				 throw new PatternException("user name not available");
				
			}  
        
        ps.setString(6, f.getPassword());
        
        
       int x =ps.executeUpdate();

       if(x>0) {
    	   msg="faculty added";
       }
		 
		
		
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		msg="check credentials";
		}
		
		return msg;
	}

//==============================update faculty========================

	
	@Override
	public String updateFaculty(int id, Faculty f) throws PatternException ,FacultyException  {
		// TODO Auto-generated method stub
		
		String msg="Faculty not updated";
		
	
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement	ps1=conn.prepareStatement("select * from faculty where facultyid=?");
			
			  ps1.setInt(1, id);
			  
			 ResultSet rs=ps1.executeQuery();
			 
			 while(rs.next()) {
				 PreparedStatement	ps=conn.prepareStatement("update faculty set facultyname=?,facultyaddress=?,"
							+ "mobile=?,email=?,username=?,password=? where facultyid=?" );
					
					
					
					
					

					 ps.setString(1, f.getFacultyname());
					 ps.setString(2, f.getFacultyaddress());
					 
					 try {
						 
					 if(Pattern.matches("[789]{1}[0-9]{9}", f.getMobile())) {
						 
						 ps.setString(3, f.getMobile());
					 }else {
						 throw new PatternException("enter valid mobile number");
					 }
					 
					 }catch (PatternException e) {
						// TODO: handle exception
						 System.out.println(e.getMessage());
						 throw new PatternException("enter  valid credentials");
						
						
					}  
					 
					 
					 try {
						 
						 if(Pattern.matches("[a-zA-Z0-9._]{3,}@[a-zA-Z]{3,}[.]{1}[a-zA-Z.]{2,6}", f.getEmail())) {
							 
							 ps.setString(4, f.getEmail());
						 }else {
							 throw new PatternException("enter valid email");
						 }
						 
						 }catch (PatternException e) {
							// TODO: handle exception
							 throw new PatternException("enter  valid email");
							
						}  
					 
			        try {
						 
						 if(Pattern.matches("[a-zA-Z0-9]{3,}", f.getUsername())) {
							 
							 ps.setString(5, f.getUsername());
						 }else {
							 throw new PatternException("enter valid username");
						 }
						 
						 }catch (PatternException e) {
							// TODO: handle exception
							 throw new PatternException("user name not available");
							
						}  
			        
			        ps.setString(6, f.getPassword());
			        ps.setInt(7, id);
			        
			        
			       int x =ps.executeUpdate();

			       if(x>0) {
			    	   msg="faculty updated";
			       }
					 
					
		
					
			 }
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Invaid Input");
				
			
			}
		
		
		
		
		
		
		return msg;
	}

//===================================allocate faculty=================


	@Override
	public String allocateFaculty(int fid, String batchid) {
		// TODO Auto-generated method stub
		
		String msg="faculty not allocate";
		
		try (Connection conn=DButil.provideConnection()){
			
			
		
			
		PreparedStatement	ps=conn.prepareStatement("update batch set facultyid=? where batchid=?");
		
		ps.setInt(1, fid);
		ps.setString(2, batchid);
		
		int x=ps.executeUpdate();
		
		if(x>0) {
			msg="faculty allocate successfully";
		}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		return msg;
	}




	@Override
	public boolean facultyExists(int fid) {
		// TODO Auto-generated method stub
		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from faculty where facultyid=?");
		
		 ps.setInt(1, fid);
		 
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




	@Override
	public int facultyLogin(String usernsme, String password) {
		// TODO Auto-generated method stub
	
		int id=0;
		
		try (Connection conn =DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select facultyid from faculty where username=? AND password=? ");
			
		       ps.setString(1, usernsme);
		       ps.setString(2, password);

		      ResultSet rs=ps.executeQuery();
		      
		      if(rs.next()) {
		    	  
		    	  return  id=rs.getInt(1);
		    	  
		      }
		       
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		
		return id;
	}




	@Override
	public String fillDayPlan(String batchid, int day, int facultyid, String x) {
		// TODO Auto-generated method stub
		String msg="status not updated";
		
		try (Connection conn =DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from courseplan inner join batch inner join faculty on courseplan.batchid=batch.batchid AND"
					+ " batch.facultyid=faculty.facultyid where faculty.facultyid=? AND batch.batchid=? AND"
					+ " courseplan.daynumber=? AND status != ?");
			
	     ps.setInt(1, facultyid);
	     ps.setString(2, batchid);
	     ps.setInt(3,day);
	     ps.setString(4, x);
	     
	    ResultSet rs=ps.executeQuery();
	    
	    System.out.println("ok");
	    
	    if(rs.next()) {
	    	
	    	
	    	
	    PreparedStatement	ps1=conn.prepareStatement("update courseplan set status=? where batchid=? AND daynumber=?");
	              
	    ps1.setString(1, x);
	    ps1.setString(2, batchid);
	    ps1.setInt(3, day);
	    
	    int y=ps1.executeUpdate();
	    
	    if(y>0) msg="status updated successfully";
	    
	    }
	     
			
			   
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return msg;
	}




	@Override
	public String updateFacultyPassword(int id, String oldpassword, String newPassword) {
		// TODO Auto-generated method stub
		String msg="Password not updated";

		
		try (Connection conn=DButil.provideConnection()){
			
		PreparedStatement	ps=conn.prepareStatement("select * from faculty where facultyid=? AND password=?");
		
		               ps.setInt(1, id);
		               ps.setString(2, oldpassword);
		               
		               ResultSet rs=ps.executeQuery();
		               
		               boolean flag=false;
		               
		               if(rs.next()) {
		            	   
		            	
		            	   flag=true;
		            	   
		            	   
		            	   
		            	   PreparedStatement ps1=conn.prepareStatement("update faculty set password=? where facultyid=?");
		            	   
		            	            ps1.setString(1, newPassword);
		            	            ps1.setInt(2, id);

		            	           int x=ps1.executeUpdate();
		            	           
		            	           if(x>0) {
		            	        	   msg="password updated";
		            	           }
		            	   
		               }
		               
		               
		               
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Invalid Input");
		}
		
		
		
		return msg;
	}




	@Override
	public List<Faculty> viewAllFaculty() {
		// TODO Auto-generated method stub
		
		List<Faculty> li=new ArrayList<>();
		
		try (Connection conn=DButil.provideConnection()){
			
			
			PreparedStatement	ps=conn.prepareStatement("select facultyid,facultyname,mobile,email from faculty");
			                         
			                 
			
		
			                 
			                ResultSet rs=ps.executeQuery();
			                
			                while(rs.next()) {
			                	
			                	
			                	int fid=rs.getInt(1);
			                	String fname=rs.getString(2);
			                	String mob=rs.getString(3);
			                	String email=rs.getString(4);
			                	
			              Faculty f=new Faculty(fid, fname, mob, email);
			                	
			                	li.add(f);
			                }
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return li;



	}




	@Override
	public String deleteFaculty(int fid) {
		// TODO Auto-generated method stub
		
		
		String msg="Faculty not found";
		
	    
	    try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from faculty where facultyid=? ");
			
			     ps.setInt(1,fid);
			     
			    int x= ps.executeUpdate();
			    
			    if(x>0) {
			    	msg="faculty delected";
			    }
				
			     
			       }
			       
			         catch (SQLException e) {
				// TODO: handle exception
				msg=e.getMessage();
			}
	    
			return msg;
	}
	

}


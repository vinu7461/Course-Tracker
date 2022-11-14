package com.ct.usecases;

import java.util.List;

import java.util.Scanner;

import com.ct.dao.CoursePlanDao;
import com.ct.dao.CoursePlanDaoImpl;
import com.ct.dao.FacultyDao;
import com.ct.dao.FacultyDaoImpl;
import com.ct.model.Batch_Course;
import com.ct.model.CoursePlan;

public class FacultyMenu {

	public int loginFaculty() {
		
		int id=0;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter user name");
		
		try {
			
			String username=sc.nextLine();
			
			System.out.println("Enter password");
			
			String password=sc.nextLine();
			
			FacultyDao fd=new FacultyDaoImpl();
			
			 id=fd.facultyLogin(username, password);
			 
			 if(id<=0) {
				 System.out.println("Invalid Credentials");
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Input");
		}
		
		return id;
	}
	
	
	public void viewCourseByFaculty(int id) {
		
	       CoursePlanDao cpd=new CoursePlanDaoImpl();
	       
	       List<CoursePlan> cp=cpd.viewCourseByFaculty(id);
	       
	       if(cp.size()==0) {
	    	   System.out.println("no record found");
	       }
	       else {
	    	   
	    	   
	    	   for(CoursePlan b :cp) {
	   			
	   			System.out.println("======================================");
	   			System.out.println("plan id     ->"+" "+ b.getPlanId());
	   			System.out.println("batch id    ->"+" "+ b.getBatchId());
	   			System.out.println("course name ->"+" "+ b.getCoursename());
	   			System.out.println("day number  ->"+" "+ b.getDaynumber());
	   			System.out.println("topics      ->"+" "+ b.getTopic());
	   			System.out.println("status      ->"+" "+ b.getStatus());
	   		
	   			
	   			
	   		}
	    	   
	       }
		
	}


	public void dayPlan(int id) {
		// TODO Auto-generated method stub
		
		try {
			
			Scanner sc=new Scanner(System.in);
			
			  CoursePlanDao cpd=new CoursePlanDaoImpl();
		       
		       List<CoursePlan> cp=cpd.viewCourseByFaculty(id);
		       
		       if(cp.size()==0) {
		    	   System.out.println("no record found");
		    	   Demo.facultyrole(id);
		       }
		       else {
		    	 
	
		    	   
		    	   for(CoursePlan b :cp) {
		   			
		   			System.out.println("======================================");
		   			System.out.println("plan id     ->"+" "+ b.getPlanId());
		   			System.out.println("batch id    ->"+" "+ b.getBatchId());
		   			System.out.println("course name ->"+" "+ b.getCoursename());
		   			System.out.println("day number  ->"+" "+ b.getDaynumber());
		   			System.out.println("topics      ->"+" "+ b.getTopic());
		   			System.out.println("status      ->"+" "+ b.getStatus());
		   		
		   			
		   			
		   		}
		    	   
		       }
		       
		       System.out.println("enter batchid");
		       
		       String batchid=sc.nextLine();
		       
	           System.out.println("enter daynumber");
		       
		       int day=sc.nextInt();
		       sc.nextLine();
		       
		       
	           System.out.println("enter 1 for change status to completed");
	           System.out.println("enter 2 for change status to pending");
		       
		      int status =sc.nextInt();
		      sc.nextLine();
		      
		      String x=null;
		      
		      if(status==1) x="completed";
		      else if(status==2) x="pending";
		      else {System.out.println("wrong input") ;
		      Demo.facultyrole(id);}
		       
		  
		       
		       FacultyDao fd=new FacultyDaoImpl();
		       
		     String s= fd.fillDayPlan(batchid,day, id, x);

		     System.out.println(s);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("Invalid Input");
		}
		
		
	}


	public void updatePassword(int id) {
		// TODO Auto-generated method stub
		
		try {
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter old password");
			
			String oldpass=sc.nextLine();
			
			System.out.println("Enter new password");
			
			String newPass=sc.nextLine();
			
			FacultyDao fd=new  FacultyDaoImpl();
			
			String s=fd.updateFacultyPassword(id, oldpass, newPass);
			
			System.out.println(s);
			
			
		} catch (Exception e) {
		      System.out.println("Invalid Input");
		}
		
		
		
	}
	
}


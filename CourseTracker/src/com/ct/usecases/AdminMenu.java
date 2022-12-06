package com.ct.usecases;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import com.ct.dao.AdministratorDao;
import com.ct.dao.AdministratorDaoImpl;
import com.ct.dao.BatchDao;
import com.ct.dao.BatchDaoImpl;
import com.ct.dao.CourseDao;
import com.ct.dao.CourseDaoImpl;
import com.ct.dao.CoursePlanDao;
import com.ct.dao.CoursePlanDaoImpl;
import com.ct.dao.FacultyDao;
import com.ct.dao.FacultyDaoImpl;
import com.ct.exceptions.EmployeeException;
import com.ct.exceptions.FacultyException;
import com.ct.exceptions.PatternException;
import com.ct.model.Batch;
import com.ct.model.Batch_Course;
import com.ct.model.Batch_CoursePlan;
import com.ct.model.Batch_Report;
import com.ct.model.Course;
import com.ct.model.CoursePlan;
import com.ct.model.Faculty;

public class AdminMenu {

	public int adminlogin() {
		
		Scanner sc=new Scanner(System.in);
		
		int res=0;
		
		
		   System.out.println("Enter username");
 	      
 	      String username=sc.nextLine();

 	      
           System.out.println("Enter password");
 	      
 	      String password=sc.nextLine();
 	      
 	 AdministratorDao ad=new AdministratorDaoImpl();
 	 
 	           
 	 
 	   try {
			boolean result=  ad.adminLogin(username, password);
			
			if(result) res=1;
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			
			System.out.println("\n\n Invalid Credentials");
			     System.out.println("===================");
		}
		
		
		
		return res;
	}
	
//================================================================================
	
	
	
public void createCourse() {
		
		Scanner sc=new Scanner(System.in);
		
		 try {
				
	    		 System.out.println("Course name");
	    		 
	    		 String cname=sc.nextLine();
	    		 
              System.out.println("Course fee");
	    		 
	    		 int cfee=sc.nextInt();
	    		 sc.nextLine();
	    		 
              System.out.println("Course Description");
	    		 
	    		 String cdesc=sc.nextLine();
	    		 
	    		 CourseDao cd=new CourseDaoImpl();
	    		 
	    		String msg= cd.createCourse(new Course(cname, cfee, cdesc));
	    		
	    		System.out.println("\n");
	    		System.out.println(msg);
	    		
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Input");
			}
		
	}

//=======================================================================

public void viewCourse() {
	
	
	
	CourseDao cd=new CourseDaoImpl();
	
	List<Course> c=cd.viewCourse();
	
	if(c.size()==0) {
		System.out.println("No Course Available");
	}
	else {
		System.out.println("List of Running Course");
		
//	c.forEach(a-> System.out.println(a.toString()));
	
	for(Course li :c) {
		
		System.out.println("============================");
		System.out.println("course id   ->"+" "+ li.getCourseid());
		System.out.println("course name ->"+" "+ li.getCourseName());
		System.out.println("course fee  ->"+" "+ li.getFee());
		System.out.println("course desc ->"+" "+ li.getDescription());
	
		
	}
	
	}
}

//================================updateCourse==============================

public void updateCourse() {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	
	try {
		
		System.out.println("Enter course name to update");
		String coursename=sc.nextLine();
		

		System.out.println("Enter new course name");
		String newCourseName=sc.nextLine();
		

		System.out.println("Enter course fee");
		int fee=sc.nextInt();
				sc.nextLine();
		

		System.out.println("Enter course Description");
		String coursDesc=sc.nextLine();
		
		
		CourseDao cd=new CourseDaoImpl() ;
		
	String	s=cd.updateCourse(coursename, newCourseName, fee, coursDesc);
		
	System.out.println("\n");
	System.out.println(s);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
}




//==============================delete course============================

public void deleteCourse() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	
	
	try {
		
		System.out.println("enter course name to delete");
		
		String cname=sc.nextLine();
		
		CourseDao cd=new CourseDaoImpl();
		
		if(cd.courseExists(cname)) {
			
			System.out.println("warning:- it delect all record releated to this course");
            System.out.println("1. YES");
            System.out.println("2. NO");
            
            int x=sc.nextInt();
            sc.nextLine();
            
            if(x==1) {
            	String s=cd.deleteCourse(cname);
            	System.out.println(s);
            }else if(x==2) {
            	System.out.println("Course not Delect");
            }else {
            	System.out.println("Invalid Input");
            }
			
			
		}else {
			System.out.println("course not found");
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
}
//=====================================createBatch=======================

public void createBatch() {
	
	
	Scanner sc=new Scanner(System.in);
	
	 try {
			
   		 System.out.println("Batch Id");
   		 
   		 String bname=sc.nextLine();
   		 
         System.out.println("Course Name");
   		 
   		 String cname=sc.nextLine();
   		
   		 
         System.out.println("Strength of batch");
   		 
   		 String stu=sc.nextLine();
   		 
   		 System.out.println("batch start date (yyyy-mm-dd)");
   		 
   		 String bsd=sc.nextLine();
   		 
   		 System.out.println("course duration in months");
   		 
   		 String d=sc.nextLine();
   		 
   		BatchDao bd=new BatchDaoImpl();
   		
   	String	msg=bd.createBatch(new Batch(bname, cname, stu, bsd, d));
   		
   		System.out.println(msg);
   		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			
		}
	
	
	
}

//================================update batch=======================

public void updateBatch() {

	Scanner sc=new Scanner(System.in);
	
	 try {
		 
		 
		 System.out.println("Enter Batch id to update");
		 
		 String oldbid=sc.nextLine();
		 
		 BatchDao bd=new BatchDaoImpl();
		 
		 if(bd.batchExists(oldbid)) {
			 
				
	  		
	  		 
	        System.out.println("Course Name");
	  		 
	  		 String cname=sc.nextLine();
	  		 
	  		System.out.println("Faculty id");
	  		 
	  		 int fid=sc.nextInt();
	  				 sc.nextLine();
	  		
	  		 
	        System.out.println("Strength of batch");
	  		 
	  		 int stu=sc.nextInt();
	  				 sc.nextLine();
	  		 
	  		 System.out.println("batch start date (yyyy-mm-dd)");
	  		 
	  		 String bsd=sc.nextLine();
	  		 
	  		 System.out.println("course duration in months");
	  		 
	  		 int d=sc.nextInt();
	  				 sc.nextLine();
	  		 
	  		String s=bd.updateBatch(cname, fid, stu, bsd, d, oldbid);
	  		System.out.println(s);
	  	
	  		
	  		
	  		
			 
		 }else {
			 System.out.println("batch not exists");
		 }
		 
		
  		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n");
			System.out.println("Invalid Input");
		}
	
}

//==========================================view batch=====================

public void viewBatch() {

	Scanner sc=new Scanner(System.in);
	
	try {
	System.out.println("Course Name");
	
	String c=sc.nextLine();
	
	BatchDao bc=new BatchDaoImpl();
	
	List<Batch_Course> li=bc.viewBatch(c);
	
	if(li.size()==0) {
		System.out.println("No Batch running \n");
	}else {
		System.out.println("List of Running Course");
		
//		c.forEach(a-> System.out.println(a.toString()));
		
		for(Batch_Course b :li) {
			
			System.out.println("============================");
			System.out.println("batch id    ->"+" "+ b.getBatchId());
			System.out.println("course id   ->"+" "+ b.getCourseId());
			System.out.println("course name ->"+" "+ b.getCourseName());
			System.out.println("faculty id  ->"+" "+ b.getFacultyId());
			System.out.println("students    ->"+" "+ b.getTotalStudents());
			System.out.println("batch start ->"+" "+ b.getStartDate());
			System.out.println("duration    ->"+" "+ b.getDuration());
			
			
		}
	}
	
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
}

//================================delete batch=============================

public void deleteBatch() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	
	try {
		
		
		
		System.out.println("Enter Batch Id");
		
		String bid=sc.nextLine();
		
		BatchDao bd=new BatchDaoImpl();
		
		if(bd.batchExists(bid)) {
			
			System.out.println("warning:- it delect all record releated to this batch");
            System.out.println("1. YES");
            System.out.println("2. NO");
            
            int x=sc.nextInt();
            sc.nextLine();
            
            if(x==1) {
            	String s=bd.delectBatch(bid);
            	System.out.println(s);
            }else if(x==2) {
            	System.out.println("batch not delected");
            }else {
            	System.out.println("not a vialid input");
            }
			
			
		}else {
			System.out.println("batch not exists");
		}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
	
	
}

//===============================createfaculty==========================

public void createFaculty() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	try {
		
		System.out.println("Faculty Name");
		
		String fn=sc.nextLine();
		
System.out.println("Faculty address");
		
		String fa=sc.nextLine();
		
System.out.println("Mobile");
		
		String M=sc.nextLine();
		
System.out.println("Email");
		
		String e=sc.nextLine();
		
System.out.println("Username  (only alphanumeric character)");
		
		String u=sc.nextLine();
		
System.out.println("Password");
		
		String p=sc.nextLine();
		
		FacultyDao fd=new FacultyDaoImpl();
		
		String s=fd.createFaculty(new Faculty(fn, fa, M, e, u, p));
		
		System.out.println(s);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
		System.out.println(e.getMessage());
	}
	
}

//=================================update faculty========================

public void updateFaculty() {
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter faculty iD ");
	
	int id=0;
	try {
		
		 id=sc.nextInt();
		sc.nextLine();
		
		
	} catch (InputMismatchException e) {
		// TODO: handle exception
		System.out.println("id is numeric");
		Demo.adminrole();
	}
	
	System.out.println("Enter new name");
	
	String name=sc.nextLine();
	
System.out.println("Enter new address");
	
	String address=sc.nextLine();
	
System.out.println("Enter new mobile");
	
	String mobile=sc.nextLine();
	
System.out.println("Enter new email");
	
	String email=sc.nextLine();
	
System.out.println("Enter new username");
	
	String uname=sc.nextLine();
	
System.out.println("Enter new password");
	
	String pass=sc.nextLine();
	
	FacultyDao fa=new FacultyDaoImpl();
	
	try {
		String s=fa.updateFaculty(id, new Faculty(name, address, mobile, email, uname, pass));
		System.out.println(s);
	} catch (PatternException e) {
		// TODO Auto-generated catch block
		
		System.out.println(e.getMessage());
		
	} catch (FacultyException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	
	}
	
	
}

//=========================allocate faculty========================

public void allocateFaculty() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Faculty id");
	
	try {
		  int fid= sc.nextInt();
		  sc.nextLine();
		  
		  FacultyDao fd=new FacultyDaoImpl();
		  
		 if( fd.facultyExists(fid)) {
			 
			 System.out.println("Enter batch id");
			 
			 String batchid=sc.nextLine();
			 
	        BatchDao bd = new BatchDaoImpl();
	        
	       if( bd.batchExists(batchid)) {
	    	   
	    	   
	    	   String s=fd.allocateFaculty(fid, batchid);
	    	   
	    	   System.out.println(s);
	    	   
	    	   
	       }else {
	    	   System.out.println("batch not exists");
	    	   Demo.adminrole();
	       }
			 
		 }else {
			 System.out.println("faculty not exists");
			 Demo.adminrole();
		
			
		 }
		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
	
}

//========================courseplan================================

public void createCoursePlan() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Batch Id");
	try {
		String batchid=sc.nextLine();
		
		BatchDao bd=new BatchDaoImpl();
	if(	bd.batchExists(batchid)) {
		
		System.out.println("Enter Day NO");
		int day=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter topic to cover");
		String topic=sc.nextLine();
		
		System.out.println("Enter completion status /n 1.Completed /n 2.pending)");
		
		int x=sc.nextInt();
		sc.nextLine();
		String status="";
		if(x==1) {
			status="Completed";
		}else if(x==2) {
			status="Pending";
		}else {
			System.out.println("wrong input");
			Demo.coursePlanRelated();
		}
		
		CoursePlanDao cpd=new CoursePlanDaoImpl();
		
	String s	=cpd.createCoursePlan(new CoursePlan(batchid, day, topic, status));
	
	System.out.println(s);
		
		
		
	}else {
		System.out.println("batch not exists");
		Demo.coursePlanRelated();
	}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
	
}

public void updateCoursePlan() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Batchid");
	try {
		
		String bid=sc.nextLine();

		BatchDao bd=new BatchDaoImpl();
		
		if(bd.batchExists(bid)) {
			
			System.out.println("Enter daynumber to modify");
			int d=sc.nextInt();
			sc.nextLine();
			

			System.out.println("Enter new batchid");
			String batchid=sc.nextLine();
			
			if(bd.batchExists(batchid)) {
				
				

				System.out.println("Enter new daynumber");
				int day=sc.nextInt();
				sc.nextLine();
				

				System.out.println("Enter topics to cover");
				String topic=sc.nextLine();
				
				

				
				System.out.println("Enter completion status /n 1.Completed /n 2.pending)");
				
				int x=sc.nextInt();
				sc.nextLine();
				String status="";
				if(x==1) {
					status="Completed";
				}else if(x==2) {
					status="Pending";
				}else {
					System.out.println("wrong input");
					Demo.coursePlanRelated();
				}
				
				
				CoursePlanDao cpd=new CoursePlanDaoImpl();
				
				String s=cpd.updateCoursePlan(bid, d, new CoursePlan(batchid, day, topic, status));
				
				System.out.println(s);
				
			}else {
				System.out.println("batch not exists");
				Demo.coursePlanRelated();
			}
			
			

			
		}else {
			System.out.println("batch not exists");
			Demo.coursePlanRelated();
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
}

public void dayWiseUpdate() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter day number");
	
	try {
		
		int day=sc.nextInt();
		sc.nextLine();
		
		BatchDao bd=new BatchDaoImpl();
		
		List<Batch_CoursePlan> bc=bd.dayWiseUpdate(day);
		
		if(bc.size()==0) {
			System.out.println("no record found");
		}
		else {
		
		
for(Batch_CoursePlan s :bc) {
			
			System.out.println("===========================================");
			System.out.println("batch id    ->"+" "+ s.getBatchid());
			System.out.println("day number   ->"+" "+ s.getDaynumber());
			System.out.println("topic ->"+" "+ s.getTopic());
			System.out.println("status  ->"+" "+ s.getStatus());
			
			
		}
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
}

public void generateReport() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	BatchDao bd	=new BatchDaoImpl();
	
	List<Batch_Report> br=bd.batchReport();
	
	
	
	if(br.size()==0) {
		System.out.println("no record found");
	}else {
		
for(Batch_Report s :br) {
	
	           
			
			System.out.println("===========================================");
			System.out.println("batch id        ->"+" "+ s.getBatchid());
			System.out.println("course          ->"+" "+ s.getCourseName());
			System.out.println("faculty         ->"+" "+ s.getFacultyName());
			System.out.println("students        ->"+" "+ s.getNoOfStudents());
			System.out.println("batch start     ->"+" "+ s.getBatchStartDate());
			System.out.println("plan generated  ->"+" "+ s.getTotalDaysGenerated());
			System.out.println("complete %      ->"+" "+ s.getCompletionpercentage());
			
		}
	}
	
	
	
}

public void logout() {
	// TODO Auto-generated method stub
	Demo.home();
	
}



public void viewFaculty() {
	// TODO Auto-generated method stub
	
	try {
		
		FacultyDao fd=new FacultyDaoImpl();
		
		List<Faculty> f=fd.viewAllFaculty();
		
		if(f.size()==0) {
			System.out.println("No faculty present");
		
			
		}else {
			
			
			for(Faculty b :f) {
				
				System.out.println("===========================================");
				System.out.println("faculty id    ->"+" "+ b.getFacultyid());
				System.out.println("faculty name  ->"+" "+ b.getFacultyname());
				System.out.println("mobile        ->"+" "+ b.getMobile());
				System.out.println("email         ->"+" "+ b.getEmail());
				
				
				
			}
			
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	
}

public void deleteFaculty() {
	// TODO Auto-generated method stub
	
	
Scanner sc=new Scanner(System.in);
	
	
	
	try {
		
		System.out.println("enter faculty id to delete");
		
		int fid=sc.nextInt();
		
		sc.nextLine();
		
		FacultyDao fd=new FacultyDaoImpl();
		if(fd.facultyExists(fid)) {
			
			System.out.println("warning:- it delect all record releated to this faculty");
            System.out.println("1. YES");
            System.out.println("2. NO");
            
            int x=sc.nextInt();
            sc.nextLine();
            
            if(x==1) {
            	String s=fd.deleteFaculty(fid);
            	System.out.println(s);
            }else if(x==2) {
            	System.out.println("faculty not delected");
            }else {
            	System.out.println("not a vialid input");
            }
			
			
		}else {
			System.out.println("faculty not found");
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Invalid Input");
	}
	
	
	
}

public void viewAllCoursePlan() {
	// TODO Auto-generated method stub
	
	Scanner sc=new Scanner(System.in);
	
	  try {
		  
		  CoursePlanDao cpd=new CoursePlanDaoImpl();
		  
		  List<CoursePlan> cp=cpd.viewAllCoursePlan();
		  
		  if(cp.size()==0) {
			  System.out.println("No Records Found");
		  }else {
			  
			  for(CoursePlan s :cp) {
					
					System.out.println("===========================================");
					System.out.println("plan id    ->"+" "+ s.getPlanId());
					System.out.println("batch id    ->"+" "+ s.getBatchId());
					System.out.println("day number   ->"+" "+ s.getDaynumber());
					System.out.println("topic ->"+" "+ s.getTopic());
					System.out.println("status  ->"+" "+ s.getStatus());
					
					
				}
			
		}
		  
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	
	
	
	
}




	
}

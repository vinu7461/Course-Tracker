package com.ct.usecases;

import java.sql.SQLException;

import java.util.Scanner;

import com.ct.dao.AdministratorDao;
import com.ct.dao.AdministratorDaoImpl;
import com.ct.dao.CourseDao;
import com.ct.dao.CourseDaoImpl;
import com.ct.exceptions.EmployeeException;
import com.ct.model.Course;

public class Demo {

	static Scanner sc=new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
     System.out.println(" _______________________________");
    System.out.println("|                               |\n|   WELCOME TO COURSE TRACKER   |");
    System.out.println("|_______________________________|");
	
  
     Demo.home();
     Demo.end();
	
}
		
//======================================================================================================
	
	public static void home() {
		
		System.out.println("\n");
		System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
		System.out.println("=========================================");
		System.out.println("  1. Admin Login");
	    System.out.println("  2. Faculty Login");
      	System.out.println("  3. Exit The Application");
      	
      	System.out.println("\n\n");
		
      	
      	try {
      		
      	String y=sc.next();
    	int x=Integer.parseInt(y);
    	
    	AdminMenu ad=new AdminMenu();
    	FacultyMenu fm=new FacultyMenu();
    	
    	switch (x) {
		case 1: int a= ad.adminlogin();
			if(a>0) Demo.adminrole();
			else home();
			break;
		case 2:int id=fm.loginFaculty();
		   if(id>0) Demo.facultyrole(id);
		   else home();
		   
		case 3: break;
		default:System.out.println("select from above options");
		        System.out.println("=========================");
		        home();
			break;
		}
      	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
			Demo.home();
		}
      	
      	
		
	}
	

//====================================================================================================
	
	
	
	public static void courseRelated() {
		
	  try {
		 System.out.println("\n");	
		 System.out.println("============================================");
		 System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
			System.out.println("=========================================");
		 System.out.println(" 1.  Create Course");
	     System.out.println(" 2.  View Course ");
	     System.out.println(" 3.  Update Course");
	     System.out.println(" 4.  Delete Course");
	     System.out.println(" 0.  Go Back");
	     System.out.println("============================================");	
	     System.out.println("\n");	   	
	        String y=sc.next();
	        int x=Integer.parseInt(y);
	        	
	          AdminMenu ad=new AdminMenu();
	        	
	           switch (x) {
	           
	           case 0:Demo.adminrole();
//	            System.out.println("============================================================================");
	            
					break;	
	           
	           
	           case 1:ad.createCourse();
				 System.out.println("==========================================================================");
				     Demo.courseRelated();
				   
					break;
					
	           case 2:ad.viewCourse();
	            System.out.println("============================================================================");
	            Demo.courseRelated();
	            
	            
	           case 3:ad.updateCourse();
	            System.out.println("============================================================================");
	            Demo.courseRelated();
					
					break;	
					
	           case 4:ad.deleteCourse();
	            System.out.println("============================================================================");
	            Demo.courseRelated();
					
					break;	
					
					

			default:System.out.println("select from above options");
            System.out.println("=========================");
			Demo.courseRelated();
				break;
			}
	        	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
			Demo.courseRelated();
		}
		
	}
//=================================batch============================================
	
	
    public static void batchRelated() {
		
    	try {
    		 System.out.println("\n");	
    		 System.out.println("========================================");
    		System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
    		System.out.println("=========================================");
    		System.out.println(" 1.  Create Batch");
         	System.out.println(" 2.  Update Batch ");
        	System.out.println(" 3.  View Batch with Particular Course");
        	System.out.println(" 4.  Delete Batch");
        	System.out.println(" 0.  Go Back");
        	 System.out.println("========================================");	
    	     System.out.println("\n");	
        	String y=sc.next();
        	int x=Integer.parseInt(y);
        	
        	
        	AdminMenu ad=new AdminMenu();
    		
    		   switch (x) {
    		   
    		   case 0:Demo.adminrole();
//	            System.out.println("============================================================================");
	            
					break;	
    		   
    		   
    		   case 1:ad.createBatch();
               System.out.println("============================================================================");
   		     Demo.batchRelated();
   		     
   				break;
   					
               case 2:ad.updateBatch();
               System.out.println("============================================================================");
               Demo.batchRelated();
   		     
   				break;
   					
               case 3:ad.viewBatch();
               System.out.println("============================================================================");
               Demo.batchRelated();
   		     
   				break;
   				
               case 4:ad.deleteBatch();
               System.out.println("============================================================================");
               Demo.batchRelated();
   		     
   				break;
   					

			default:System.out.println("select from above options");
            System.out.println("=========================");
			Demo.batchRelated();
			break;
			}
    		
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid Input");
			Demo.batchRelated();
		}
		
	}

    public static void facultyRelated() {
	
    	try {
    		System.out.println("\n\n=======================================\n");
    		System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
    		System.out.println("=========================================");
    		System.out.println(" 1.  Create Faculty");
        	System.out.println(" 2.  Update Faculty");
        	System.out.println(" 3.  Allocate Faculty to Batch");
        	System.out.println(" 4.  View All Faculty");
        	System.out.println(" 5.  delete Faculty");
        	System.out.println(" 0.  Go Back");
        	 System.out.println("========================================\n");
        	
        	String y=sc.next();
        	int x=Integer.parseInt(y);
        	
        	
        	AdminMenu ad=new AdminMenu();
        	
        	switch (x) {
        	
        	case 0:Demo.adminrole();
//            System.out.println("============================================================================");
            
				break;	
        	
        	
        	case 1:ad.createFaculty();
            System.out.println("============================================================================");
            Demo.facultyRelated();
		     
				break;
					
            case 2:ad.updateFaculty();
            System.out.println("============================================================================");
            Demo.facultyRelated();
		     
				break;
				
            case 3:ad.allocateFaculty();
            System.out.println("============================================================================");
            Demo.facultyRelated();
            break;
            
            case 4:ad.viewFaculty();
            System.out.println("============================================================================");
            Demo.facultyRelated();
            break;
            
            case 5:ad.deleteFaculty();
            System.out.println("============================================================================");
            Demo.facultyRelated();
		     
				break;

			default:System.out.println("select from above options");
            System.out.println("=========================");
			Demo.facultyRelated();
				break;
			}
    		
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
		}
	
    }

    public static void coursePlanRelated() {
	
    	try {
    		System.out.println("\n\n=======================================\n");
    		System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
    		System.out.println("=========================================");
    		System.out.println(" 1.  Create Course Plan");
        	System.out.println(" 2.  Update Course Plan");
        	System.out.println(" 3.  View all Course Plan");
        	
        	System.out.println(" 0.  Go Back");
        	
        	String y=sc.next();
        	int x=Integer.parseInt(y);
        	
        	
        	AdminMenu ad=new AdminMenu();
        	
        	  switch (x) {
        	  
        	  case 0:Demo.adminrole();
//              System.out.println("============================================================================");
              
  				break;	
        	  
        	  
        	  case 1:ad.createCoursePlan();
              System.out.println("============================================================================");
              Demo.coursePlanRelated();
  		     
  				break;
  				
              case 2:ad.updateCoursePlan();
              System.out.println("============================================================================");
              Demo.coursePlanRelated();
              
              case 3:ad.viewAllCoursePlan();
              System.out.println("============================================================================");
              Demo.coursePlanRelated();
  		     
  				break;
			default:System.out.println("select from above options");
            System.out.println("=========================");
			Demo.coursePlanRelated();
				break;
			}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
			Demo.coursePlanRelated();
		}
	
    }
    
       public static void reportRelated() {
    	   
    	   try {
    		   System.out.println("\n\n=======================================\n");
    		   System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
    			System.out.println("=========================================");
    		   System.out.println(" 1. Day Wise Update of All Batches");
               System.out.println(" 2. Generate Report Of All Batches");
               System.out.println(" 0. Go Back");
               System.out.println("=========================================\n");

           	String y=sc.next();
           	int x=Integer.parseInt(y);
           	
           	
           	AdminMenu ad=new AdminMenu();
           	
           	  switch (x) {
           	  
           	case 0:Demo.adminrole();
//            System.out.println("============================================================================");
            
				break;	
           	  
           	 case 1:ad.dayWiseUpdate();
             System.out.println("============================================================================");
             Demo.reportRelated();
 		     
 				break;
 				
             case 2:ad.generateReport();
             System.out.println("============================================================================");
             Demo.reportRelated();
 		     
 				break;

			default:System.out.println("select from above options");
            System.out.println("=========================");
			Demo.reportRelated();
				break;
			}
           	
    		   
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
			Demo.reportRelated();
		}
    	   
       }
	
	
	
//		  ==============================================================
		
		
		public static void adminrole() {
			
		try {
			
			System.out.println("\n\n=====================================\n");
			System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
			System.out.println("=========================================");
			System.out.println("  1.   COURSE   (create/update/delete/view) ");
         	System.out.println("  2.   BATCH    (create/update/delete/view) ");
         	System.out.println("  3.   FACULTY  (create/update/delete/view)  ");
         	System.out.println("  4.   COURSE PLAN (create/update/delete/view)   ");
        	System.out.println("  5.   REPORTS/UPDATES  ");
        	System.out.println("  0.   LOGOUT");
            
			System.out.println("==========================================\n");

         	String y=sc.next();
          	int x=Integer.parseInt(y);
        	
       	
        	AdminMenu ad=new AdminMenu();
			
        	
        	switch (x) {
        	case 0:ad.logout();
//           System.out.println("============================================================================");
            
				break;	
		   
		   
		   case 1:Demo.courseRelated();
           System.out.println("============================================================================");
		    Demo.adminrole();
		     
				break;
					
           case 2:Demo.batchRelated();
           System.out.println("============================================================================");
           Demo.adminrole();
		     
				break;
					
           case 3:Demo.facultyRelated();
           System.out.println("============================================================================");
           Demo.adminrole();
		     
				break;
				
           case 4:Demo.coursePlanRelated();
           System.out.println("============================================================================");
           Demo.adminrole();
		     
				break;
				
				
           case 5:Demo.reportRelated();
           System.out.println("============================================================================");
           Demo.adminrole();
		     
				break;	
					

			default:System.out.println("select from above options");
	                 System.out.println("=========================");
			Demo.adminrole();
				break;
			}
			
			
			
//   		    System.out.println(">press 1  ==> Create Course");
//         	System.out.println(">press 2  ==> View Course");
//         	System.out.println(">press 3  ==> Create Batch");
//         	System.out.println(">press 7  ==> update Faculty");
//        	System.out.println(">press 8  ==> Allocate Faculty to Batch");
//        	System.out.println(">pressss 4  ==> Update Batch faculty");
//        	System.out.println(">press 5  ==> View Batch with Particular Course");
//        	System.out.println(">press 6  ==> Create Faculty");
//        	System.out.println(">pre 9  ==> Create Course Plan");
//        	System.out.println(">press 10 ==> update Course Plan");
//        	System.out.println(">press 11 ==> Day Wise Update of All Batches");
//        	System.out.println(">press 12 ==> Generate Report Of All Batches");
//        	System.out.println(">press 13 ==> Logout");
//        	System.out.println(">press 14  ==> update Course");
//        	System.out.println(">press 15  ==> delete Course");
//        	
//        	
//        	System.out.println(">press 16  ==>  Course releated");
//        	System.out.println(">press 17  ==> batch releated");
//        	System.out.println(">press 18  ==> faculty related");
//        	System.out.println(">press 19  ==> courseplan releated");
//        	System.out.println(">press 20  ==> report releated");
//        	
//        	String y=sc.next();
//        	int x=Integer.parseInt(y);
//        	
//        	
//        	AdminMenu ad=new AdminMenu();
//        	
//        	
//        	switch (x) {
//			case 1:ad.createCourse();
//			 System.out.println("==========================================================================");
//			     Demo.adminrole();
//			   
//				break;
//				
//            case 2:ad.viewCourse();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//				
//				break;	
//            case 3:ad.createBatch();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//					
//            case 4:ad.updateBatch();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//					
//            case 5:ad.viewBatch();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//					
//            case 6:ad.createFaculty();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//					
//            case 7:ad.updateFaculty();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 8:ad.allocateFaculty();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 9:ad.createCoursePlan();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 10:ad.updateCoursePlan();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 11:ad.dayWiseUpdate();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 12:ad.generateReport();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//				break;
//				
//            case 13:ad.logout();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//            
//		     
//				break;
//				
//            case 14:ad.updateCourse();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//				
//				break;	
//				
//            case 15:ad.deleteCourse();
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//            case 16:Demo.courseRelated();;
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//            case 17:Demo.batchRelated();;
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//            case 18:Demo.facultyRelated();;
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//            case 19:Demo.coursePlanRelated();;
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//		     
//            case 20:Demo.reportRelated();;
//            System.out.println("============================================================================");
//		     Demo.adminrole();
//				
//				break;	
//
//			default:Demo.courseRelated();
//				break ;
//			}
//        	
        	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid input");
			System.out.println("==============");
			Demo.adminrole();
		}
			
			
		}
		
		
		
		
		
//===================================================================================================		
		
		public static void facultyrole(int id) {
			
		  
			
			try {
				
				System.out.println("\n\n=====================================\n");
				System.out.println("PLEASE SELECT FROM THE FOLLOWING OPTIONS \n ");
				System.out.println("=========================================");
				  
				System.out.println(" 1.  View Course Plan");
				
				System.out.println(" 2.  Fill The day Planner");
				
				System.out.println(" 3.  Update Password");
				
				System.out.println(" 4.  logout");
				
				
			int x=Integer.parseInt(sc.next());
			
			FacultyMenu fm=new FacultyMenu();
			
			switch (x) {
			case 1: fm.viewCourseByFaculty(id);
			System.out.println("============================================================================");
	                Demo.facultyrole(id);
				
				break;

            case 2:fm.dayPlan(id);
            System.out.println("============================================================================");
                   Demo.facultyrole(id);
				
				break;

            case 3:fm.updatePassword(id);
            System.out.println("============================================================================");
                    Demo.facultyrole(id);
	
	           break;

            case 4:Demo.home();
	
	           break;


			default:System.out.println("select from above options");
            System.out.println("============================");
				break;
			}
				
				
				
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid Input");
			}
			
			
			
			
			
		}
		

		
		
		
	
		
		public static void end() {
			System.out.println("Thanks for Watching");
			System.out.println("=============================================================");
		}
	
	
	
}


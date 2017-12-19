package com.revature.ExpenseReimbursementSystem;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.dao.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EmployeeDAO edao = new EmployeeDAO();
       
       //accountCreation(edao);
       Scanner sc = new Scanner(System.in);
       
       while(true){
    	   System.out.println("Pick an option:");
           System.out.println("1. Login");
           System.out.println("2. Create an Account");
           System.out.println("3. Exit");
    	   String opt = sc.nextLine();
    	   if(opt.equals("1")){
    		   loginAttempt(edao);
    		 
    	   }
    	   else if(opt.equals("2")){
    		   accountCreation(edao);
    		   
    	   }
    	   else if(opt.equals("3")){
    		   return;
    	   }
    	   else{
    		   System.out.println("Invalid choice. Try again.");
    	   }
       }
      
       
       
       
       
       
    }
    
    public static void loginAttempt(EmployeeDAO ed){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Username: ");
    	String un = sc.nextLine();
    	System.out.print("Enter password: ");
    	String pw = sc.nextLine();
    	int id = ed.login(un, pw);
    	if(id == 0){
    		System.out.println("Login Failed");
    		return;
    	}
    	
    	System.out.println("Login Successful");
    	//System.out.println("Employee " + id);
    	//begin loginloop here
    	
    	while(true){
    		System.out.println("What would you like to do? Choose number.");
    		System.out.println("1. Submit Reimbursemnt form.");
    		System.out.println("2. Exit");
    		if(ed.checkManager(id) == true){
    			System.out.println("3. Check Reimbursements");
    		}
    		
    		String option = sc.nextLine();
    		if(option.equals("1")){
    			System.out.println("Enter reimbursement amount:");
    			String amt = sc.nextLine();
    			double amt2 = Double.parseDouble(amt);
    			ed.submitForm(id, amt2);
    		}
    		else if(option.equals("2")){
    			System.out.println("Goodbye!");
    			return;
    		}
    		else if(option.equals("3")){
    			if(ed.checkManager(id)){
    				ed.getAllEmployees();
    				List<Employee> employees = ed.getAllEmployees();
    			    for (Employee e : employees) {
    					System.out.println(e.getFirstname() + " " + e.getLastname() + ": " + ed.getReimbursement(e.getId()));
    					
    			    }
    			}
    		}
    		else{
    			System.out.println("Invalid choice, please try again.");
    		}
    		
    		
    	}
    	
    }
    
    public static void accountCreation(EmployeeDAO ed){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("What is your first name? ");
    	String fn = sc.nextLine();
    	System.out.print("What is your last name? ");
    	String ln = sc.nextLine();
    	System.out.print("Choose your username: ");
    	String un = sc.nextLine();
    	System.out.print("Create a password: ");
    	String pw = sc.nextLine();
    	Employee e = new Employee(fn, ln, un , pw);
    	ed.createAccount(e);
    }
}

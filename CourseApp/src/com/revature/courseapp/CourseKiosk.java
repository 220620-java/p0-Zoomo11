package com.revature.courseapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.courseapp.data.ConnectionUtil;
import com.revature.courseapp.models.Faculty;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;
import com.revature.courseapp.models.User.UserType;

public class CourseKiosk {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		
//		 ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
//		  
//		 try(Connection conn = connUtil.getConnection()) { 
//			 if ( conn.isValid(1) ) 
//			 {
//				 System.out.println("Connection is working"); 
//			} else {
//				System.out.println("connection not working"); 
//			} 
//		} 
//		 catch (SQLException e)	{
//		}
		 
		
		//System.out.println("Welcome to CourseKiosk");
		//System.out.println("1. Log in\n" + "2. Register\n" + "3. Exit");
		
		//String input = scanner.nextLine();
		menu();
	}
	public static void menu() {
		System.out.println("Welcome to CourseKiosk");
		System.out.println("1. Log in\n" + "2. Register\n" + "3. Exit");
		
		String input = scanner.nextLine();
		
		switch (input) {
		case "1":
			logIn();
			break;
		case "2":
			register();
			break;
		case "3":
			scanner.close();
		}
	}
	
	public static void logIn() {
		System.out.println("Login Menu");
		System.out.println("1. Student\n" + "2. Faculty\n" + "3. Back to Main Menu" );
		
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			student();
			break;
		case "2":
			faculty();
			break;
		case "3":
			menu();
		}
	}
	
	public static void register() {
		System.out.println("{{ Registration Menu }}");
		System.out.println("1. Register As a Student\n" + "2. Register As a Faculty\n" + "3. Back to Main Menu");
		
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			studentReg();
			break;
		case "2":
			facultyReg();
			break;
		case "3":
			menu();
		}
	}
	
	public static void student() {
		System.out.println("Student Login");	
		System.out.println("Enter username");
		String username = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		studentPortal();
	}
	
	public static void faculty() {
		System.out.println("Faculty Login");
		System.out.println("Enter username");
		String username = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		facultyPortal();
	}
	
	public static void studentReg() {
		System.out.println("Welcome to Student Registration");
		System.out.println("Enter First Name");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name");
		String lastName = scanner.nextLine();
		System.out.println("Enter Email");
		String email = scanner.nextLine();
		System.out.println("Enter Username");
		String username = scanner.nextLine();
		System.out.println("Enter Password");
		String password = scanner.nextLine();
		logIn();
	}
	
	public static void facultyReg() {
		System.out.println("Welcome to Faculty Registration");
		System.out.println("Enter First Name");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name");
		String lastName = scanner.nextLine();
		System.out.println("Enter Email");
		String email = scanner.nextLine();
		System.out.println("Enter Username");
		String username = scanner.nextLine();
		System.out.println("Enter Password");
		String password = scanner.nextLine();
		logIn();
	}
	
	public static void studentPortal() {
		System.out.println("{{ The Student Portal }}");
		System.out.println("{{ Hello Student.username }}");
		System.out.println("1. View Open Class\n" 
				+ "2. Register for Class\n"
				+ "3. Display Enrolled Class\n"
				+ "4. Drop Class\n"
				+ "5. Logout");
		
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			studentOpenClass();
			break;
		case "2":  
			studentRegClass();
			break;
		case "3":
			displayEnrolledClass();
			break;
		case "4": 
			studentRemoveClass();
			break;
		case "5":
			scanner.close();
		}
	}
	
	public static void facultyPortal() {
		System.out.println("{{ The Faculty Portal }}");
		System.out.println("{{ Hello Professor.username }}");
		System.out.println("1. View All Classes\n" 
				+ "2. Add New Class\n"
				+ "3. Change Class Details\n"
				+ "4. Remove a Class\n"
				+ "5. Logout");
		
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			facultyAllClass();
			break;
		case "2":
			facultyAddClass();
		case "3":
			facultyUpdateClass();
			break;
		case "4":
			facultyRemoveClass();
			break;
		case "5":
			scanner.close();
		}
	}
	
	private static void facultyRemoveClass() {
		System.out.println("Remove a class");	
	}
	
	private static void facultyUpdateClass() {
		System.out.println("Update a class");	
	}
	
	private static void facultyAddClass() {
		System.out.println("Add a class");	
	}
	
	private static void facultyAllClass() {
		System.out.println("View all classes");	
	}
	
	public static void studentOpenClass() {
		System.out.println("Available Class");
		System.out.println("Name: Games of Thrones 101\n" + "Description: Let the Games Begin\n " + "Capacity: 40\n " + "Status: Open");
	}
	
	public static void studentRegClass() {
		System.out.println("Register for Class");
	}
	
	public static void displayEnrolledClass() {
		System.out.println("Class you are enrolled in");
	}
	
	public static void studentRemoveClass() {
		System.out.println("Drop class");
	}
}

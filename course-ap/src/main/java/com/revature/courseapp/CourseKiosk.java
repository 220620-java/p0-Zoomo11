package com.revature.courseapp;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.courseapp.data.ConnectionUtil;
import com.revature.courseapp.exceptions.UsernameAlreadyExistsException;
import com.revature.courseapp.models.Faculty;
import com.revature.courseapp.models.Student;
import com.revature.courseapp.models.User;
import com.revature.courseapp.services.UserService;
import com.revature.courseapp.services.UserServiceImpl;

public class CourseKiosk {

	private static Scanner scanner = new Scanner(System.in);
	private static UserService userService = new UserServiceImpl();

	public static void main(String[] args) {

		boolean courseKiosk = true;
		System.out.println("Welcome to CourseKiosk");

		User user = null;
		while (courseKiosk) {
			if (user == null) {
				System.out.println("1. Login Menu\n" + "2. Student Registration\n" + "3. Faculty Registration\n"
						+ "4. Exit\n" + "Select an option");

				String input = scanner.nextLine();

				switch (input) {
				case "1":
					user = login();
					break;
				case "2":
					studentReg();
					break;
				case "3":
					facultyReg();
					break;
				case "4":
					courseKiosk = false;
					System.out.println("Leaving CourseKiosk");
				}
			}
			
			if (user != null) {
				System.out.println("{{ The Student Portal }}");
				System.out.println("{{ Hello Student.username }}");
				System.out.println("1. View Open Class\n" + "2. Register for Class\n" + "3. Display Enrolled Class\n"
						+ "4. Drop Class\n" + "5. Logout");

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
					System.out.println("Logging Out");
					user = null;
				}
			}
		}
		scanner.close();
	}

	private static void facultyReg() {
		// TODO Auto-generated method stub
		boolean facultyR = true;
		System.out.println("Student Registration");

		while (facultyR) {
			System.out.println("First name:");
			String firstname = scanner.nextLine();
			System.out.println("Last name:");
			String lastname = scanner.nextLine();
			System.out.println("Email:");
			String email = scanner.nextLine();
			System.out.println("Username:");
			String username = scanner.nextLine();
			System.out.println("Password:");
			String passwd = scanner.nextLine();

			System.out.println("Enter \"y\" to confirm, \"n\" to try again");
			String input = scanner.nextLine().toLowerCase();

			switch (input) {
			case "y":
				Faculty faculty = new Faculty(firstname, lastname, email, username, passwd);
				try {
					userService.facultyReg(faculty);
					facultyR = false;
					System.out.println("Success!");
				} catch (UsernameAlreadyExistsException e) {
					System.out.println("Must be a glitch in the matirx, That username is taken");
				}
				break;
			case "n":
				System.out.println("Try again");
				break;
			default:
				System.out.println("Let's start over");
				facultyR = false;
			}
		}
	}

	private static void studentReg() {
		boolean studentR = true;
		System.out.println("Student Registration");

		while (studentR) {
			System.out.println("First name:");
			String firstname = scanner.nextLine();
			System.out.println("Last name:");
			String lastname = scanner.nextLine();
			System.out.println("Email:");
			String email = scanner.nextLine();
			System.out.println("Username:");
			String username = scanner.nextLine();
			System.out.println("Password:");
			String passwd = scanner.nextLine();

			System.out.println("Enter \"y\" to confirm, \"n\" to try again");
			String input = scanner.nextLine().toLowerCase();

			switch (input) {
			case "y":
				Student student = new Student(firstname, lastname, email, username, passwd);
				try {
					userService.studentReg(student);
					studentR = false;
					System.out.println("Success!");
				} catch (UsernameAlreadyExistsException e) {
					System.out.println("Must be a glitch in the matirx" + "Try again");
				}
				break;
			case "n":
				System.out.println("Try again");
				break;
			default:
				System.out.println("Let's start over");
				studentR = false;
			}
		}
	}

	private static String facultyMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String studentMenu() {
		// TODO Auto-generated method stub

		return null;
	}


	private static User login() {
		// TODO Auto-generated method stub
		boolean logIn = true;

		while (logIn) {
			System.out.println("Enter your username: ");
			String username = scanner.nextLine();

			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			User user = userService.login(username, password);

			if (user == null) {
				System.out.println("hmm...More glitches in the matrix, User not found");
				System.out.println("Give it another try? y/n");
				String input = scanner.nextLine();
				if (!("y".equals(input))) {
					logIn = false;
				}
			} else {
				return user;
			}
		}
		return null;
	}



	public static void facultyPortal() {
		System.out.println("{{ The Faculty Portal }}");
		System.out.println("{{ Hello Professor.username }}");
		System.out.println("1. View All Classes\n" + "2. Add New Class\n" + "3. Change Class Details\n"
				+ "4. Remove a Class\n" + "5. Logout");

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

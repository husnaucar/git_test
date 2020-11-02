package schoolmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Students {
	
	private static int id = 1000;
	private String studentId;
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String courses = "";
	private int costOfCourse = 600;
	private int tuitionBalance;
	
	//to create a unique id
	public void setStudentsId() {
		// studentId = gradeYear = 3 + id = 1001 ; ---> 31001
		id++;
		this.studentId = gradeYear+""+id;
	}
	
	public  Students() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter student's first name");
		this.firstName = scan.nextLine();
		System.out.println("Enter student's last name");
		this.lastName = scan.nextLine();
		System.out.println("Enter student's class level");
		System.out.println("1 - Freshman");
		System.out.println("2 - Sophmore");
		System.out.println("3 - Jonior");
		System.out.println("4 - Senior");
		this.gradeYear = scan.nextInt();
		setStudentsId();
		
	}
	
	public void enroll() {
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter course to enroll(Q to quit)");
			String course = scan.nextLine();
			if(!course.equalsIgnoreCase("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {
				break;
			}
			
		}while(true);
		System.out.println("You enrolled in:\n" + courses);
	}

	public void payTuition() {
		System.out.println("Your balance is $"+ this.tuitionBalance);
		Scanner scan = new Scanner(System.in);
		System.out.println("How much do you want to pay?");
		int payment = scan.nextInt();
		this.tuitionBalance = this.tuitionBalance - payment;
		System.out.println("Thanks for payment of $:" + payment);
		System.out.println("Your balance $:"+ this.tuitionBalance);
	}

	@Override
	public String toString() {
		return "STUDENT ID=" + studentId + "\n STUDENT NAME=" + firstName + " " + lastName
				+ "\n GRADE LEVEL=" + gradeYear + "\n COURSES ENROLLED=" + courses + "\n REMAINING BALANCE=" + tuitionBalance;
	}
	
	static Map<String, String> studentInfo = new HashMap<>();

	public static void addStudentsToMap() {
		Scanner scan = new Scanner(System.in);
		String exit="";
		while(!exit.equals("S")) {
			Students s = new Students();
			
			s.enroll();
			s.payTuition();
			studentInfo.put(s.studentId, s.toString());
			System.out.println("Press 'S' to stop entrance.");
			System.out.println("Press enter to go on etrance. ");
			exit=scan.nextLine();
		}
		selectOptions();
	}
	
	public static void getStudentInfo() {
		Scanner scan= new Scanner(System.in);
		String idOfStudent = "";
		String result = "";
		do {
			System.out.println("Enter student id to get information!");
			System.out.println("Press 'X' to end the program");
			
			idOfStudent = scan.nextLine();
			result = studentInfo.get(idOfStudent);
			if(!idOfStudent.equals("X"))
				System.out.println(result);
		}while(!idOfStudent.equals("X"));
		selectOptions();
	}
	public static void removeStudent() {
		Scanner scan= new Scanner(System.in);
		String idOfStudent = "";
		String result = "";
		do {
			System.out.println("Enter student id to remove");
			System.out.println("Press 'X' to end the program");
			
			idOfStudent = scan.nextLine();
			result = studentInfo.remove(idOfStudent);
			if(!idOfStudent.equals("X")) {
				System.out.println(result);
				System.out.println("Removed from the students list");
			}
		}while(!idOfStudent.equals("X"));
		selectOptions();
	}
	
	public static void selectOptions() {
		System.out.println("Select the option:");
		System.out.println("1- Add students");
		System.out.println("2- Get the students information");
		System.out.println("3- Remove student by id");
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		switch(option) {
		case 1:
			addStudentsToMap();
			break;
		case 2:
			getStudentInfo();
			break;
		case 3:
			removeStudent();
			break;
		default:
			System.out.println("Invalid selection");	
		}
		
	}













}

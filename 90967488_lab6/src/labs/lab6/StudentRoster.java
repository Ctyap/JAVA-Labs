package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRoster {
	private String rosterFileName;
	private Double totalTuition = (double) 0;
	private int totalStudents = 0;
	
	// Constructor that creates a StudentRoster object based on the given file
	public StudentRoster(String rosterFileName){
		this.rosterFileName = rosterFileName;
	}  
	
	
	// returns the total amount of tuition paid for the given class
	public double getCourseTotalTuition(String course) {
		
		try {
			File inFile = new File(rosterFileName);
			Scanner scan = new Scanner(inFile);
			
			totalTuition = 0.0;
			while(scan.hasNextLine())
			{									
					String line = scan.nextLine();
					String[] field = line.split(";");

					if (course.equals(field[2])) {
						totalTuition += Double.parseDouble(field[3]);
					}else {continue;}
					
			}
			
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + rosterFileName + " not found");}
		
		return totalTuition;
	}
	

	
	
	// returns the total number of students in the given class
	public int getNumStudentsInCourse(String course) {
		try {
			File inFile = new File(rosterFileName);
			Scanner scan = new Scanner(inFile);
			
			totalStudents = 0;
			while(scan.hasNextLine())
			{									
					String line = scan.nextLine();
					String[] field = line.split(";");

					if (course.equals(field[2])) {
						totalStudents++;
					}else {continue;}
					
			}
			
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + rosterFileName + " not found");}
		
		return totalStudents;
	}
	
	
	
	
	public static void main(String[] args) {
		StudentRoster roster = new StudentRoster("C:\\Users\\coope\\eclipse-workspace\\90967488_lab6\\src\\labs\\lab6\\roster.txt");
		System.out.println(roster.getCourseTotalTuition("Agility Training")); // prints 78.4
		System.out.println(roster.getCourseTotalTuition("Tricks")); // prints 99.99
		System.out.println(roster.getNumStudentsInCourse("Agility Training")); // prints 3
		System.out.println(roster.getNumStudentsInCourse("Obedience 101")); // prints 0
	}

}

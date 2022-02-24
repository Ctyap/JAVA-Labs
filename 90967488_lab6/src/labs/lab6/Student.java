package labs.lab6;

public class Student {
	
	private String name, course, date;
	private int id;
	private double tuition;
	
	 // Constructor that creates a Student object with the given info
	public Student(String name, int id, String course, double tuition, String date){
		this.name = name;
		this.course = course;
		this.date = date;
		this.id = id;
		this.tuition = tuition;
		
		
		
	};
	
	 // returns the student's name
	public String getName() {
		return name;
	}
	
	
	// returns the student's ID number
	public int getId() {
		return id;
	}
	
	
	// returns the course this student is in
	public String getCourse() {
		return course;
	} 
	
	
	// returns the amount this student paid for their course
	public double getTuition() {
		return tuition;
		
	}
	
	
	// returns the date the student signed up for the course
	public String getDate() {
		return date;
	}
	
	
	public static void main(String[] args) {
		
	}

}

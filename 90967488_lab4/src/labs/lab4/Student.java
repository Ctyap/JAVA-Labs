package labs.lab4;

public class Student {
	private static int lastStudentID = 0;
	private int studentID = 0;
	private String name;
	private double gpa;
	private boolean honorStatus;
	
	public Student(String name) {
		lastStudentID++;
		this.name = name;
		studentID = lastStudentID;
		gpa = 0.0;
		honorStatus = false;
	}
	
	public String getName() {
		System.out.println(name);
		return name;
	}
	
	public void setName(String name) {
		if (name != "") {
			this.name = name;
		}else {}
	}
	
	public int getId() {
		System.out.println(studentID);
		return studentID;
	}
	
	public double getGPA() {
		System.out.println(gpa);
		return gpa;
	}
	
	public void setGPA(double gpa) {
		if (gpa >= 0.0 && gpa <= 4.0) {
			this.gpa = gpa;
		}else {}
	}
	
	public boolean isHonorsStudent() {
		if (gpa >= 3.5) {
			honorStatus = true;
			System.out.println("true");
			return true;
		}else {
			System.out.println("false");
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		/*
		Student robert = new Student("Robert Navarro");
		robert.getId(); // returns 1
		robert.setGPA(4.0);
		robert.isHonorsStudent(); // returns true
		robert.setGPA(3.2);
		robert.isHonorsStudent(); // returns false

		Student emily = new Student("Emily Navarro");
		emily.getId(); // returns 2

		Student adriana = new Student("Adriana Meza Soria");
		adriana.getId(); // returns 3

		Student abinav = new Student("Abinav Krishna");
		abinav.getId(); // returns 4
		
		*/
		Student bob = new Student("Bob Charles");
		Student selena = new Student("Selena Fam");
		Student austin = new Student("Austin Banks Ender");


		
		System.out.println("Bobs ID: " + bob.getId());
		System.out.println("Selena ID: " + selena.getId());
		System.out.println("Austin ID: " + austin.getId());



		
		
	}
}

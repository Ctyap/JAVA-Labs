package labs.lab4;
import java.util.ArrayList;

public abstract class LibraryItem {
	public String title;
	protected boolean checkedOut;
	public String loanPeriod="";
	
	public LibraryItem(String title) {
		this.title = title;
		checkedOut = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	public abstract String checkOut();
	
	public void checkIn() {
		checkedOut = false;
	}
	
	public String toString() {
		return title;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		
		return true;
	}
	
	public static void main(String[] args) {
		
		/*
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Amy Adams");
		actors.add("Glenn Close");
		actors.add("Haley Bennett");
		actors.add("Gabriel Basso");
		DVD dvd1 = new DVD("Hillbilly Elegy", actors);
		DVD dvd2 = new DVD("BOB THE BUILDER", actors);
		dvd1.checkOut();
		dvd1.checkOut();
		dvd1.equals(dvd1);
		dvd1.equals(dvd2);
		System.out.println("\nMAGAZINES\n");
		Magazine mag1 = new Magazine("Time", 435, "February 2021");
		Magazine mag2 = new Magazine("Time", 231, "February 2021");
		mag1.checkOut(); //7 days
		mag1.checkOut(); //not allowed
		mag2.checkOut(); //7 days
		System.out.println();

		mag1.equals(mag1); //true
		mag1.equals(mag2); //false
		
		DigitalBook db1 = new DigitalBook("Hillbilly Elegy", "J.D. Vance", 264);

		
		db1.checkOut();
		db1.checkOut();
		db1.checkOut();
		db1.checkOut();
		db1.checkIn();
		db1.getCheckOuts();
		db1.checkIn();
		db1.getCheckOuts();
		db1.checkIn();
		db1.getCheckOuts();
		db1.checkIn();
		db1.getCheckOuts();
		
		
		PrintBook pb = new PrintBook("The Hatchet", "Q.S. Eastman", 314);
		PrintBook pb2 = new PrintBook("Circus Man", "G.H. Michaels", 127);
		
		pb.checkOut();
		pb.checkOut();
		
		pb.equals(pb);
		pb.equals(pb2);
		
		AudioBook ab = new AudioBook("Hatchet", "Beagle Spear", 512);
		AudioBook ab2 = new AudioBook("Hatchet", "Bob Spear", 34322);

		ab.checkOut();
		ab.checkOut();
		ab.checkOut();
		ab.checkIn();
		ab.getCheckOuts();
		ab.checkIn();
		ab.getCheckOuts();
		ab.checkIn();
		ab.getCheckOuts();

		
		ab.equals(ab);
		ab.equals(ab2);
		*/

		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Amy Adams");
		actors.add("Glenn Close");
		actors.add("Haley Bennett");
		actors.add("Gabriel Basso");
		DVD dvd1 = new DVD("Hillbilly Elegy", actors);
		Magazine mag1 = new Magazine("Time", 435, "February 2021");
		DigitalBook db1 = new DigitalBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb1 = new PrintBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb2 = new PrintBook("The Warmth of Other Suns", "Isabel Wilkerson", 622);
		PrintBook pb3 = new PrintBook("Caste", "Isabel Wilkerson", 496);
		AudioBook ab1 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		AudioBook ab2 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		ab1.equals(ab2); // returns true
		dvd1.equals(db1); // returns false
		pb2.equals(pb3); // returns false
		LibraryItem[] items = new LibraryItem[8];
		items[0] = dvd1;
		items[1] = mag1;
		items[2] = db1;
		items[3] = pb1;
		items[4] = pb2;
		items[5] = pb3;
		items[6] = ab1;
		items[7] = ab2;
		for (LibraryItem item : items) {
		  System.out.println(item.checkOut());
		}
		// ===========================
		// above should print:
		// 7 days
		// 7 days
		// 14 days
		// 21 days
		// 21 days
		// 21 days
		// 28 days
		// 28 days
		System.out.println(items[6].checkOut()); // 28 days
		System.out.println(items[6].checkOut()); // NOT ALLOWED
		items[6].checkIn();
		System.out.println(items[6].checkOut()); // 28 days
		
		


		

		



		

		
		


		
	}
	
}
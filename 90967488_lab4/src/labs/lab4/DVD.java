package labs.lab4;
import java.util.ArrayList;

public class DVD extends LibraryItem {
	private ArrayList actors = new ArrayList<String>();
	

	
	public DVD(String title, ArrayList<String> actors) // Constructs a DVD object with the given title and actors
	{
		super(title);// give in the super parameters
		this.actors = actors; //instantiate additional fields
	}
	

	public ArrayList<String> getActors()
	{
		return actors;
	}
	
	public void setActors(ArrayList<String> actors)
	{
		this.actors = actors;
	}
	
	public String checkOut() // if this item is not already checked out, this method checks this item out and returns the loan period; if it is already checked out, returns the String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	{
		if (checkedOut == false) {
			loanPeriod = "7 days";
			checkedOut = true;
			//System.out.println(loanPeriod);
			return loanPeriod;
		}else {
			loanPeriod = "NOT ALLOWED";
			//System.out.println(loanPeriod);
			return loanPeriod;
		}
		
	}
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this DVD
	{
		if (!(otherObject instanceof DVD)) {
			return false;
		}else {
		
			if (title == ((LibraryItem) otherObject).getTitle() && actors == ((DVD) otherObject).getActors()) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
		}
		}
	}

}

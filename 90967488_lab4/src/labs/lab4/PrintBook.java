package labs.lab4;

public class PrintBook extends Book {
	private int numPages;
	
	public PrintBook(String title, String author, int numPages) // Constructs a PrintBook object with the given title, author, and number of pages
	{
		super(title, author);
		this.numPages = numPages;
	}
	
	public int getNumPages()
	{
		return numPages;
	}
	
	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}
	
	public String checkOut() // if this item is not already checked out, this method checks this item out and returns the loan period; if it is already checked out, returns the String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	{
		if (checkedOut == false) {
			loanPeriod = "21 days";
			checkedOut = true;
			//System.out.println(loanPeriod);
			return loanPeriod;
		}else {
			loanPeriod = "NOT ALLOWED";
			//System.out.println(loanPeriod);
			return loanPeriod;
		}
	}
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this PrintBook
	{		if (!(otherObject instanceof PrintBook)) {
		return false;
		}else {
			if (title == ((LibraryItem) otherObject).getTitle() && author == ((PrintBook) otherObject).getAuthor() && numPages == ((PrintBook) otherObject).getNumPages() ) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
			}
		}
	}
}

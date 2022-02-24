package labs.lab4;

public class DigitalBook extends Book{
	private int numPages;
	private int maxCheckOuts = 0;

	
	public DigitalBook(String title, String author, int numPages) // Constructs a DigitalBook object with the given title, author, and number of pages
	{
		super(title, author);
		this.numPages = numPages;
		
	}
	
	public int getNumPages()
	{
		System.out.println(numPages);
		return numPages;
	}
	
	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}
	
	public String checkOut() // if the max number of checkouts for this item has not already been reached, this method checks this item out and returns the loan period; if no more check outs are available for this item, returns the String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	{
		maxCheckOuts++;

		if (maxCheckOuts <= 3) {
			maxCheckOuts++;
			System.out.println("Current checkOuts: " + maxCheckOuts);
			loanPeriod = "14 days";
			//System.out.println(loanPeriod);
			return loanPeriod;
		}else {
			maxCheckOuts--;
			checkedOut = true;
			loanPeriod = "NOT ALLOWED";
			//System.out.println(loanPeriod);
			return loanPeriod;
		}
	}
	
	public void checkIn() // checks in this item  (frees up one checkout for this item); overrides LibraryItem.checkIn()
	{
		if (maxCheckOuts > 0) {
			maxCheckOuts--;
			}
	}
	
	public void getCheckOuts() {
		//System.out.println(maxCheckOuts);
	}
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this DigitalBook
	{
		if (!(otherObject instanceof DigitalBook)) {
			return false;
			}else {
			if (title == ((LibraryItem) otherObject).getTitle() && author == ((DigitalBook) otherObject).getAuthor() && numPages == ((DigitalBook) otherObject).getNumPages() ) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
			}
	}

}
}

package labs.lab4;

public class Magazine extends LibraryItem {
	private int issueNumber;
	private String publicationDate="";

	
	public Magazine(String title, int issueNumber, String publicationDate) // Constructs a Magazine object with the given title, issue number, and publication date
	{
		super(title);
		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
	}
	
	public int getIssueNumber()
	{
		//System.out.println(issueNumber);
		return issueNumber;
	}
	
	public void setIssueNumber(int issueNumber)
	{
		this.issueNumber = issueNumber;
	}
	
	public String getPublicationDate()
	{
		//System.out.println(publicationDate);
		return publicationDate;
	}
	
	public void setPublicationDate(String publicationDate)
	{
		this.publicationDate = publicationDate;
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
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this Magazine
	{
		if (!(otherObject instanceof Magazine)) {
			return false;
		}else {
			if (title == ((LibraryItem) otherObject).getTitle() && issueNumber == ((Magazine) otherObject).getIssueNumber() && publicationDate == (((Magazine) otherObject).getPublicationDate())) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
		}
	}
}

}

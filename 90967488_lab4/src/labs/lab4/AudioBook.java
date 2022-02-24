package labs.lab4;

public class AudioBook extends Book {
	private double playingTime;
	private int maxCheckOuts = 0;

	
	AudioBook(String title, String author, double playingTime) // Constructs an AudioBook object with the given title, author, and playing time (in hours)
	{
		super(title, author);
		this.playingTime = playingTime;
	}
	
	double getPlayingTime()
	{
		return playingTime;
	}
	
	void setPlayingTime(double playingTime)
	{
		this.playingTime = playingTime;
	}
	
	public void getCheckOuts() {
		System.out.println(maxCheckOuts);
	}
	
	public String checkOut() // if the max number of checkouts for this item has not already been reached, this method checks this item out and returns the loan period; if no more check outs are available for this item, returns the String "NOT ALLOWED"; overrides LibraryItem.checkOut()
	{
		maxCheckOuts++;

		if (maxCheckOuts <= 2) {
			//System.out.println("Current checkOuts: " + maxCheckOuts);
			loanPeriod = "28 days";
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
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this AudioBook
	{		if (!(otherObject instanceof AudioBook)) {
		return false;
		}else {
			if (title == ((LibraryItem) otherObject).getTitle() && author == ((AudioBook) otherObject).getAuthor() && playingTime == ((AudioBook) otherObject).getPlayingTime() ) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
			}
	}
	}
	
}

package labs.lab1;

/**
 * This class models a simple letter.
 */
public class Letter {
	private String letter="";
	private String from;
	
	public Letter(String from, String to) {
		this.from = from;
		letter += "Dear " + to + ":" + "\n\n";

	}

	/**
	 * Adds a line to the body of this letter.
	 */
	public void addLine(String line) {
		letter += line + "\n";
	}


	public String getText() {
		letter += "\nSincerely," +"\n\n" + from;
		return letter; 
	}
	
	public static void main(String args[]) {
		Letter dearJohnLetter = new Letter("Mary", "John");
		dearJohnLetter.addLine("I am sorry we must part.");
		dearJohnLetter.addLine("I wish you all the best.");
		System.out.println(dearJohnLetter.getText());
	}
}

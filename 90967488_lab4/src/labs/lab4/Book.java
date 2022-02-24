package labs.lab4;

public abstract class Book extends LibraryItem {
	public String author="";

	public Book(String title, String author) // Constructs a Book object with the given title and author
	{
		super(title);
		this.author = author;
	}
	
	public String getAuthor()
	{
		//System.out.println(author);
		return author;	
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public boolean equals(Object otherObject) // returns true if otherObject has the same instance variable(s) value(s) as this Book
	{
		if (!(otherObject instanceof Book)) {
			return false;
		}else {
			if (title == ((LibraryItem) otherObject).getTitle() && author == ((Book) otherObject).getAuthor()) {
				//System.out.println("True");
				return true;
			}else {
				//System.out.println("False");
				return false;
			}
		}
}
}

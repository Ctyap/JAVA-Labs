package labs.lab4;

public class Toy {
	private String name, desc;
	private boolean isDestroyed;
	
	public Toy(String name, String description, boolean destroyed)  // Constructor that constructs the Toy object
	{
		this.name = name;
		this.desc = description;
		this.isDestroyed = destroyed;

	}
	
	public String getName() // returns name
	{
		//System.out.println(name);
		return name;
	}
	
	public void setName(String name) // sets the name to the given name
	{
		this.name = name;
	}
	
	public String getDescription() // returns description
	{
		//System.out.println(desc);
		return desc;
	}
	
	public void setDescription(String description) // sets the description to the given description
	{
		this.desc = description;
	}
	
	public boolean isDestroyed() // Returns true if the toy is destroyed, false otherwise
	{if (isDestroyed == true) {
		//System.out.println("true");
		return true;
	}else {
		//System.out.println("false");
		return false;
	}
	}
	
	public void setDestroyed(boolean destroyed) // sets the destroyed property to the given value
	{
		isDestroyed = destroyed;
	}

}

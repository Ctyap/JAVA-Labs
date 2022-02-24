package labs.lab4;
import java.util.ArrayList;

public class ToyInventory {
	private ArrayList<Toy> toyInventory = new ArrayList<Toy>();
	private boolean flag = true;
	private String inventoryReport ="", isDestroyed="";
	
	public ToyInventory()  // Constructor that constructs a new ToyInventory object
	{}
	
	public void addToy(Toy toy) // adds the given toy if a toy with that name doesn't already exist in the inventory
	{
		//System.out.println("Toys name: "+ toy.getName());
		if (toyInventory.size() == 0) {
			toyInventory.add(toy);
		}else {
		for (Toy item : toyInventory) {
			//System.out.println("Items name: " + item);
			if (toy.getName() == item.getName()) {
				flag = true;
			}else {
				flag = false;
		}
	}
}
	
	if (flag == false) {
		toyInventory.add(toy);
	}
	}
	
	
	public void removeToy(String name) // removes the toy with the given name if it exists in the inventory
	{
		for (int i = 0; i < toyInventory.size(); i++) {
			if (toyInventory.get(i).getName() == name) {
				toyInventory.remove(i);
			}
		}	
	}
	
	public String getInventoryReport() // returns a String that lists the name, description, and DESTROYED or NOT DESTROYED for each toy (see example for formatting)
	{
		for (Toy item: toyInventory) {
			inventoryReport += item.getName() + "\n";
			inventoryReport += item.getDescription() + "\n";
			
			if (item.isDestroyed() == true){
				isDestroyed = "DESTROYED";}
			else {
				isDestroyed = "NOT DESTROYED";
			}
			
			inventoryReport += isDestroyed + "\n";
			
		}
		//System.out.println(inventoryReport);
		return inventoryReport;

	}
	
	public void showInventory() {
		System.out.println(toyInventory);
		}
	

	public static void main(String[] args) {
		Toy lamby = new Toy("Lamby", "white fluffy stuffed lamb that I got for Christmas", false);
		Toy sharky = new Toy("Sharky", "blue shark with its mouth chewed off", true);
		Toy socky = new Toy("Socky", "my brother's old sock that I like to carry around in my mouth like a treasure", true);
		Toy tennisBall = new Toy("Tennis Ball", "standard green tennis ball that I play with outside", false);
		
		//System.out.println(lamby.getName());
		//System.out.println(lamby.getDescription());
		//System.out.println(lamby.isDestroyed());

		
		ToyInventory inventory = new ToyInventory();
		inventory.addToy(lamby);
		inventory.addToy(sharky);
		inventory.addToy(socky);
		inventory.addToy(tennisBall);
		
		//inventory.showInventory();
		
		
		inventory.removeToy("Sharky");


		System.out.println(inventory.getInventoryReport());


		// returns:
		/*
		Lamby
		white fluffy stuffed lamb that I got for Christmas
		NOT DESTROYED
		Socky
		my brother's old sock that I like to carry around in my mouth like a treasure
		DESTROYED
		Tennis Ball
		standard green tennis ball that I play with outside
		NOT DESTROYED
		*/
	}

}

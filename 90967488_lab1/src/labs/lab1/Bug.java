package labs.lab1;

public class Bug {
	private int bugPosition;
	private int difference = 1;
	
	public Bug(int initialPosition) {
		bugPosition = initialPosition;
		
	}
	
	public void turn() {
	    if(difference == 1){
	    	difference = -1;
	     } else {
	    	 difference = 1;
	     }
	}
	
	public void move() {
		bugPosition += difference;
	}
	
	public int getPosition() {
		return bugPosition;
	}
	
	public static void main(String args[]) {
		Bug bugsy = new Bug(10);
		bugsy.move();
		System.out.println(bugsy.getPosition()); // returns 11
		bugsy.turn(); 
		bugsy.move(); 
		System.out.println(bugsy.getPosition());// returns 10
		bugsy.move(); 
		bugsy.move(); 
		bugsy.move(); 
		System.out.println(bugsy.getPosition());// returns 7
		bugsy.turn();
		bugsy.move(); 
		bugsy.move();
		System.out.println(bugsy.getPosition());// returns 9



	}

}

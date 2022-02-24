package labs.lab2;

public class Distance {
	private double distance;
	
	
	public Distance(double meters) {
		this.distance = meters;
	}
	
	public double getMeters() {
		return distance; // FIX ME
	}
	
	public double getKilometers() {
		return distance/ 1000;
	}
	
	public double getCentimeters() {
		return distance * 100; // FIX ME

	}
	
	public double getFeet() {
		return distance * 3.281; // FIX ME

	}
	
	public double getMiles() {
		return distance/1609; // FIX ME

	}
	
	public double getInches() {
		return distance * 39.37; // FIX ME

	}
}
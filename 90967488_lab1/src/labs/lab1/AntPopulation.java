package labs.lab1;


public class AntPopulation {
	private int population;
	
	public AntPopulation(int size) {
		population = size;
	}


	public void breed() {
		population *= 2;
	}


	public void spray(double percent) {
		double percentage, reducedNumber;
		percentage = percent / 100;
		reducedNumber = population * percentage;
		int intReducedNumber = (int)reducedNumber;
		population -= intReducedNumber;
	}


	public int getAnts() {
		return population; 
	}
	
	public static void main(String args[]){
		AntPopulation ants = new AntPopulation(10);
		//System.out.println("Original population: " + ants.population);

		ants.breed();
		//System.out.println("Population after Breeding: " + ants.population);

		ants.spray(10.0);
		//System.out.println("Population after Spray: "+ ants.population);

		ants.getAnts(); // returns 18
		System.out.println("Return 18: " + ants.population);

		ants.breed();
		//System.out.println("Population after Breeding: "+ ants.population);

		ants.spray(5.0);
		//System.out.println("Population after Spray: " + ants.population);
		

		ants.getAnts(); // returns 35
		System.out.println("Return 35: " + ants.population);
		
		//ants.spray(60.0);
		//System.out.println("Return 14: " + ants.population);


		

	}
}

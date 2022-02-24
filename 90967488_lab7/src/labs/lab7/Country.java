package labs.lab7;


public class Country implements Comparable {
	private String countryName = "";
	private int countryPop = 0;
	
	
	public Country(String name, int population) {
		countryName = name;
		countryPop = population;
	}

	public String getName() {
		return countryName; 
	}
	
	public int getPopulation() {
		return countryPop;
	}
	
	@Override
	public int compareTo(Object otherObject) {
		Country otherObjectCountry = (Country) otherObject;
		return Integer.compare(countryPop, otherObjectCountry.getPopulation());

	}
}

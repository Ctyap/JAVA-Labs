package labs.lab7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TravelRecord {
	ArrayList<Country> countries = new ArrayList<Country>();
	
	public TravelRecord() {};
	
	public void addCountry(String name, int population) {
		Country country = new Country(name, population);
		countries.add(country);
	}
	
	public boolean removeCountry(String name) {
		for (int i = 0; i < countries.size() - 1; i++) {
			if (countries.get(i).getName() == name) {
				countries.remove(countries.get(i));
				return true;
			}
		}
		return false; 
	}
	
	public boolean removeCountry(int population) {
		for (int i = 0; i < countries.size() - 1; i++) {
			if (countries.get(i).getPopulation() == population) {
				countries.remove(countries.get(i));
				return true;
			}
		}
		return false; 
	}
	
	public Country findCountryByName(String name) {
		for (int i = 0; i < countries.size() - 1; i++) {
			if (countries.get(i).getName() == name) {
				return countries.get(i);
			}
		}
		return null; 
	}
	
	public Country findCountryByPopulation(int population) {
		for (int i = 0; i < countries.size() - 1; i++) {
			if (countries.get(i).getPopulation() == population) {
				return countries.get(i);
			}
		}
		return null; 
	}
	
	public String getNamesOrderedByPopulation() {
		String orderedCountriesOutput = "";

		Collections.sort(countries);
		
		//System.out.println("Sorted country list: ");
		
		//printCountryList();

		for (Country country: countries) {
			orderedCountriesOutput += country.getName() + " ";
		}

		return orderedCountriesOutput.substring(0,orderedCountriesOutput.length() - 1);
		
	}
	
	public void printCountryList() {
		System.out.println("Country list: ");

		for (Country country: countries) {
			System.out.println(country.getName());
			System.out.println(country.getPopulation() + "\n");
			
		//System.out.println("Last index: " + countries.get(countries.size()-1).getName());


		}
	}
	
	public static void main(String[] args) {
		TravelRecord record = new TravelRecord();
		record.addCountry("USA", 331002651);
		record.addCountry("South Korea", 51269185);
		record.addCountry("Greece", 10423054);
		record.addCountry("Kenya", 53771296);
		record.addCountry("Brazil", 212559417);
		record.addCountry("Antarctica", 1100);
		record.addCountry("Australia", 25499884);
		//record.printCountryList();
		//System.out.println(record.findCountryByPopulation(25499884).getName());
		System.out.println(record.getNamesOrderedByPopulation());// returns "Antarctica Greece Australia South Korea Kenya Brazil USA"
		System.out.println(record.findCountryByPopulation(53771296).getName());// Kenya
		System.out.println(record.findCountryByName("Greece").getPopulation());// 10423054
		record.removeCountry(25499884);
		record.removeCountry("Antarctica");
		System.out.println(record.getNamesOrderedByPopulation()); // returns "Greece South Korea Kenya Brazil USA"
		


		
	}
}

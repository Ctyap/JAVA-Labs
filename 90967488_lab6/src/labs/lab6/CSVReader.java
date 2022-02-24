package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.IllegalArgumentException;



public class CSVReader {
	private String fileName, field;
	private int rowCount, fieldCount;
	private ArrayList<String> fields;
	
	// Constructor that creates a CSVReader object
	public CSVReader(String fileName) {
		this.fileName = fileName;
	};
	
	 // returns the number of lines/rows in the CSV file
	public int getNumberOfRows() {
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			rowCount = 0;
			while(scan.hasNextLine()) {
				scan.nextLine();
				rowCount++;
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}
		

		return rowCount;
	}
	
	
	 // returns the number of fields in the given row (row numbers start at 0); If the given row number does not exist in this file, throw an IllegalArgumentException (the specifics of which are not important)
	public int getNumberOfFields(int row) {
		
		if (row < 0 || row > getNumberOfRows()) {
			throw new IllegalArgumentException("Given row number does not exist in file " + fileName);
		}
		
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			fieldCount = 0;
			int i = 0;
			while(scan.hasNextLine())
			{
				if (i == row) {
					
					String line = scan.nextLine();
					String[] field = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					fieldCount = field.length;
					break;
				}else {i++;}


			}
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}
		return fieldCount;
	}
	
	
	// returns the fields in the given row as a list of strings (row numbers start at 0); If the given row number does not exist in this file, throw an IllegalArgumentException (the specifics of which are not important)
	public ArrayList<String> getFields(int row){
		
		if (row < 0 || row > getNumberOfRows()) {
			throw new IllegalArgumentException("Given row number does not exist in file " + fileName);
		}
		
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			int i = 0;
			while(scan.hasNextLine())
			{
				if (i == row) {					
					String line = scan.nextLine();
				    fields = new ArrayList<>(Arrays.asList(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)));
					break;
				}else {
					scan.nextLine();
					i++;}


			}
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}
				
		
		return fields;
	} 
	
	
	// returns the field in the given row and column; If the given row/column number does not exist in this file, throw an IllegalArgumentException (the specifics of which are not important)
	public String getField(int row, int column) {
		ArrayList<String> fieldList = new ArrayList<String>();
		
		if (row < 0 || row > getNumberOfRows()) {
			throw new IllegalArgumentException("Given row number does not exist in file " + fileName);
		}
		
		if (column < 0 || column > getFields(row).size() - 1) {
			throw new IllegalArgumentException("Given column number does not exist in file " + fileName);
		}
		
		fieldList = getFields(row);
		
		field = fieldList.get(column);
		
		int quoteCount = 0;
		
		for (char ch: field.toCharArray()) {
			if (ch == '\"') {quoteCount++;}
		}
		
		int quoteSets = quoteCount/2;
		int i = 0;
		
		if (quoteSets == 1) {
			field = field.replaceAll("^\"|\"$", "");
			return field;
			
		}else if (quoteSets == 3) {
			field = field.replaceAll("^\"|\"$", "");
			field = field.replaceAll("^\"|\"$", "");
			

			return field;
	}

		
		
		return field;
	}
	
		
	
	public static void main(String[] args) {
		CSVReader reader1 = new CSVReader("C:\\Users\\coope\\eclipse-workspace\\90967488_lab6\\src\\labs\\lab6\\att2007.csv");
		CSVReader reader2 = new CSVReader("C:\\Users\\coope\\eclipse-workspace\\90967488_lab6\\src\\labs\\lab6\\quotes.csv");
		System.out.println(reader1.getNumberOfRows()); // returns 214
		System.out.println(reader1.getNumberOfRows()); // returns 214
		System.out.println(reader1.getNumberOfFields(10)); // returns 7
		System.out.println(reader1.getNumberOfFields(10)); // returns 7

		System.out.println(reader1.getField(10, 2)); // returns 24.95
		
		
		System.out.println(reader2.getNumberOfRows()); // returns 2
		System.out.println(reader2.getNumberOfFields(1)); // returns 4
		System.out.println(reader2.getField(1, 2)); // returns Hello, World
		System.out.println(reader2.getField(1, 3)); // returns  He asked: "Quo vadis?"
		System.out.println(reader2.getField(0, 3)); // "..., that all men are created equal, ..."

	}
}

package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCounter {
	private String fileName;
	
	private int wordCount = 0, lineCount = 0, charCount = 0;

	// Constructor that creates a FileCounter object using the specified file
	public FileCounter(String fileName){
		this.fileName = fileName;
		};

	
	// Returns the number of words in the file (hint: a "word" is something returned by the Scanner.next() method)
	public int getWordCount() {
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			while(scan.hasNext()) {
				scan.next();
				wordCount++;
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}
		
		return wordCount;
	} 
	
	
	// Returns the number of lines in this file (hint: a "line" is something returned by the Scanner.nextLine() method)
	public int getLineCount() {
		
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			while(scan.hasNextLine()) {
				scan.nextLine();
				lineCount++;
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}
		

		return lineCount;
	} 

	
	// Returns the number of characters in this file (hint: the number of characters in a line can be found by calling length() on a line)
	public int getCharacterCount() {
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				charCount += line.length();
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}

		return charCount;
	} 
	
	
	public static void main(String[] args) {
		
		FileCounter doc1 = new FileCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab6\\src\\labs\\lab6\\doc1.txt");
		System.out.println(doc1.getWordCount()); // returns 93
		System.out.println(doc1.getLineCount()); // returns 5
		System.out.println(doc1.getCharacterCount()); // returns 464
		
		
		FileCounter doc2 = new FileCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab6\\src\\labs\\lab6\\doc2.txt");
		System.out.println(doc2.getWordCount()); // returns 3
		System.out.println(doc2.getLineCount()); // returns 5
		System.out.println(doc2.getCharacterCount()); // returns 18
		

	}
}

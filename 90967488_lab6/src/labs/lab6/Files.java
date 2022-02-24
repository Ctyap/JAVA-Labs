package labs.lab6;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
	
	//Constructor
	public Files(String fileName) {
	};
	
	 // Removes blank lines from the file given as argument and writes the non-blank lines back to the file
	public static void removeBlankLines(String fileName) throws IOException{
		
		try {
		File inFile = new File(fileName);
		Scanner scan = new Scanner(inFile);
		
		String content = "";
		
		while(scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			if (!currentLine.isBlank()) {
				content += currentLine + System.lineSeparator();
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		out.print(content);
		out.close();
		scan.close();
		
		}catch (FileNotFoundException exception) {
		System.out.println("File: " + fileName + " not found");}

	}
	
	
	// Adds line numbers to the file given as argument, and writes the lines with line numbers back to the file. The line numbers are enclosed in /* */ delimiters so that the program can be used for numbering Java source files.
	public static void addLineNumbers(String fileName) throws IOException {
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			String content = "";
			
			int i = 0;
			while(scan.hasNextLine()) {
				i++;
				String currentLine = scan.nextLine();
				content += "/* " + Integer.toString(i) + " */ " + currentLine + System.lineSeparator();

			}
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.print(content);
			out.close();
			scan.close();
		
		}catch (FileNotFoundException exception) {
		System.out.println("File: " + fileName + " not found");}

	}
	
 
	
	
	// Replaces each line of the given file with its reverse
	public static void reverse(String fileName) throws IOException {
		try {
			File inFile = new File(fileName);
			Scanner scan = new Scanner(inFile);
			
			String content = "";
			
			while(scan.hasNextLine()) {
				String currentLine = scan.nextLine();
				StringBuilder reverseCurrentLine = new StringBuilder(currentLine).reverse();
				content += reverseCurrentLine + System.lineSeparator();

			}
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.print(content);
			out.close();
			scan.close();
		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + fileName + " not found");}

		}
	
	
	public static void main(String[] args) throws IOException {
		Files.removeBlankLines("C:\\Users\\coope\\OneDrive\\Desktop\\lines1.txt");
		//Files.addLineNumbers("C:\\Users\\coope\\OneDrive\\Desktop\\lines1.txt");
		//Files.reverse("C:\\Users\\coope\\OneDrive\\Desktop\\lines1.txt");


	}

}

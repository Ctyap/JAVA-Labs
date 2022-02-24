package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual
 * words, inserts the words into a tree set, and allows you to get stats
 * about the words. 
 */
public class WordCounter {
	private TreeSet<String> uniqueWords = new TreeSet<String>();
	private ArrayList<String> totalWordCount = new ArrayList<String>();
	private String filename;
	
	public WordCounter(String filename) {
		this.filename = filename;
	}
	
	public int getNumUniqueWords() {
		try {
			File inFile = new File(filename);
			Scanner word = new Scanner(inFile);
			
			while(word.hasNext()) {
				uniqueWords.add(word.next().replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + filename + " not found");}
		return uniqueWords.size();
	}	
	
	public int getNumWords() {
		try {
			File inFile = new File(filename);
			Scanner word = new Scanner(inFile);
			
			while(word.hasNext()) {
				totalWordCount.add(word.next().replaceAll("[,.()!-']",""));
		}

		
		}catch (FileNotFoundException exception) {
			System.out.println("File: " + filename + " not found");}
		
		return totalWordCount.size();
	}
	
	// returns a list of the unique words with all non-letter and non-digit characters removed, 
	// all in lower case, as a List in alphabetical order
	public List<String> getUniqueWords() {
		List<String> listOfWords = new ArrayList<String>(uniqueWords.size());
		listOfWords.addAll(uniqueWords);
		Collections.sort(listOfWords);
		return listOfWords;
	}
	
	public void printQueue() {
		for (String word: uniqueWords) {
			System.out.println(word);
		}
	}
	
	public static void main(String[] args) {
		WordCounter wc1 = new WordCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab7\\src\\labs\\lab7\\test1.txt");
		System.out.println(wc1.getNumUniqueWords()); //37
		//wc1.printQueue();
		System.out.println(wc1.getNumWords()); //50
		System.out.println(wc1.getUniqueWords());
		
		WordCounter wc2 = new WordCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab7\\src\\labs\\lab7\\test2.txt");
		System.out.println(wc2.getNumUniqueWords()); //23
		System.out.println(wc2.getNumWords()); //26
		System.out.println(wc2.getUniqueWords());
		
		WordCounter wc3 = new WordCounter("C:\\Users\\coope\\eclipse-workspace\\90967488_lab7\\src\\labs\\lab7\\test3.txt");
		System.out.println(wc3.getNumUniqueWords()); //28
		System.out.println(wc3.getNumWords()); //33
		System.out.println(wc3.getUniqueWords());
		
		
	}
}

package labs.lab6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class Lab6Test {
	
	@TempDir
	static Path tempDir;
	
	@Test
	void problem1() throws IOException {
		// create the test text file
		Path linesPath = tempDir.resolve("lines.txt");
		List<String> linesList = Arrays.asList("package labs.lab1;"
				, ""
				, "/**"
				, " * This class models a simple letter."
				, " */"
				, ""
				, ""
				, ""
				, "public class Letter {"
				, ""
				, "	/**"
				, "	 * Constructs a letter with a given sender and recipient."
				, "	 * "
				, "	 * @param from the sender"
				, "	 * @param to   the recipient"
				, "	 */"
				, "	public Letter(String from, String to) {"
				, "		// WRITE YOUR CODE HERE "
				, "	}"
				, ""
				, ""
				, "	/**"
				, "	 * Adds a line to the body of this letter."
				, "	 */"
				, "	public void addLine(String line) {"
				, "		// WRITE YOUR CODE HERE "
				, "	}"
				, ""
				, ""
				, "	/**"
				, "	 * Gets the body of this letter."
				, "	 */"
				, "	public String getText() {"
				, "		// WRITE YOUR CODE HERE "
				, "		return \"\"; // FIX ME"
				, "	}"
				, "}"
				, ""
				, ""
				, "");
		java.nio.file.Files.write(linesPath, linesList);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(linesPath), "File should exist"),
			      () -> assertLinesMatch(linesList, java.nio.file.Files.readAllLines(linesPath)));
		
		//test Files.removeBlankLines()
		Files.removeBlankLines(linesPath.toString());
		List<String> linesList2 = Arrays.asList("package labs.lab1;"
				, "/**"
				, " * This class models a simple letter."
				, " */"
				, "public class Letter {"
				, "	/**"
				, "	 * Constructs a letter with a given sender and recipient."
				, "	 * "
				, "	 * @param from the sender"
				, "	 * @param to   the recipient"
				, "	 */"
				, "	public Letter(String from, String to) {"
				, "		// WRITE YOUR CODE HERE "
				, "	}"
				, "	/**"
				, "	 * Adds a line to the body of this letter."
				, "	 */"
				, "	public void addLine(String line) {"
				, "		// WRITE YOUR CODE HERE "
				, "	}"
				, "	/**"
				, "	 * Gets the body of this letter."
				, "	 */"
				, "	public String getText() {"
				, "		// WRITE YOUR CODE HERE "
				, "		return \"\"; // FIX ME"
				, "	}"
				, "}");
		assertLinesMatch(linesList2, java.nio.file.Files.readAllLines(linesPath));
		
		//test Files.addLineNumbers()
		Files.addLineNumbers(linesPath.toString());
		List<String> linesList3 = Arrays.asList("/* 1 */ package labs.lab1;"
				, "/* 2 */ /**"
				, "/* 3 */  * This class models a simple letter."
				, "/* 4 */  */"
				, "/* 5 */ public class Letter {"
				, "/* 6 */ 	/**"
				, "/* 7 */ 	 * Constructs a letter with a given sender and recipient."
				, "/* 8 */ 	 * "
				, "/* 9 */ 	 * @param from the sender"
				, "/* 10 */ 	 * @param to   the recipient"
				, "/* 11 */ 	 */"
				, "/* 12 */ 	public Letter(String from, String to) {"
				, "/* 13 */ 		// WRITE YOUR CODE HERE "
				, "/* 14 */ 	}"
				, "/* 15 */ 	/**"
				, "/* 16 */ 	 * Adds a line to the body of this letter."
				, "/* 17 */ 	 */"
				, "/* 18 */ 	public void addLine(String line) {"
				, "/* 19 */ 		// WRITE YOUR CODE HERE "
				, "/* 20 */ 	}"
				, "/* 21 */ 	/**"
				, "/* 22 */ 	 * Gets the body of this letter."
				, "/* 23 */ 	 */"
				, "/* 24 */ 	public String getText() {"
				, "/* 25 */ 		// WRITE YOUR CODE HERE "
				, "/* 26 */ 		return \"\"; // FIX ME"
				, "/* 27 */ 	}"
				, "/* 28 */ }");
		assertLinesMatch(linesList3, java.nio.file.Files.readAllLines(linesPath));
		
		//test Files.reverse()
		Files.reverse(linesPath.toString());
		List<String> linesList4 = Arrays.asList(";1bal.sbal egakcap /* 1 */"
				, "**/ /* 2 */"
				, ".rettel elpmis a sledom ssalc sihT *  /* 3 */"
				, "/*  /* 4 */"
				, "{ retteL ssalc cilbup /* 5 */"
				, "**/	 /* 6 */"
				, ".tneipicer dna rednes nevig a htiw rettel a stcurtsnoC * 	 /* 7 */"
				, " * 	 /* 8 */"
				, "rednes eht morf marap@ * 	 /* 9 */"
				, "tneipicer eht   ot marap@ * 	 /* 01 */"
				, "/* 	 /* 11 */"
				, "{ )ot gnirtS ,morf gnirtS(retteL cilbup	 /* 21 */"
				, " EREH EDOC RUOY ETIRW //		 /* 31 */"
				, "}	 /* 41 */"
				, "**/	 /* 51 */"
				, ".rettel siht fo ydob eht ot enil a sddA * 	 /* 61 */"
				, "/* 	 /* 71 */"
				, "{ )enil gnirtS(eniLdda diov cilbup	 /* 81 */"
				, " EREH EDOC RUOY ETIRW //		 /* 91 */"
				, "}	 /* 02 */"
				, "**/	 /* 12 */"
				, ".rettel siht fo ydob eht steG * 	 /* 22 */"
				, "/* 	 /* 32 */"
				, "{ )(txeTteg gnirtS cilbup	 /* 42 */"
				, " EREH EDOC RUOY ETIRW //		 /* 52 */"
				, "EM XIF // ;\"\" nruter		 /* 62 */"
				, "}	 /* 72 */"
				, "} /* 82 */");
		assertLinesMatch(linesList4, java.nio.file.Files.readAllLines(linesPath));
		
	}
	
	@Test
	void problem3() throws IOException {
		// create the test text file
		Path docPath1 = tempDir.resolve("doc1.txt");
		List<String> linesList = Arrays.asList("It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of light, it was the season of darkness, it was the spring of hope, it was the winter of despair."
				, ""
				, "-Charles Dickens, A Tale of Two Cities"
				, ""
				, "I haven't read this book, but it's on my reading list. I have read two of Charles Dickens' books before: A Christmas Carol and Oliver Twist.");
		java.nio.file.Files.write(docPath1, linesList);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(docPath1), "File should exist"),
			      () -> assertLinesMatch(linesList, java.nio.file.Files.readAllLines(docPath1)));
		
		Path docPath2 = tempDir.resolve("doc2.txt");
		List<String> linesList2 = Arrays.asList("Robert Navarro"
				, ""
				, "Java"
				, ""
				, "");
		java.nio.file.Files.write(docPath2, linesList2);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(docPath2), "File should exist"),
			      () -> assertLinesMatch(linesList2, java.nio.file.Files.readAllLines(docPath2)));
		
		// Test case 1
		FileCounter doc1 = new FileCounter(docPath1.toString());
		assertEquals(93, doc1.getWordCount());
		assertEquals(5, doc1.getLineCount());
		assertEquals(464, doc1.getCharacterCount());
		
		// Test case 2
		FileCounter doc2 = new FileCounter(docPath2.toString());
		assertEquals(3, doc2.getWordCount());
		assertEquals(5, doc2.getLineCount());
		assertEquals(18, doc2.getCharacterCount());
		
	}
	
	@Test
	void problem4() throws IOException {
		// create the test text file
		Path csvPath1 = tempDir.resolve("att2007.csv");
		List<String> linesList = Arrays.asList("2/27/2007,24.99,25,24.75,24.88,431700,22.57"
				, "2/28/2007,25,25,24.78,24.88,255900,22.57"
				, "3/1/2007,24.87,24.88,24.75,24.87,475000,22.57"
				, "3/2/2007,24.89,25,24.83,24.9,358400,22.59"
				, "3/5/2007,24.85,24.9,24.81,24.85,183700,22.55"
				, "3/6/2007,24.85,25.9,24.82,24.86,723100,22.56"
				, "3/7/2007,24.82,24.94,24.82,24.93,756900,22.62"
				, "3/8/2007,25,25,24.87,24.95,417900,22.64"
				, "3/9/2007,24.95,24.95,24.83,24.9,427400,22.59"
				, "3/12/2007,24.87,24.95,24.87,24.95,217500,22.64"
				, "3/13/2007,24.88,24.95,24.86,24.92,884100,22.61"
				, "3/14/2007,24.9,25,24.86,24.9,543000,22.59"
				, "3/15/2007,24.95,24.99,24.86,24.93,312900,22.62"
				, "3/16/2007,24.95,25,24.9,24.99,259200,22.67"
				, "3/19/2007,25,25,24.85,24.85,282300,22.55"
				, "3/20/2007,24.99,25.02,24.88,24.97,572100,22.66"
				, "3/21/2007,25.04,25.05,24.9,25,416700,22.68"
				, "3/22/2007,24.96,25.01,24.94,25.01,284200,22.69"
				, "3/23/2007,24.96,25.04,24.96,24.98,247000,22.67"
				, "3/26/2007,25.03,25.15,24.93,25.06,585000,22.74"
				, "3/27/2007,25.05,25.14,25.01,25.04,379600,22.72"
				, "3/28/2007,25.11,25.14,25.05,25.06,425400,22.74"
				, "3/29/2007,25.04,25.11,25.04,25.11,198400,22.78"
				, "3/30/2007,25.11,25.11,25.06,25.08,276600,22.76"
				, "4/2/2007,25.11,25.22,25.08,25.18,365400,22.85"
				, "4/3/2007,25.18,25.33,25.12,25.22,498300,22.88"
				, "4/4/2007,25.25,25.33,25.2,25.2,203200,22.86"
				, "4/5/2007,25.27,25.3,25.19,25.19,157700,22.86"
				, "4/9/2007,25.25,25.25,25.18,25.18,168700,22.85"
				, "4/10/2007,25.24,25.29,25.18,25.25,566300,22.91"
				, "4/11/2007,25.23,25.26,25.17,25.2,168800,22.86"
				, "4/12/2007,25.2,25.31,25.2,25.25,228200,22.91"
				, "4/13/2007,25.25,25.25,25.2,25.2,214500,22.86"
				, "4/16/2007,25.35,25.35,25.09,25.1,213900,22.77"
				, "4/17/2007,25.18,25.18,25.08,25.11,198500,22.78"
				, "4/18/2007,25.1,25.17,25.06,25.13,577200,22.8"
				, "4/19/2007,25.14,25.15,25.07,25.1,122400,22.77"
				, "4/20/2007,25.1,25.14,25.06,25.12,108400,22.79"
				, "4/23/2007,25.08,25.22,25.08,25.14,390300,22.81"
				, "4/24/2007,25.41,25.41,25.14,25.2,359800,22.86"
				, "4/25/2007,25.15,25.23,25.15,25.21,154800,22.87"
				, "4/26/2007,25.13,25.38,25.13,25.38,357500,23.03"
				, "4/27/2007,25.1,25.15,24.9,24.94,528100,23"
				, "4/30/2007,24.99,25.04,24.9,25,225600,23.06"
				, "5/1/2007,25,25.03,24.93,24.98,73500,23.04"
				, "5/2/2007,24.92,24.99,24.92,24.98,155500,23.04"
				, "5/3/2007,24.98,25.02,24.92,24.97,179000,23.03"
				, "5/4/2007,24.95,25,24.9,24.94,109600,23"
				, "5/7/2007,24.98,25,24.91,25,136300,23.06"
				, "5/8/2007,25,25,24.96,25,61000,23.06"
				, "5/9/2007,25.13,25.13,24.8,25,99000,23.06"
				, "5/10/2007,24.95,25.04,24.91,24.99,127700,23.05"
				, "5/11/2007,24.97,25.06,24.97,25.06,58500,23.11"
				, "5/14/2007,25.02,25.09,24.97,25,127500,23.06"
				, "5/15/2007,24.99,25,24.92,24.97,129000,23.03"
				, "5/16/2007,24.99,25.02,24.94,24.96,248300,23.02"
				, "5/17/2007,24.96,24.97,24.81,24.94,261600,23"
				, "5/18/2007,24.91,24.96,24.81,24.9,87700,22.97"
				, "5/21/2007,24.89,24.9,24.83,24.9,90900,22.97"
				, "5/22/2007,24.86,24.95,24.86,24.95,176600,23.01"
				, "5/23/2007,24.9,24.95,24.86,24.94,127000,23"
				, "5/24/2007,24.94,24.94,24.85,24.91,105400,22.97"
				, "5/25/2007,24.89,24.95,24.87,24.95,61300,23.01"
				, "5/29/2007,24.83,24.91,24.8,24.85,118500,22.92"
				, "5/30/2007,24.9,24.9,24.61,24.84,102800,22.91"
				, "5/31/2007,24.85,24.85,24.59,24.82,124000,22.89"
				, "6/1/2007,24.83,24.83,24.6,24.65,94300,22.73"
				, "6/4/2007,24.74,24.75,24.65,24.74,110200,22.82"
				, "6/5/2007,24.74,24.74,24.51,24.56,201400,22.65"
				, "6/6/2007,24.5,24.53,24.34,24.46,86600,22.56"
				, "6/7/2007,24.32,24.37,24.07,24.12,159100,22.25"
				, "6/8/2007,23.91,24.09,23.85,24.09,140400,22.22"
				, "6/11/2007,24.11,24.19,24.06,24.15,137400,22.27"
				, "6/12/2007,24.14,24.14,23.77,23.89,158800,22.03"
				, "6/13/2007,24.16,24.2,23.95,24.17,105700,22.29"
				, "6/14/2007,24.2,24.22,24.11,24.18,110200,22.3"
				, "6/15/2007,24.24,24.43,24.08,24.29,96300,22.4"
				, "6/18/2007,24.49,24.59,24.25,24.51,123400,22.61"
				, "6/19/2007,24.55,24.75,24.51,24.75,141100,22.83"
				, "6/20/2007,24.84,24.84,24.25,24.3,166700,22.41"
				, "6/21/2007,24.38,24.38,24.07,24.26,177300,22.38"
				, "6/22/2007,24.1,24.4,24.09,24.39,100900,22.5"
				, "6/25/2007,25,25,24.4,24.68,148800,22.76"
				, "6/26/2007,24.61,24.65,24.39,24.61,129600,22.7"
				, "6/27/2007,24.64,24.64,24.35,24.6,289800,22.69"
				, "6/28/2007,24.6,24.67,24.5,24.66,96100,22.74"
				, "6/29/2007,24.75,24.9,24.5,24.63,182600,22.72"
				, "7/2/2007,24.77,24.79,24.59,24.59,146700,22.68"
				, "7/3/2007,24.59,24.71,24.57,24.65,69200,22.73"
				, "7/5/2007,24.73,24.73,24.55,24.62,49900,22.71"
				, "7/6/2007,24.51,24.62,24.42,24.61,86600,22.7"
				, "7/9/2007,24.57,24.64,24.48,24.49,146300,22.59"
				, "7/10/2007,24.62,24.65,24.51,24.58,97500,22.67"
				, "7/11/2007,24.55,24.58,24.36,24.46,74200,22.56"
				, "7/12/2007,24.56,24.57,24.02,24.2,372900,22.32"
				, "7/13/2007,24.21,24.45,24.2,24.3,116200,22.41"
				, "7/16/2007,24.25,24.5,24.17,24.45,193700,22.55"
				, "7/17/2007,24.38,24.5,24.34,24.49,115800,22.59"
				, "7/18/2007,24.49,24.52,24.4,24.5,87200,22.6"
				, "7/19/2007,24.54,24.54,24.38,24.42,128000,22.52"
				, "7/20/2007,24.38,24.65,24.38,24.55,95900,22.64"
				, "7/23/2007,24.6,24.7,24.41,24.46,188900,22.56"
				, "7/24/2007,24.4,24.4,24.15,24.15,184800,22.27"
				, "7/25/2007,24.1,24.15,23.85,24.07,133100,22.2"
				, "7/26/2007,24,24.12,23.77,23.95,83500,22.09"
				, "7/27/2007,23.85,24.4,23.85,24.4,112300,22.5"
				, "7/30/2007,24.04,24.04,23.3,23.35,98800,21.89"
				, "7/31/2007,23.45,23.54,23,23.25,162500,21.8"
				, "8/1/2007,23.25,23.58,22.95,23.32,98100,21.86"
				, "8/2/2007,23.32,23.76,23.26,23.75,74300,22.27"
				, "8/3/2007,24.61,24.61,23.02,23.6,53300,22.13"
				, "8/6/2007,23.6,23.7,23.01,23.06,53800,21.62"
				, "8/7/2007,23,23.1,22.86,23.03,110400,21.59"
				, "8/8/2007,23.11,23.25,22.95,23.2,138300,21.75"
				, "8/9/2007,23.1,23.1,22.9,23.09,124100,21.65"
				, "8/10/2007,22.95,23.35,22.83,23.35,92900,21.89"
				, "8/13/2007,23.1,23.11,22.78,22.9,123400,21.47"
				, "8/14/2007,22.97,23.1,22.83,23.07,88900,21.63"
				, "8/15/2007,23,23.08,22.51,22.75,114100,21.33"
				, "8/16/2007,22.75,22.95,21.9,22.15,129000,20.77"
				, "8/17/2007,23.05,25,22.15,23.25,59700,21.8"
				, "8/20/2007,23.05,23.41,22.85,23.3,102200,21.85"
				, "8/21/2007,23.6,23.84,23.28,23.62,88500,22.15"
				, "8/22/2007,24,24.05,23.75,24.04,64400,22.54"
				, "8/23/2007,24.04,24.25,23.9,23.99,111100,22.49"
				, "8/24/2007,24.19,24.2,23.86,24,144000,22.5"
				, "8/27/2007,24.14,24.14,23.8,23.95,80700,22.46"
				, "8/28/2007,23.96,24.13,23.79,23.96,193900,22.46"
				, "8/29/2007,24.05,24.2,23.95,24.13,67800,22.62"
				, "8/30/2007,24.22,24.29,24.05,24.12,83400,22.61"
				, "8/31/2007,24.23,24.34,24.07,24.07,66800,22.57"
				, "9/4/2007,24.18,24.18,23.86,23.88,103300,22.39"
				, "9/5/2007,24.02,24.17,23.9,24.1,89200,22.6"
				, "9/6/2007,23.97,24.15,23.97,24.02,96100,22.52"
				, "9/7/2007,24.18,24.29,24.07,24.12,112100,22.61"
				, "9/10/2007,24.04,24.3,24.04,24.29,85400,22.77"
				, "9/11/2007,24.17,24.34,24.06,24.15,150400,22.64"
				, "9/12/2007,24.23,24.35,23.7,23.82,162600,22.33"
				, "9/13/2007,23.79,24.1,23.67,24,69200,22.5"
				, "9/14/2007,24.08,24.15,23.85,23.85,101700,22.36"
				, "9/17/2007,24.01,24.25,23.87,24.24,77800,22.73"
				, "9/18/2007,24.29,24.29,24.03,24.25,114200,22.74"
				, "9/19/2007,24.2,24.24,23.73,23.97,139500,22.47"
				, "9/20/2007,24.03,24.1,23.81,24.1,118100,22.6"
				, "9/21/2007,24.01,24.13,23.83,24.05,89600,22.55"
				, "9/24/2007,24.03,24.04,23.84,23.89,70900,22.4"
				, "9/25/2007,23.86,24.05,23.65,23.8,113000,22.31"
				, "9/26/2007,23.71,23.85,23.61,23.62,92100,22.15"
				, "9/27/2007,23.61,23.8,23.61,23.65,65600,22.17"
				, "9/28/2007,23.99,23.99,23.74,23.82,84000,22.33"
				, "10/1/2007,23.77,23.96,23.75,23.84,53300,22.35"
				, "10/2/2007,24.02,24.02,23.82,23.98,280000,22.48"
				, "10/3/2007,23.9,23.99,23.81,23.94,143900,22.45"
				, "10/4/2007,24,24.25,23.96,24.15,237600,22.64"
				, "10/5/2007,24.08,24.23,23.92,24.1,74400,22.6"
				, "10/8/2007,24.17,24.31,24.01,24.17,30300,22.66"
				, "10/9/2007,24.21,24.21,24,24.01,92000,22.51"
				, "10/10/2007,24.03,24.16,24.01,24.14,90700,22.63"
				, "10/11/2007,24.21,24.25,24.02,24.08,99700,22.58"
				, "10/12/2007,24.13,24.25,24.07,24.11,85800,22.61"
				, "10/15/2007,23.95,24.18,23.93,24.12,84700,22.61"
				, "10/16/2007,24.03,24.14,24.02,24.06,93000,22.56"
				, "10/17/2007,24.08,24.15,24.03,24.09,73700,22.59"
				, "10/18/2007,24.22,24.22,23.97,24.05,115600,22.55"
				, "10/19/2007,24.04,24.25,24.02,24.25,70800,22.74"
				, "10/22/2007,24.24,24.24,24.05,24.13,99600,22.62"
				, "10/23/2007,24.19,24.25,24.07,24.16,115900,22.65"
				, "10/24/2007,24.09,24.24,24.08,24.23,76400,22.72"
				, "10/25/2007,24.23,24.25,24.14,24.25,86100,22.74"
				, "10/26/2007,24.25,24.35,24.18,24.32,84500,22.8"
				, "10/29/2007,24.19,24.5,24.19,24.47,103300,22.94"
				, "10/30/2007,24.21,24.21,23.97,24.15,90000,23.02"
				, "10/31/2007,24.2,24.43,23.97,24.09,90500,22.96"
				, "11/1/2007,24.12,24.21,24.01,24.1,83300,22.97"
				, "11/2/2007,24.1,24.1,23.85,24.04,101600,22.91"
				, "11/5/2007,23.35,24.18,23.35,24.1,77400,22.97"
				, "11/6/2007,24.1,24.15,23.76,23.98,112800,22.86"
				, "11/7/2007,23.97,24.04,23.59,23.78,69800,22.66"
				, "11/8/2007,23.75,23.88,23.35,23.58,81900,22.47"
				, "11/9/2007,23.6,23.6,22.74,22.92,153800,21.85"
				, "11/12/2007,22.7,23.48,22.26,22.62,195700,21.56"
				, "11/13/2007,23.1,23.16,22.47,22.99,378900,21.91"
				, "11/14/2007,23.5,23.7,23.2,23.59,168100,22.48"
				, "11/15/2007,23.9,23.9,22.82,23.3,96000,22.21"
				, "11/16/2007,22.42,23.5,22.42,23.02,91000,21.94"
				, "11/19/2007,23,23.4,22.4,23.14,101000,22.05"
				, "11/20/2007,23.15,23.33,22.99,23.1,93300,22.02"
				, "11/21/2007,22,23.25,22,23.25,84900,22.16"
				, "11/23/2007,23.5,23.65,23.31,23.46,22100,22.36"
				, "11/26/2007,23.46,23.84,22.77,23.5,120800,22.4"
				, "11/27/2007,23.5,23.8,23.38,23.8,129000,22.68"
				, "11/28/2007,24,24.24,23.81,23.81,137800,22.69"
				, "11/29/2007,24.75,24.75,23.85,24.1,92200,22.97"
				, "11/30/2007,24.5,24.5,24.05,24.44,130900,23.29"
				, "12/3/2007,24.4,24.49,24.18,24.41,96700,23.27"
				, "12/4/2007,24.49,24.49,23.67,24.38,149500,23.24"
				, "12/5/2007,24.46,24.5,24.24,24.5,84200,23.35"
				, "12/6/2007,24.49,24.7,24.37,24.69,88900,23.53"
				, "12/7/2007,24.75,24.9,24.58,24.9,90200,23.73"
				, "12/10/2007,25,25,24.2,24.59,91700,23.44"
				, "12/11/2007,25,25,23.76,24.37,205100,23.23"
				, "12/12/2007,25.18,25.18,24.31,24.55,142000,23.4"
				, "12/13/2007,24.9,24.9,24.15,24.4,137900,23.26"
				, "12/14/2007,24.74,24.76,24.36,24.76,131600,23.6"
				, "12/17/2007,24.96,24.96,24.23,24.51,115700,23.36"
				, "12/18/2007,24.97,24.97,24.2,24.48,289700,23.33"
				, "12/19/2007,24.48,24.5,24.2,24.44,110400,23.29"
				, "12/20/2007,24.46,24.49,24,24.05,112900,22.92"
				, "12/21/2007,24.1,24.13,23.72,23.95,164300,22.83"
				, "12/24/2007,24.16,24.28,23.79,24.09,38900,22.96"
				, "12/26/2007,24.23,24.35,23.93,24.33,53100,23.19"
				, "12/27/2007,24.37,24.37,24.03,24.15,61300,23.02"
				, "12/28/2007,23.9,24.15,23.74,24.1,129200,22.97"
				, "12/31/2007,24.1,24.13,23.22,24.12,75700,22.99");
		java.nio.file.Files.write(csvPath1, linesList);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(csvPath1), "File should exist"),
			      () -> assertLinesMatch(linesList, java.nio.file.Files.readAllLines(csvPath1)));
		
		Path csvPath2 = tempDir.resolve("quotes.csv");
		List<String> linesList2 = Arrays.asList("1776,\"Washington,D.C.\",Independence,\"\"\"...,that all men are created equal,...\"\"\""
				, "1729,San Francisco,\"Hello, World\",\"He asked: \"\"Quo vadis?\"\"\"");
		java.nio.file.Files.write(csvPath2, linesList2);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(csvPath2), "File should exist"),
			      () -> assertLinesMatch(linesList2, java.nio.file.Files.readAllLines(csvPath2)));
		
		// Test case 1
		CSVReader reader1 = new CSVReader(csvPath1.toString());
		assertEquals(214, reader1.getNumberOfRows());
		assertEquals(7, reader1.getNumberOfFields(10));
		assertEquals("24.95", reader1.getField(10, 2));
		ArrayList<String> fields = new ArrayList<>();
		fields.add("3/1/2007");
		fields.add("24.87");
		fields.add("24.88");
		fields.add("24.75");
		fields.add("24.87");
		fields.add("475000");
		fields.add("22.57");
		assertEquals(fields, reader1.getFields(2));
		
		// Test case 2
		CSVReader reader2 = new CSVReader(csvPath2.toString());
		assertEquals(2, reader2.getNumberOfRows());
		assertEquals(4, reader2.getNumberOfFields(1));
		assertEquals("Hello, World", reader2.getField(1, 2));
		assertEquals("He asked: \"Quo vadis?\"", reader2.getField(1, 3));
		assertEquals("\"...,that all men are created equal,...\"", reader2.getField(0, 3));
		
	}
	
	@Test
	void problem5_1() throws IOException {
		Path linesPath = tempDir.resolve("roster.txt");
		List<String> linesList = Arrays.asList("Fluffy;6514;Agility Training;29.95;6/7/2014"
				, "Spot;7;Puppy Etiquette;499.00;8/9/2014"
				, "Abby;9;Agility Training;23.45;10/10/2014"
				, "Max;10023;Puppy Etiquette;550.00;1/28/2021"
				, "Fido;101;Tricks;99.99;2/1/2021"
				, "Kai;92;Agility Training;25;12/31/2020");
		java.nio.file.Files.write(linesPath, linesList);
		assertAll(
			      () -> assertTrue(java.nio.file.Files.exists(linesPath), "File should exist"),
			      () -> assertLinesMatch(linesList, java.nio.file.Files.readAllLines(linesPath)));
		
		StudentRoster roster = new StudentRoster(linesPath.toString());
		assertEquals(78.4, roster.getCourseTotalTuition("Agility Training"));
		assertEquals(3, roster.getNumStudentsInCourse("Agility Training"));
		assertEquals(0, roster.getNumStudentsInCourse("Obedience 101"));
	}
	
	@Test
	void problem5_2() throws IOException {
		Student fluffy = new Student("Fluffy",6514,"Agility Training",29.95,"6/7/2014");
		assertEquals("Fluffy",fluffy.getName());
		assertEquals(6514,fluffy.getId());
		assertEquals("Agility Training",fluffy.getCourse());
		assertEquals(29.95,fluffy.getTuition());
		assertEquals("6/7/2014",fluffy.getDate());
	}
	
	@Test
	void problem6_1() {
		MessagingSystem system = new MessagingSystem();
		system.deliver("Emily", "Robert", "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		system.deliver("Emily", "45J Student", "Hey 45J Student,\n"
				+ "You are doing great!\n"
				+ "Keep up the good work.\n"
				+ "-Prof. Navarro\n");
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: 45J Student\n"
				+ "Hey 45J Student,\n"
				+ "You are doing great!\n"
				+ "Keep up the good work.\n"
				+ "-Prof. Navarro\n", system.getMessages("45J Student"));
		system.deliver("45J Student", "Robert", "Robert, you are the best dog ever!!!\n");
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n"
				+ " -----\n"
				+ "From: 45J Student\n"
				+ "To: Robert\n"
				+ "Robert, you are the best dog ever!!!\n", system.getMessages("Robert"));
	}
	
	
	@Test
	void problem6_2() {
		Message message = new Message("Emily","Robert","Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		assertEquals("Robert",message.getRecipient());
		assertEquals("From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n",message.toString());
		
	}
	
	@Test
	void problem6_3() {
		Mailbox mailbox = new Mailbox("Robert");
		assertEquals("Robert", mailbox.getUser());
		Message message1 = new Message("Emily","Robert","Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n");
		Message message2 = new Message("45J Student","Robert","Robert, you are the best dog ever!!!\n");
		mailbox.addMessage(message1);
		mailbox.addMessage(message2);
		assertEquals(" -----\n"
				+ "From: Emily\n"
				+ "To: Robert\n"
				+ "Hi Robert,\n"
				+ "You are snoring too loud!\n"
				+ "I love oyu anyway.\n"
				+ "Love,\n"
				+ "Mom\n"
				+ " -----\n"
				+ "From: 45J Student\n"
				+ "To: Robert\n"
				+ "Robert, you are the best dog ever!!!\n",mailbox.getAllMessages());
	}
}

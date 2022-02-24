package labs.lab7;
import java.util.Stack;
public class Main {
	public static boolean problem1_contains6(int[] nums, int index) {
		
			//If index is greater than list of nums than no 6 exists within
			if(index >= nums.length) return false;
			//A 6 exists
			if (nums[index] == 6)return true;
			//Else add 1 to the index
			else return problem1_contains6(nums, index + 1);
	}

	public static String problem2_parenPart(String str) {
		
		//If no '(' exists at the start move one character to the right
		if (str.charAt(0) != '(') {
			return problem2_parenPart(str.substring(1));
		}
		
		//If above if statement is passed then we check right to left to find end ')'
		if (str.charAt(str.length() - 1) != ')') {
			return problem2_parenPart(str.substring(0, str.length() - 1));
		}
		
		return str;
			}

	public static String problem3_removeAdjacentDuplicates(String str) {
		
		//Checks for empty strings
		if (str.length() <= 1) {
			return str;}
		//if char equals the next character return a string that cuts off first character
		if (str.charAt(0) == str.charAt(1)) {
			return problem3_removeAdjacentDuplicates(str.substring(1));}
		//Else if they dont equal add that character to the returned characters of the next substring
		return str.charAt(0) +  problem3_removeAdjacentDuplicates(str.substring(1));
	}

	public static String problem9_reverse(String sentences) {
			String output = "";
			Stack<String> reverse = new Stack<String>();
			String[] words = sentences.split(" ");
			
			//for (String word: words) {
				//System.out.println(word);
			//}
			
			for (int i = 0; i < words.length; i++) {
				if (words[i].contains(".") == false) {
					reverse.push(words[i].toLowerCase());
				}
				else{
					output += words[i].substring(0,1).toUpperCase() + words[i].substring(1, words[i].length() - 1);
					while(reverse.empty() == false) {
						output += " " + reverse.pop();
					}output += ". ";
					
				}
				
			}return output.substring(0,output.length()-1);
			
				

		}

	
	
	public static void main (String[] args) {
		/*
		System.out.println(problem1_contains6(new int[] {1, 6, 4}, 0)); //true
		System.out.println(problem1_contains6(new int[] {1, 4}, 0)); //false
		System.out.println(problem1_contains6(new int[] {6}, 0)); //true
		System.out.println(problem1_contains6(new int[] {}, 0)); //false
		*/
		
		String sentence1 = "Mary had a little lamb. Its fleece was white as snow.";
		System.out.println(problem9_reverse(sentence1)); // returns "Lamb little a had mary. Snow as white was fleece its."


		

	}
}

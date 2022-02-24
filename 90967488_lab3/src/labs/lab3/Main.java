package labs.lab3;
import java.util.Arrays;
class Main {

	public static int problem1_maxBlock(String str) {
		int count = 0;
		int temp = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i-1)){
				temp+=1;
					}
			else
			{
				temp = 1;
			}
			if (temp > count){
				count = temp;
			}
		}
		return count;
	}
	
	
	public static String problem2_sameEnds(String str) {
		String substring = "";
		
		for (int i=0; i <= str.length()/2; i++) {
			for (int j=str.length()/2;j<str.length(); j++) {
				if (str.substring(0,i).equals(str.substring(j))){
					substring = str.substring(j);
				}
			}
		}return substring;
	}
	
	
	public static boolean problem3_rHappy(String str) 
	
	{
				
		if (str.equals("")) {
			return true;
		}
		
		if (str.length() < 2) {
			return false;
		}
		
		if (str.equals("rr")){
			return true;
		}
		
		for (int i = 1; i < str.length() - 1; i++) {
			if ((str.charAt(i) == 'r' && str.charAt(i+1) != 'r') && (str.charAt(i) =='r' && str.charAt(i-1) != 'r')){
				return false;
				}
			}return true;
		
	}
	
	
	public static int[] problem6_post3(int[] nums) {
		
		for (int i = nums.length - 1; i>0; i-- ) {
			if (nums[i] == 3) {
				int[] newArray = Arrays.copyOfRange(nums, i+1, nums.length);
				System.out.println(Arrays.toString(newArray));
				return newArray;
			}
		}
		return nums;
	}
	
	
	public static int problem7_countClumps(int[] nums) {
		boolean isClump = false;
		int clumpCount = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1] && isClump == false) {
				isClump = true;
				clumpCount += 1;
			}else if (nums[i] != nums[i+1]) {
				isClump = false;
			}
		}
		return clumpCount;
	}

	public static void main(String[] args) {
		
		/*
		System.out.println(problem1_maxBlock("hoopla")); // returns 2
		System.out.println(problem1_maxBlock("abbCCCddBBBxx")); // returns 3
		System.out.println(problem1_maxBlock("")); // returns 0
		
		System.out.println(problem2_sameEnds("abXYab"));// returns "ab"
		
		System.out.println(problem3_rHappy("xxrrxx"));//true
		System.out.println(problem3_rHappy("xxrxx"));//false
		System.out.println(problem3_rHappy("xxrryyrxx"));//false
		System.out.println(problem3_rHappy("1234"));//true
		System.out.println(problem3_rHappy(""));//true
		
		
		System.out.println(problem6_post3(new int[] {2, 3, 1, 2})); //[1,2]
		System.out.println(problem6_post3(new int[] {3,1,3,2})); //[2]
		System.out.println(problem6_post3(new int[] {3, 3, 1, 2, 4})); //[1,2,4]
		System.out.println(problem6_post3(new int[] {1, 3, 3})); //[]
		
		System.out.println((new int[] {1, 2, 2, 3, 4, 4})); // returns 2
		problem7_countClumps(new int[] {1, 1, 2, 1, 1}); // returns 2
		problem7_countClumps(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}); // returns 1
		problem7_countClumps(new int[] {}); // returns 0
		
		
		System.out.println(problem2_sameEnds("abXYab"));// returns "ab"
		System.out.println(problem2_sameEnds("xx"));// returns "x"
		System.out.println(problem2_sameEnds("xxx"));// returns "x"
		System.out.println(problem2_sameEnds("Robert"));// returns ""
		System.out.println(problem2_sameEnds("Robertr"));// returns ""
		
		*/




	}
}

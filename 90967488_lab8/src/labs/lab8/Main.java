package labs.lab8;

import static labs.lab8.Main.problem5_minmax;

import java.util.ArrayList;

public class Main {
	
	public static <T,S> Pair<S, T> problem1_swap(Pair<T,S> pair) {
		Pair<S, T> p = new Pair<>(pair.getSecond(), pair.getFirst());
		return p;
	}
	

	
	public static <S extends T, T> void problem3_append(ArrayList<T> a, ArrayList<S> b) {
		{


			
			//System.out.println("Arraylist A: " + a);
			//System.out.println("Arraylist B: "  + b + "\n");
			//System.out.println(a.get(0).getClass());
			
			for (int i = 0; i < b.size(); i++) {
				a.add(b.get(i));
			}
			
			
			//System.out.println("\n" + a);
			
		}		

			
	}
	
	public static <T> ArrayList problem4_reverse(ArrayList<T> reverseList) {
		ArrayList reversedList = new ArrayList();
		for (int i = reverseList.size() - 1; i >= 0; i--) {
			T t = reverseList.get(i);
			reversedList.add(t);
		}
		return reversedList;
		
		}
	
	//public static EXPECT T typevalue EXTEND COMPARABLE RETURN TYPE PAIR NAME AND ARGUEMENT
	public static <T extends Comparable<T>> Pair<T,T> problem5_minmax(T [] array){
		
		T min = array[0];
		T max = array[0];
		
		for (int i = 1; i <= array.length-1; i++) {
			T ele = array[i];
			
			if (ele.compareTo(min) < 0) {min = ele;}
			
			if (ele.compareTo(max) > 0) {max = ele;}
			
		}
		
		Pair<T,T> newpair = new Pair<>(min,max);
		
		return newpair;
		
	}
	
	public static void main(String[] args) {
        Integer[] nums = { 10, 100, 50, 15, 8, 99 };
        Pair<Integer, Integer> mm = problem5_minmax(nums);
	}

}

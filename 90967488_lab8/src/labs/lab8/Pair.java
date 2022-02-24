package labs.lab8;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class collects a pair of elements of different types.
 */
public class Pair<T, S> {
	private T first;
	private S second;


	/**
	 * Constructs a pair containing two given elements.
	 * 
	 * @param firstElement  the first element
	 * @param secondElement the second element
	 */
	public Pair(T firstElement, S secondElement) {
		first = firstElement;
		second = secondElement;
	}

	/**
	 * Gets the first element of this pair.
	 * 
	 * @return the first element
	 */
	public T getFirst() {
		return first;
	}

	/**
	 * Gets the second element of this pair.
	 * 
	 * @return the second element
	 */
	public S getSecond() {
		return second;
	}
	
	public static <T,S> Pair<S, T> problem1_swap(Pair<T,S> pair) {
		Pair<S, T> p = new Pair<>(pair.getSecond(), pair.getFirst());
		return p;
		
	} 
	
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

	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}

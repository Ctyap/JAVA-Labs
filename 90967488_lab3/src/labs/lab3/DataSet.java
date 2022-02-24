package labs.lab3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DataSet {
	private ArrayList<Double> dataSet = new ArrayList<Double>();
	private double sum;
	private double average;
	private double min;
	private double max;
	private double range;
	private int count;
	
	public DataSet() {}
	
	public void add(double value){
		dataSet.add(value);
		System.out.println(dataSet);
	}
	
	public double getSum() {
		sum = 0;
		for (int i=0; i < dataSet.size(); i++) {
			sum += dataSet.get(i);
		}
		System.out.println(sum);
		return sum;
	}
	
	public double getAverage() {
		average = sum/dataSet.size();
		System.out.println(average);
		return average;
	}
	
	public double getSmallest() {
		min = Collections.min(dataSet);
		System.out.println(min);
		return min;
	}
	
	public double getLargest() {
		max = Collections.max(dataSet);
		System.out.println(max);
		return max;
	}
	
	public double getRange() {
		range = max - min;
		System.out.println(range);
		return range;
	}
	
	public int getCount() {
		count = dataSet.size();
		System.out.println(count);
		return count;
			
		}

}
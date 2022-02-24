package labs.lab3;

import java.util.ArrayList;

public class Sequence {
	private ArrayList<Integer> values;

	public Sequence() {
		values = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getValues() {
		return values;
	}

	public void add(int n) {
		values.add(n);
	}

	public String toString() {
		return values.toString();
	}
	
	public Sequence append(Sequence other) {
		Sequence newSequence = new Sequence();
		
		for(int val: values) {
			newSequence.add(val);
		}

		for(int val2: other.values) {
			newSequence.add(val2);
		
	}
		return newSequence;
		
	}
	
	public Sequence merge(Sequence other) {
		int vSize,oSize,longSize,value,value2;

		Sequence newSequence = new Sequence();
		
		vSize = values.size();
		oSize = other.values.size();
		
		if(vSize > oSize) {
			longSize = vSize;
		}else {
			longSize = oSize;
		}
				
		for (int i = 0; i < longSize; i++) {
			if(i <= values.size()-1) {
				value = values.get(i);
				newSequence.add(value);
			}
				
			if(i <= other.values.size()-1) {
				value2 = other.values.get(i);
				newSequence.add(value2);
			}
		}return newSequence;
			
	}
}
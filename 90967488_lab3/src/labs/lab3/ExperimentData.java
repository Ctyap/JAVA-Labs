package labs.lab3;
import java.util.Arrays;

public class ExperimentData {
	private double[] values;
	private double temp, indexZero, currentValue, indexI, indexLast;
	
	public ExperimentData(double[] values) {
		this.values = values;
	}
	
	public double[] getValues() {
		System.out.println(Arrays.toString(this.values));
		return this.values;	
	}
	
	public void smooth() {
		for (int i=0; i <= this.values.length-1; i++) {
			if (i == 0) {
				temp = this.values[0];
				indexZero = (this.values[i] + this.values[i+1])/2;
				this.values[0] = indexZero;

				}else if (i != this.values.length-1) {
				currentValue = this.values[i];
				indexI = (temp + currentValue + this.values[i+1])/3;
				this.values[i] = indexI;
				temp = currentValue;
				
				}else{
					currentValue = this.values[i];
					indexLast = (temp+currentValue)/2;
					this.values[i] = indexLast;
					temp = currentValue;
				}
			
			}
			
		}

		
	}




package labs.lab8;

public interface Measurer<T> {
	/**
	 * Computes the measure of an object.
	 * 
	 * @param maximum the object to be measured
	 * @return the measure
	 */
	
	double measure(T maximum);
	
	
	//what does meas represent?
	
	public static <T> T max(T[] values, Measurer<T> meas) {
		if (values.length == 0){return null;}
		else {
			T maximum = values[0];
			for (int i = 1; i < values.length; i++) {
				T obj = values[i];
				if (meas.measure(maximum) <= meas.measure(obj))
				{
					maximum = obj;
				}
				
			}return maximum;
			
			
		}
		
		};
		




}

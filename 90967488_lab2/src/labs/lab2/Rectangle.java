package labs.lab2;
import java.lang.Math; 

public class Rectangle {
	private double x1, y1, x2, y2;
	private double xValue, yValue;
	private String output;

	/**
	 * Constructs a Rectangle
	 * 
	 * @param x1 is the upper-left corner x-value
	 * @param y1 is the upper-left corner y-value
	 * @param x2 is the lower-right corner x-value
	 * @param y2 is the lower-right corner y-value
	 */
	public Rectangle(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	/**
	 * Gets the orientation of this rectangle
	 * 
	 * @return "square", "portrait", or "landscape"
	 */
	public String getOrientation() {
		xValue = Math.abs(x2-x1);
		yValue = Math.abs(y2-y1);
		
		if (xValue == yValue) {
			output = "square";
		}else if(xValue > yValue){
			output = "landscape";
		}else {
			output = "portrait";
		}
		return output; 
	}
}

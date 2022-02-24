package labs.lab3;

public class SeatingChart {
	int[][] seatChart = {{40, 50, 50, 50, 40},
			{30, 40, 40, 40, 30},
			{20, 30, 30, 30, 20},
			{10, 20, 20, 20, 10},
			{10, 10, 10, 10, 10}};
	
	private String getSeatChart="";
	private int convertChar;


	public SeatingChart() {}

	
	public String getSeatingChart() {
		if (getSeatChart != "")
			{getSeatChart = "";}
		
		for (int row=0; row<seatChart.length; row++) {
			if (row != 0) {
				getSeatChart += System.lineSeparator();	
			}
			for (int col=0; col<seatChart.length;col++) {
				if (seatChart[row][col] == 0) {
					if (col != 4) {
					getSeatChart += " " + seatChart[row][col] + " ";
					}
					else {
						getSeatChart += " " + seatChart[row][col];
					}
				}
				else if (col == 4) {
					getSeatChart += seatChart[row][col];
				}else {				
					getSeatChart += seatChart[row][col] + " ";
}
				}
		}return getSeatChart + System.lineSeparator();
	}
	
	public void sellSeatByPrice(int price) {
		outerloop:
		for (int row = 0; row <seatChart.length; row++) {
			for (int col = 0; col < seatChart.length; col++) {
				if (seatChart[row][col] == price) {
					seatChart[row][col] = 0;
					break outerloop;
				}
			}
		}
	}
	
	public void sellSeatByNumber(char row, int seat) {
		if(row == 'A') {
			convertChar = 0;
		}else if(row == 'B') {
			convertChar = 1;
		}else if(row == 'C') {
			convertChar = 2;
		}else if(row == 'D') {
			convertChar = 3;
		}else if(row == 'E') {
			convertChar = 4;
		}else {return;}
			
		for (int tRow = 0; tRow <seatChart.length; tRow++) {
			for (int col = 0; col < seatChart.length; col++) {
				seatChart[convertChar][seat-1] = 0;
				}
			}	
		}
}



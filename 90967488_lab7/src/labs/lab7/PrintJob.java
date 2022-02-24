package labs.lab7;

/**
 * Class for creating a priority print queue.
 */
public class PrintJob implements Comparable {
	private String employeeType = "";
	private String description = "";
	private int priority = 0;

	/**
	 * Constructor.
	 * 
	 * @param employeeType   The type of employee requesting the print job
	 * @param description    The description of the print job.
	 */
	public PrintJob(String employeeType, String description) {
		this.employeeType = employeeType;
		this.description = description;
	}

	public int getPriority() {
		if (employeeType.equals("CEO")) {priority = 1;}
		else if (employeeType.equals("Vice-President")){priority = 2;}
		else if (employeeType.equals("Executive-Manager")) {priority = 3;}
		else if (employeeType.equals("Manager")) {priority = 4;}
		else if (employeeType.equals("Senior-Associate")) {priority = 5;}
		else if (employeeType.equals("Associate")) {priority = 6;}
		else if (employeeType.equals("Junior-Associate")) {priority = 7;}
		else if (employeeType.equals("Clerical")) {priority = 8;}
		else if (employeeType.equals("Intern")) {priority = 9;}
		else if (employeeType.equals("Volunteer")) {priority = 10;}
		
		return priority;
	}

	public String getEmployeeType() {
		return employeeType;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(Object otherObject) {
		PrintJob otherObject1 = (PrintJob) otherObject;
		return Integer.compare(getPriority(), otherObject1.getPriority());
	}
}
package labs.lab7;

import java.util.PriorityQueue;

public class Printer {
	private PriorityQueue<PrintJob> jobs;

	/**
	 * Constructor
	 */
	public Printer() {
		jobs = new PriorityQueue<>();
	}

	public void addJob(String employeeType, String description) {
		jobs.add(new PrintJob(employeeType, description));
		//printQueue();
	}

	/**
	 * Get the next highest priority job
	 */
	public PrintJob nextJob() {
		return jobs.poll();
	}
	
	public void printQueue() {
		PrintJob[] jobArr = jobs.toArray(new PrintJob[0]);
		for (PrintJob p : jobArr) {
			System.out.println(p.getPriority() + ", " + p.getEmployeeType() + ", " + p.getDescription());
		}
	}
}
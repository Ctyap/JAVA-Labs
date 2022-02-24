package labs.lab1;

public class Microwave{
	private int timer;
	private int powerLevel;
	
	public Microwave() {
		timer = 0;
		powerLevel = 1;
	}
	
	public void increaseTime() {
		timer += 30;
	}
	
	public void switchPower() {
		if(powerLevel == 1) {
			powerLevel = 2;
		}else {
			powerLevel =1;
		}
	}
	
	public void reset() {
		timer = 0;
		powerLevel = 1;
	}
	
	public String start() {
		String information = "";
		information += "Cooking for " + timer + " seconds at level " + powerLevel;
		return information;
	}

	
	public static void main(String args[]) {
		Microwave appliance = new Microwave();
		appliance.increaseTime();
		appliance.increaseTime();
		appliance.increaseTime();
		
		appliance.switchPower();
		System.out.println(appliance.start()); // returns "Cooking for 90 seconds at level 2"
		appliance.reset();
		appliance.increaseTime();
		appliance.switchPower();
		appliance.switchPower();
		System.out.println(appliance.start()); // returns "Cooking for 30 seconds at level 1"



	}

}

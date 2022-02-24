package labs.lab6;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * An email mailbox.
 */
public class Mailbox {

	private String user = "";
	private String allMessages = "";
	private ArrayList<String> mailbox = new ArrayList<String>();
	

	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param u the user
	 */
	public Mailbox(String u) {
		this.user = u;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Adds a message to the list.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		mailbox.add(m.toString());
	}

	/**
	 * Retrieves all of the messages, 
	 * with a line of 5 dashes (-----) between each message
	 */
	public String getAllMessages() {

		
		for (String msg: mailbox) {
			//System.out.println("Msg: " + msg);
			allMessages += " -----" + "\n";
			allMessages += msg;
		}return allMessages;
	}
	

	public void printMailBox() {
		for (String msg: mailbox) {
			System.out.println(msg);
		}
	}
	
	public static void main(String[] args) {
		Mailbox mailbox = new Mailbox("Cooper");
		Mailbox mailbox2 = new Mailbox("Bob");

		Message message = new Message("Cooper","Bob", "Hello, great work yesterday!");
		Message message2 = new Message("Cooper","Bob", "I'd love to hear back from you thanks!");
		
		Message message3 = new Message("Bob","Cooper", "Thanks for replying!");
		Message message4 = new Message("Bob","Cooper", "Let me know if you are free tomorrow!");


		mailbox.addMessage(message);
		mailbox.addMessage(message2);
		
		mailbox2.addMessage(message3);
		mailbox2.addMessage(message4);
		

		//mailbox.printMailBox();
		//System.out.println(mailbox2.getAllMessages());
		System.out.println(mailbox.getAllMessages());

	}
}

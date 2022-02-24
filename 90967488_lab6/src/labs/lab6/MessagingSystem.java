package labs.lab6;
import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	ArrayList <Mailbox> listOfRecipients = new ArrayList<Mailbox>();
	ArrayList <String> listOfRNames = new ArrayList<String>();

	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
	};

	/**
	 * Delivers a message to the recipient.
	 * 
	 * @param sender 		the sender's username
	 * @param recipient 	the recipient's username
	 * @param text			the text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		Message messageObject = new Message(sender, recipient, text);
		boolean addRecipient = false;
		

		
		//If list is empty we create new mailbox and add new message according to recipient
		if (listOfRecipients.size() == 0) {
			//Create new Mailbox
			Mailbox mailbox = new Mailbox(recipient);			
			//Add mailbox to listOfRecipients list
			listOfRecipients.add(mailbox);
			//Add name
			listOfRNames.add(recipient);
		}
		//System.out.println(listOfRecipients);
		//System.out.println(listOfRNames);

		for (String name: listOfRNames) {
			if (recipient != name) {
				addRecipient = true;
				}
			else {
				addRecipient = false;
				break;

			}
		}
		
		//System.out.println(addRecipient);
		if (addRecipient == true) {
			Mailbox mailbox = new Mailbox(recipient);
			listOfRecipients.add(mailbox);
			listOfRNames.add(recipient);
		}
		
		
		//Loop through list and add messages or new mailbox
		for (int i = 0; i <= listOfRecipients.size() - 1; i++) {
			//If recipient == MailboxObject's user
			//recipient mailbox = listOfRecipients.get(i)
			if (recipient == listOfRecipients.get(i).getUser()) {
				//Add new message to mailbox
				listOfRecipients.get(i).addMessage(messageObject);
			}
			}
		System.out.println("Recipient list looks like: " + listOfRecipients + "\n");
		System.out.println("Name list: " + listOfRNames + "\n");
		}

		
	

	/**
	 * Retrieves the messages for a user
	 * (by calling Mailbox.getAllMessages())
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		String allMessages = "";
		
		if (listOfRecipients.size() == 0) {
			return "";
		}
		
		for (int i = 0; i <= listOfRecipients.size() -1; i++) {
			if (user == listOfRecipients.get(i).getUser()) {
				allMessages += listOfRecipients.get(i).getAllMessages();
				//System.out.println("i: " + i);
				//System.out.println(listOfRecipients);
			}

		}
		return allMessages;
	}
	
	public void printRecipientList() {
		for (Mailbox recipient: listOfRecipients) {
			System.out.println(recipient);
		}
	}
	
	public static void main(String[] args) {

		MessagingSystem system = new MessagingSystem();
		
		system.deliver("Cooper", "Bob", "Hello Bob, great work yesterday!");

		system.deliver("Cooper", "Bob", "Cheers mate!");
		System.out.println("Recipient message:\n " + system.getMessages("Bob") + "\n");


		system.deliver("Cooper", "Dylan", "Hello Dylan, welcome to the team!");
		system.deliver("Cooper", "Dylan", "Dyan, what does your day look like today?");

		System.out.println("Recipient message:\n " + system.getMessages("Dylan") + "\n");

		system.deliver("Cooper", "Sheer", "Sheer, come in today okay?");

		System.out.println("Recipient message:\n " + system.getMessages("Sheer") + "\n");
		//system.deliver("Cooper", "Dylan", "Are you available to come in for work?");
		//System.out.println("MAIN: \n" + system.getMessages("Bob"));

		
		
		
		
		
		//system.deliver("Cooper", "Charlie", "Hello, great work yesterday!");
		
		

		//Message message = new Message("Cooper","Bob", "Hello, great work yesterday!");
		//system.deliver("Cooper", "Bob", "Hello, great work yesterday!");
		//system.deliver("Cooper", "Bob", "You did such a great job yesterday, can you help again today?");
		
		//System.out.println("MAIN: \n" + system.getMessages("Bob"));

		
		//system.deliver("Cooper", "Luke", "HELLO MATE!");
		//System.out.println("MAIN: " + system.getMessages("Luke"));


		//System.out.println(system.getMessages("Cooper"));		

		

		//mailbox.printMailBox();
		//System.out.println(mailbox2.getAllMessages());
	}
}

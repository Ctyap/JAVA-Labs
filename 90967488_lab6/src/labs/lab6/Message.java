package labs.lab6;

/**
 * An email message.
 */
public class Message {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String sender="", recipient="", text="", message="";
	/**
	 * Constructs a Message object.
	 * 
	 * @param from the sender of the message
	 */
	public Message(String from, String to, String text) {
		this.sender = from;
		this.recipient = to;
		this.text = text;
	}

	/**
	 * Gets the recipient.
	 * 
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;}

	/**
	 * Formats the email message as follows (see assignment example):
	 * From: [sender]
	 * To: [recipient]
	 * [Message text]
	 */
	public String toString() {
		message += "From: " + sender + "\n";
		message += "To: " + recipient + "\n";
		message += text;
		return message;
	}
	
	public static void main(String[] args) {
		
		Message message = new Message("Cooper","Bob", "Hello, great work yesterday!");
		System.out.println(message.toString());
	}
}

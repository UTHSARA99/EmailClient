package Email_Client;

import java.io.Serializable;

public class Recipient implements Serializable{
	private final String NAME;   // final access modifier is used as values of these should not change by any outsider
	private final String EMAIL_ADDRESS;
	public static int recipient_count = 0;
	
	
	public Recipient(String name, String email_address) {
		NAME = name;
		EMAIL_ADDRESS = email_address;
		recipient_count++;
	}
	

	public String getName() {
		return NAME;
	}
	
	public String getEmail_address() {
		return EMAIL_ADDRESS;
	}
	
}

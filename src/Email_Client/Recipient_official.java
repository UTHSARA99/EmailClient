package Email_Client;

public class Recipient_official extends Recipient{
	private final String DESIGNATION;
	
	public Recipient_official(String name, String email_address, String designation) {
		super(name, email_address);
		DESIGNATION = designation;
	}
}

package Email_Client;

public class Recipient_officeFriends extends Recipient implements BirthDay_Wish{
	private final String DESIGNATION;
	private final String BIRTHDAY;
	
	public Recipient_officeFriends(String name, String email_address, String designation, String birthday) {
		super(name, email_address);
		DESIGNATION = designation;
		BIRTHDAY = birthday;
	}

	@Override
	public String Birthday_Wish() {
		
		return null;
	}
}

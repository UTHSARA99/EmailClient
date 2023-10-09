package Email_Client;

public class Recipient_Office_Friend extends Recipient implements Birthday_Wishable{
    private final String DESIGNATION;
    private final String BIRTHDAY;

    public Recipient_Office_Friend(String name, String email_address, String designation, String birthday) {
        super(name, email_address);
        DESIGNATION = designation;
        BIRTHDAY = birthday;
    }

    public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	
	public String getDESIGNATION() {
		return DESIGNATION;
	}
	
	//overrides the method to return b'day wish
	@Override
	public String Birthday_Wish() {
		String wish = "Wish you a Happy Birthday \n -From Uthsara-";
		return wish;	
	}

}

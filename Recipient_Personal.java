package Email_Client;

public class Recipient_Personal extends Recipient implements Birthday_Wishable{
    private final String NICKNAME;
	private final String BIRTHDAY;

    public Recipient_Personal(String name, String nickname, String email_address, String birthday) {
        super(name, email_address);
        NICKNAME = nickname;
        BIRTHDAY = birthday;
    }

    //returns b'day
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}

    //returns nickname
    public String getNICKNAME() {
        return NICKNAME;
    }

	//overrides the method to return b'day wish
	@Override
	public String Birthday_Wish() {
		String wish = "Hugs and Love on your Birthday \n -From Uthsara-";
		return wish;
	}
    
}

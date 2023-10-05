package Email_Client;

public class Recipients_personal extends Recipient implements BirthDay_Wish {
	private final String NICKNAME;
	private final String BIRTHDAY;
	
	public Recipients_personal(String name, String nickname, String email_address, String birthday) {
		super(name, email_address);
		NICKNAME = nickname;
		BIRTHDAY = birthday;
	}

	@Override
	public String Birthday_Wish() {
		
		return null;
	}
}

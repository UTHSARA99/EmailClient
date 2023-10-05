package Email_Client;

public class RecipientObjects {
	Recipient_official obj1;
	Recipient_officeFriends obj2;
	Recipients_personal obj3;
	
	
	public void createrecipient(String details) {
		String[] fields = details.split(": ");
		
		if (fields[0].equals("Official")) {
			String[] field_details = fields[1].split(",");
			
			obj1 = new Recipient_official(field_details[0], field_details[1], field_details[2]);
			
		}
		
		else if(fields[0].equals("Office_friend")) {
			String[] field_details = fields[1].split(",");
			
			obj2 = new Recipient_officeFriends(field_details[0], field_details[1], field_details[2], field_details[3]);
		
		}
		
		else if(fields[0].equals("Recipients_personal")) {
			String[] field_details = fields[1].split(",");
			
			obj3 = new Recipients_personal(field_details[0], field_details[1], field_details[2], field_details[3]);
		}
				
			
	}
}


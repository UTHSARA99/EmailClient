package Email_Client;

public class Recipient_Object {
    Recipient_Official obj1;
	Recipient_Office_Friend obj2;
	Recipient_Personal obj3;
	
	//Creates objects out of given parameters as details
	public void createrecipient(String details) {
		String[] fields = details.split(": ");
		
		if (fields[0].equals("Official")) {
			String[] field_details = fields[1].split(",");
			
			obj1 = new Recipient_Official(field_details[0], field_details[1], field_details[2]);
		}
		
		else if(fields[0].equals("Office_friend")) {
			String[] field_details = fields[1].split(",");
			
			obj2 = new Recipient_Office_Friend(field_details[0], field_details[1], field_details[2], field_details[3]);
		}
		
		else if(fields[0].equals("Friend")) {
			String[] field_details = fields[1].split(",");
			
			obj3 = new Recipient_Personal(field_details[0], field_details[1], field_details[2], field_details[3]);
		}
	}
}

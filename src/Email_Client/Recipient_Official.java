package Email_Client;

public class Recipient_Official extends Recipient{
    private final String DESIGNATION;

    public  Recipient_Official(String name, String email_address, String designation){
        super(name, email_address);
        DESIGNATION = designation; 
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }
    
}

package Email_Client;

//interface to send b'day wishes.
import java.time.LocalDate;

public interface Birthday_Wishable{
	LocalDate date = LocalDate.now();
	String Birthday_Wish();
}
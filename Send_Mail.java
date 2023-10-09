package Email_Client;

import java.time.LocalDate;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.io.Serializable;


public class Send_Mail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String recipient;
	String subject;
	String body;
	String date;
	LocalDate date1;
	
	//this method is used to send mails with the given parameters as inputs
    public void send_mail(String recipient, String subject, String body){
    	
    	this.recipient = recipient;
    	this.subject = subject;
    	this.body = body;
    	date1 = LocalDate.now();
    	date = date1.toString();
    	
    	
        final String username = "autissera@gmail.com";  //this is where the email address of the sender is entered
        final String password = "test123";   // this is the password of the sender

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("autissera@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Message sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

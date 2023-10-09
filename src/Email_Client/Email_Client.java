package Email_Client;

//200665U

//import libraries

import java.io.File;
import java.time.LocalDate;
import java.util.*;


public class Email_Client {
	
	  
	  static ArrayList<Recipient_Object> recipients;  //stores objects of the recipients as objects
	  static ArrayList<Send_Mail> emaillist;      //stores sent emails
	  private static int recipient_count = 0;     //static variable is used to update the recipients
	  
      public static void main(String[] args){
    	    
    	    //creates objects after starting the email client.
    	    recipients = Read_Write_Recipient.readrecipient();
    	    //updates the recipient count
    	    recipient_count = recipients.size();
    	    
    	    //creates a file for serialization if not created
    	    File file = new File("C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
    	    
    	    if(!file.exists()) {
    	    	emaillist = new ArrayList<Send_Mail>();
        	    Email_Storage.serial(emaillist, "C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
    	    }
    	    
    	    //deserialization step
    	    emaillist = Email_Storage.deserial("C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
    	    
    	    
    	    BirthDay_Mail_Check(); //send email for birthdays if b'day is today
    	    
    	    
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                  + "1 - Adding a new recipient\n"
                  + "2 - Sending an email\n"
                  + "3 - Printing out all the recipients who have birthdays\n"
                  + "4 - Printing out details of all the emails sent\n"
                  + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();
            scanner.nextLine();
            
            
       
            switch(option){
                  case 1:
                      // input format - Official: nimal,nimal@gmail.com,ceo
                      // Use a single input to get all the details of a recipient
                      // code to add a new recipient
                      // store details in clientList.txt file
                      // Hint: use methods for reading and writing files
                	  
                	  System.out.println("Please use the below format to enter data: \n"
                	  		+ "Official: <name>,<email address>,<designation> \n"
                	  		+ "Office_friend: <name>,<email address>,<designation>,<birthday> \n"
                	  		+ "Friend: <name>,<nick-name>,<email address>,<birthday> \n");
                	  
                	  Scanner scanner1 = new Scanner(System.in);
                     
                      String entry = scanner1.nextLine();
                      
                      Read_Write_Recipient obj = new Read_Write_Recipient();
                      obj.writerecipient(entry);
                      
                      recipients = Read_Write_Recipient.readrecipient();
                      
                      recipient_count++;
                      
                      
                      break;
                  case 2:
                      // input format - email, subject, content
                	  // code to send an email
                	  
                		  Scanner scanner2 = new Scanner(System.in);
                		  
                		  System.out.println("Please enter the recipient, subject of the email and body as following: "
                				  + "<recipient_email>, <subject>, <body>");
                		  
                		  
                		  String input = scanner2.nextLine();
                		  scanner2.close();
                		  
                		  String[] dataList = input.split(", ");
                		  
                		  String recipient_email = dataList[0];
                		  String subject = dataList[1];
                		  String body = dataList[2];
                	      	 
                		  
                		  Send_Mail obj1 = new Send_Mail();
                		  obj1.send_mail(recipient_email, subject, body);
                		  
                		  emaillist.add(obj1);
                		  
                		  Email_Storage.serial(emaillist, "C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
                	  
                	  
                      break;
                  case 3:
                      // input format - yyyy/MM/dd (ex: 2018/09/17)
                      // code to print recipients who have birthdays on the given date
                	  Scanner scanner3 = new Scanner(System.in);
                	  
                	  System.out.println("Please Enter Birthday: input format - yyyy/MM/dd");
                	  String inputDate = scanner3.nextLine();
                	  
                	  for(Recipient_Object k : recipients) {
                		  try {
                			  try {
                				  if (inputDate.equals(k.obj2.getBIRTHDAY())){
                					  System.out.println(k.obj2.getNAME());
                				  }  
                			  }
                			  catch(Exception e) {}
                			  
                			  if (inputDate.equals(k.obj3.getBIRTHDAY())){
            					  System.out.println(k.obj3.getNAME());
            				  }
                		  }
                		  catch(Exception d){}
                	  }

                	  
                      break;
                  case 4:
                      // input format - yyyy/MM/dd (ex: 2018/09/17)
                      // code to print the details of all the emails sent on the input date
                	  
                	  Scanner scanner4 = new Scanner(System.in);
                	  System.out.println("Please Enter Date: input format - yyyy/MM/dd");
                	  String inputDate1 = scanner4.nextLine();
                	  
                	  String[] date_split1 = inputDate1.split("/"); //take date as input and splits to comparison
                	  
                	  System.out.println("Emails sent on " + inputDate1);
                	  
                	  for(Send_Mail m : emaillist) {
                		  String[] maildate_split = m.date.split("-");
                		  
                		  if((date_split1[0].equals(maildate_split[0])) &&  (date_split1[1].equals(maildate_split[1])) &&  (date_split1[2].equals(maildate_split[2]))) {
                			  System.out.println("Recipient Email: " + m.recipient + "  Subject: " + m.subject);
                		  }
                	  }
                	  
                	  
                	  
                	  
                      break;
                  case 5:
                      // code to print the number of recipient objects in the application
                	  
                	  System.out.println("The number of recipient objects in the application: " + recipient_count); //returns the recipient count
                	  
                	  
                      break;
            }
      }
            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes 
      //stops sending duplicate mails
      static void BirthDay_Mail_Check() {
    	  LocalDate d = LocalDate.now();
    	  boolean check = true;
    	  
    	  for(Send_Mail m : emaillist) {
    		if(d.compareTo(m.date1) == 0){
    			if( m.subject.equals("BirthDay Wishes")){
    				check = false;
    				break;
    			}
    		}
    	  }
    	  if(check) {
    		  BirthDay_Mail();
    	  }
    	  
      }
      
      //method to send email automatically, at start
      static void BirthDay_Mail() {
    	  for(Recipient_Object k : recipients) {
    		  try {
    			  try {
    				  String[] birthday_split = k.obj2.getBIRTHDAY().split("/");
    				  String[] today_split = k.obj2.date.toString().split("-");
    				  if((birthday_split[1].equals(today_split[1])) && (birthday_split[2].equals(today_split[2]))) {
    					  
    					  Send_Mail obj1 = new Send_Mail();
                		  obj1.send_mail(k.obj2.getEMAIL_ADDRESS(), "BirthDay Wishes", k.obj2.Birthday_Wish());
                		  //adds e,mail as object to emaillist
                		  emaillist.add(obj1);
                		  
                		  Email_Storage.serial(emaillist, "C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
    				  }
    			  }
    			  catch(Exception e) {
    			  }
    			  
    			  String[] birthday_split = k.obj3.getBIRTHDAY().split("/");
				  String[] today_split = k.obj3.date.toString().split("-");
				  if((birthday_split[1].equals(today_split[1])) && (birthday_split[2].equals(today_split[2]))) {
					  
					  Send_Mail obj1 = new Send_Mail();
            		  obj1.send_mail(k.obj3.getEMAIL_ADDRESS(), "BirthDay Wishes", k.obj3.Birthday_Wish());
            		  //adds sent mail to emaillist for serialzation
            		  emaillist.add(obj1);
            		  //serializes the emaillist
            		  Email_Storage.serial(emaillist, "C:\\Users\\Asel\\Email_Client\\Email_Client\\EmailList.ser");
				  }
    		  }
    		  catch(Exception d){}
    	  }
      }
}
// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
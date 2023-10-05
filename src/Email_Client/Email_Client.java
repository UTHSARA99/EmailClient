package Email_Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

// your index number

//import libraries

public class Email_Client {
	
	  ArrayList<RecipientObjects> Recipients = new ArrayList<RecipientObjects>();

      public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                  + "1 - Adding a new recipient\n"
                  + "2 - Sending an email\n"
                  + "3 - Printing out all the recipients who have birthdays\n"
                  + "4 - Printing out details of all the emails sent\n"
                  + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();
            scanner.nextLine();
            //scanner.close();
            
            
            

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
                      
                      ReadWriteRecipient obj = new ReadWriteRecipient();
                      obj.writerecipient(entry);
                      
                      RecipientObjects obj1 = new RecipientObjects();
                      obj1.createrecipient(entry);
                      
                      
                      
                      
                      //adding the object recipient to the array list
                      File file_obj= new File("D:\\RecipArray.ser");
                      try {
                    	   if(file_obj.createNewFile()) {
                    		   seri(Recipients, "D:\\RecipArray.ser");
                    	   }
                    	  } 
                      catch
                    	  (IOException e) {e.printStackTrace();
                    	  System.out.print("Error");}
                      
                      Recipients = (ArrayList<RecipientObjects>) deseri("D:\\RecipArray.ser");
                      System.out.println(Recipients.get(0).obj1.getEmail_address());
                      System.out.println("ERROR");
                      Recipients.add(obj1);
                      System.out.println("ER");
                      
                      //System.out.println(Recipients.get(0).obj1.getEmail_address());
                      
                      seri(Recipients, "D:\\RecipArray.ser");
                      System.out.println("eooR");
                      //Recipients = (ArrayList) deseri("D:\\RecipArray.ser");
                	  //System.out.println(Recipients.get(1).obj1.getEmail_address());
                	  
            
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
                	      	 

                		  Send_Mail.send_mail(recipient_email, subject, body);
                	  
                	  
                      break;
                  case 3:
                      // input format - yyyy/MM/dd (ex: 2018/09/17)
                      // code to print recipients who have birthdays on the given date
                	  
                	  //ReadWriteRecipient line = new ReadWriteRecipient();
                	  ReadWriteRecipient.readrecipient();
                	  
                	  
                	  
                	  //read from text file
                	  //check the type whether officefriend or personal
                	  //if so birthday
                	  //Email_client_support class keep the read recipient and new class for create recipient
                	  
                	  
                	  
                	  
                	  
                	  
                	  
                	  
                      break;
                  case 4:
                      // input format - yyyy/MM/dd (ex: 2018/09/17)
                      // code to print the details of all the emails sent on the input date
                	  
                	  
                	  
                	  
                      break;
                  case 5:
                      // code to print the number of recipient objects in the application
                      break;

            }

            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes
            
        }
      
      static void  seri(Object obj, String path) {
    	  try{
    		  FileOutputStream fout =new FileOutputStream(path);
    	      ObjectOutputStream out= new ObjectOutputStream(fout) ;
    	     out.writeObject(obj);
    	     out.close();
    	     fout.close();
    	  }

    	  catch(IOException i) {}
    	  
      }
      
      static Object deseri(String path) {
    	  
    	  Object e = null;
    	  try {
    		  
    	        FileInputStream fileIn = new FileInputStream(path);
    	        ObjectInputStream in = new ObjectInputStream(fileIn);
    	        e = in.readObject();
    	        in.close();
    	        fileIn.close();
    	      }
    	  catch (IOException i) {
    	         i.printStackTrace();
    	         
    	      } 
    	  catch (ClassNotFoundException c) {
    	         System.out.println("Employee class not found");
    	         c.printStackTrace();
    	         }
    	return e;
      }
    	
} //ArrayList e =(ArrayList) EmailClient.deseri(path)

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
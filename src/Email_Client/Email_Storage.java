package Email_Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Email_Storage {
	
	//Used for serialize mail objects saved to an arraylist
	static void serial(ArrayList<Send_Mail> obj, String path) {
  	  try{
  		  FileOutputStream fout =new FileOutputStream(path);
  	      ObjectOutputStream out= new ObjectOutputStream(fout) ;
  	      out.writeObject(obj);
  	      out.close();
  	      fout.close();
  	  }

  	  catch(IOException i) {}
  	  
    }
    
  	//Used to deserialize the mail objects.
  	@SuppressWarnings("unchecked")
	static ArrayList<Send_Mail> deserial(String path) {
	  	  
	  	  ArrayList<Send_Mail> e = null;
	  	  try {
	  		  		FileInputStream fileIn = new FileInputStream(path);
	  	        	ObjectInputStream in = new ObjectInputStream(fileIn);
	  	        	e = (ArrayList<Send_Mail>) in.readObject();
	  	        		in.close();
	  	        	
	  	  }
	  	  catch (IOException i) {
	  	         i.printStackTrace();  
	  	      } 
	  	  
	  	  catch (ClassNotFoundException c) {
	  	         System.out.println(" ");
	  	         c.printStackTrace();
	  	         }
	  	return e;
	    }
    }
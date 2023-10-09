package Email_Client;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Read_Write_Recipient {
	
	//This method writes and saves details of recipients to clientList.txt
	public void writerecipient(String details) {
		try {
			FileWriter writer=new FileWriter("clientList.txt",true);
			BufferedWriter bw = new BufferedWriter(writer);
			writer.write(details+"\n");
			writer.close();
			bw.close();
        }
		catch (IOException e) {e.printStackTrace();}
		}
	
	//This method creates objects of recipients out of the saved in clientList.txt
	public static ArrayList<Recipient_Object> readrecipient() {
		
		ArrayList<Recipient_Object> recipientlist = new ArrayList<Recipient_Object>();
		
		try {
			//reds the text file line by line and creates objects out of the details using Recipient_Object class
			FileReader reader=new FileReader("C:\\Users\\Asel\\Email_Client\\Email_Client\\clientList.txt");
			BufferedReader br = new BufferedReader(reader);
			String line;
			
				while(((line=br.readLine())!= null)) {
					Recipient_Object obj1 = new Recipient_Object();
                    obj1.createrecipient(line);
                    recipientlist.add(obj1);
					
					}
			reader.close();
			br.close();
        }
		catch (IOException e) {
			e.printStackTrace();
			}
		return recipientlist;
		}

    
    }
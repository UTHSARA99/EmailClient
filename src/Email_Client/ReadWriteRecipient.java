package Email_Client;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteRecipient {
	
	
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
	
	
	public static void readrecipient() {
		try {
			
			FileReader reader=new FileReader("G:/Java projects/Email_Client/clientList.txt");
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			
				while(line != null) {
					//System.out.println(line);
					line = br.readLine();
					
					String[] dataList = line.split(": ");
					
					
					if(dataList[0].equals("Office_friend") || dataList[0].equals("Friend")) {
						String[] field_details = dataList[1].split(",");
					}
					
					
				}
			reader.close();
			br.close();
        }
		catch (IOException e) {e.printStackTrace();}
		}
	
}



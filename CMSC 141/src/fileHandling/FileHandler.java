package fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {
	
	@SuppressWarnings("resource")
	public static String loadFile(String path) {
		String data = "";
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String thisLine = null;
	         
			while ((thisLine = br.readLine()) != null) {
				data += thisLine + "\n";
			}       
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
}	

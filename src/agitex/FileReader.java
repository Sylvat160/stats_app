package agitex;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	private List<Client> clients;
	
	 public FileReader() {
		 this.clients = new ArrayList<>();
	 }
	 
	 public List<Client> readFile(String _filePath)
	 {
		 try 
		 {
			 File file = new File(_filePath);
		 }catch (Exception e) 
		 {
			 e.printStackTrace();
		 }
		 
		 return clients;
	 }
}

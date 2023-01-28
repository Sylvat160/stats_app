package agitex;

import java.io.BufferedReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaders {
	private List<Client> clients;
	
//	 public FileReaders() {
//		 this.clients = new ArrayList<>();
//	 }
	 
	 public void readTxt()  throws FileNotFoundException
	 {
		 // 
		 File file = new File("/home/ts/Developpement/JAVA/agitex/src/agitex/client.txt");
		 Scanner scan = new Scanner(file);
//		 List<String> cl = ;
		 int i = 0;
		 
		 String fi = "";
		 while (scan.hasNextLine())
		 {
			 fi = fi.concat(scan.nextLine() + "\n");
//			 System.out.println(scan.nextLine());
		 }
		 
		 System.out.println(fi);
	 }
	 
	 public void readJson() throws FileNotFoundException
	 {
		 String jsonContent = "";
		 try {
			 BufferedReader br = new BufferedReader(new FileReader("/home/ts/Developpement/JAVA/agitex/src/agitex/client.json"));
			 
			 String line;
			 while ((line = br.readLine()) != null)
			 {
				 jsonContent += line + "\n";
				 JSONParser parser = new JSONParser();
				 Object ob = parser.parse(new FileReader("/home/ts/Developpement/JAVA/agitex/src/agitex/client.json"));
				 JSONObject json = (JSONObject) ob;
				 
//				 String name = (String) json.get("client");
//				 JSONObject clients = (JSONObject) json.get("client");
				 JSONArray jsonArray = (JSONArray) json.get("clients");
				 for (int i = 0; i < jsonArray.size(); i++)
				 {
					 JSONObject client = (JSONObject) jsonArray.get(i);
					 String nom = (String) client.get("nom");
					 String prenom = (String) client.get("prenom");
					 long age = (long) client.get("age");
					 String profession = (String) client.get("profession");
					 long salaire = (long) client.get("salaire");
					 System.out.println(nom + " " + prenom + "\n");
				 }
				 
			 }
			 br.close();
		 }catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	 public void readCsv() throws FileNotFoundException
	 {
		 String file = "/home/ts/Developpement/JAVA/agitex/src/agitex/client.csv";
		 BufferedReader reader =  null;
		 String line = "";
		 
		 try {
			 reader =  new BufferedReader(new FileReader(file));
			 while((line = reader.readLine()) != null) 
			 {
				 	String[] row = line.split(",");
				 	
				 	for (String index : row) 
				 	{
				 		System.out.printf("%10s", index);
				 	}
				 	System.out.println();
			 }
			 reader.close();
		 } catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
//	 public List<Client> readFile(String _filePath)
//	 {
//		 try 
//		 {
////			 File file = new File(_filePath);
//			 File file = new File("example.txt");
//			 String fileName = file.getName();
//			 int dotIndex = fileName.lastIndexOf(".");
//			 String extension = fileName.substring(dotIndex + 1);
//			 System.out.println("Extension : " + extension);
//
//		 }catch (Exception e) 
//		 {
//			 e.printStackTrace();
//		 }
//		 
//		 return clients;
//	 }
}

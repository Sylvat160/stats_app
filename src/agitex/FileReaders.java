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
	
	 public FileReaders() {
		 this.clients = new ArrayList<>();
	 }
	 
	private void readTxt(String filePath)  throws FileNotFoundException
	 {
		 // 
//		 File file = new File("/home/ts/Developpement/JAVA/agitex/src/agitex/client.txt");
		 File file = new File(filePath);
		 Scanner scan = new Scanner(file);
//		 List<String> cl = ;
		 
		 String fi = "";
		 while (scan.hasNextLine())
		 {
			 fi = fi.concat(scan.nextLine() + "\n");
//			 System.out.println(scan.nextLine());
		 }
		 
		 System.out.println(fi);
		 scan.close();

	 }
	 
	 public void readJson(String filePath) throws FileNotFoundException
	 {
		 try {
//			 BufferedReader br = new BufferedReader(new FileReader(filePath));
			
			 JSONParser parser = new JSONParser();
			 Object obj = parser.parse(new FileReader(filePath));
			 JSONObject json = (JSONObject) obj;
			 
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
				 Client cl = new Client(nom,prenom,age,profession,salaire);
				 clients.add(cl);
				 
			 }
//			 System.out.println("clients :" + clients);
//			 System.out.println(clients.get(0).getNames());
		 }catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
	 public void readCsv(String filePath) throws FileNotFoundException
	 {
//		 String file = "/home/ts/Developpement/JAVA/agitex/src/agitex/client.csv";
		 BufferedReader reader =  null;
		 String line = "";
		 
		 try {
			 reader =  new BufferedReader(new FileReader(filePath));
			 while((line = reader.readLine()) != null) 
			 {
				 	String[] row = line.split(",");
				 	
				 	for (String index : row) 
				 	{
				 		System.out.printf("%10s", index);
				 	}
				 	System.out.println(row[0]);
				 	clients.add(new Client(row[0], row[1], Long.parseLong(row[2]), row[3], Long.parseLong(row[4])));
				 	
				 	System.out.println(clients);
				 	System.out.println();
			 }
			 reader.close();
		 } catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	 
//	 void readXml() throws FileNotFoundException
//	 {
//		 try
//		 {
//			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			 DocumentBuilder builder = factory.newDocumentBuilder();
//			 Document doc = builder.parse("path");
//			 System.out.println(doc.getDocumentElement().getNodeName());
//			 NodeList list = doc.getElementsByTagName("client");
//			 for (int i = 0; i < list.getLength(); i++)
//			 {
//				 Node n = list.item(i);
//				 System.out.println(n.getNodeName());
//				 Element el = (Element) n;
//				 System.out.println("nom : " + el.getElementsBytagName("nom").item(0));
//			 }
//		 }catch(Exception e)
//		 {
//			 e.printStackTrace();
//		 }
//	 }
	 
	 public void readFile(String filePath)
	 {

		 
//			 File file = new File(_filePath);
			 File file = new File(filePath);
			 String fileName = file.getName();
			 int dotIndex = fileName.lastIndexOf(".");
			 String extension = fileName.substring(dotIndex + 1);
//			 System.out.println("Extension : " + extension);
			 if (extension == "cvs")
			 {
				 try {
					readCsv(filePath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 else if (extension == "json")
			 {
				 try {
					readJson(filePath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			 else 
			 {
				 try {
					readTxt(filePath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 
		 
	 }
}

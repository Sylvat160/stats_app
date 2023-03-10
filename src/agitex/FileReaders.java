package agitex;

import java.io.BufferedReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class FileReaders {
	private List<Client> clients;
	
	 public FileReaders() {
		 this.clients = new ArrayList<>();
	 }
	 
	 
	 public List<Client> readJson(String filePath) throws Exception
	 {
		 
		 File file = new File(filePath);
		 String fileName = file.getName();
		 int dotIndex = fileName.lastIndexOf(".");
		 String extension = fileName.substring(dotIndex + 1);
		 if (!extension.equals("json"))
		 {
			 throw new Exception("Le fichier n'est pas de format JSON");
		 }
		 try {
			
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
		 return clients;
	 }
	 
	 public List<Client> readOtherFile(String filePath) throws Exception
	 {
//		 String file = "/home/ts/Developpement/JAVA/agitex/src/agitex/client.csv";
		 BufferedReader reader =  null;
		 String line = "";
		 List<String> fileList = Arrays.asList("txt", "csv");
		 File file = new File(filePath);
		 String fileName = file.getName();
		 int dotIndex = fileName.lastIndexOf(".");
		 String extension = fileName.substring(dotIndex + 1);
		 if (!fileList.contains(extension))
		 {
			 throw new Exception("Le format du fichier n'est pas encore pris en charge");
		 }
		 
		 try {
			 reader =  new BufferedReader(new FileReader(filePath));
			 while((line = reader.readLine()) != null) 
			 {
				 	String[] row = line.split(",");
				 	
//				 	for (String index : row) 
//				 	{
//				 		System.out.printf("%10s", index);
//				 	}
				 	
				 	clients.add(new Client(row[0], row[1], Long.parseLong(row[2]), row[3], Long.parseLong(row[4])));
				 	System.out.println();
			 }
			 reader.close();
		 } catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 return clients;
	 }
	 
	 List<Client> readXml(String filePath) throws Exception
	 {
		 
		 File file = new File(filePath);
		 String fileName = file.getName();
		 int dotIndex = fileName.lastIndexOf(".");
		 String extension = fileName.substring(dotIndex + 1);
		 if (!extension.equals("xml"))
		 {
			 throw new Exception("Le fichier n'est pas de format xml");
		 }
		 try
		 {
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder builder = factory.newDocumentBuilder();
			 Document doc = builder.parse(filePath);
			 System.out.println(doc.getDocumentElement().getNodeName());
			 NodeList list = doc.getElementsByTagName("clients");
			 for (int i = 0; i < list.getLength(); i++)
			 {
				 Node n = list.item(i);
//				 System.out.println(n.getNodeName());
				 Element el = (Element) n;
				 String nom = el.getElementsByTagName("nom").item(0).getTextContent();
				 String prenom = el.getElementsByTagName("prenom").item(0).getTextContent();
				 Long age = Long.parseLong(el.getElementsByTagName("age").item(0).getTextContent());
				 String profession = el.getElementsByTagName("profession").item(0).getTextContent();
				 Long salaire = Long.parseLong(el.getElementsByTagName("salaire").item(0).getTextContent());
				 clients.add(new Client(nom, prenom, age, profession, salaire));
			 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return clients;
	 }
	 
//	 File file = new File(filePath);
//	 String fileName = file.getName();
//	 int dotIndex = fileName.lastIndexOf(".");
//	 String extension = fileName.substring(dotIndex + 1);
}

package agitex;

import java.io.FileNotFoundException;
import java.util.List;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileReaders file = new FileReaders();
		try {
//			List<Client> clients = file.readCsv("/home/ts/Developpement/JAVA/agitex/src/agitex/client.txt");
			List<Client> xml = file.readXml("/home/ts/Developpement/JAVA/agitex/src/agitex/cl.xl");
			Statistics stats = new Statistics(xml);
			System.out.println(stats.getMoyenneSP());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package agitex;

import java.io.FileNotFoundException;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReaders file = new FileReaders();
		try {
			List<Client> clients = file.readCsv("/home/ts/Developpement/JAVA/agitex/src/agitex/client.txt");
			Statistics stats = new Statistics(clients);
			System.out.println(stats.getMoyenneSP());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

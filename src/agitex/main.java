package agitex;

import java.io.FileNotFoundException;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client sylva = new Client("TAG", "Syl", 23, "Dev", 200000);
		
		System.out.println(sylva.getNames());
		
		FileReaders file = new FileReaders();
		try {
			List<Client> clients = file.readJson("/home/ts/Developpement/JAVA/agitex/src/agitex/client.json");
			Statistics stats = new Statistics(clients);
			System.out.println(stats.getMoyenneSP());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

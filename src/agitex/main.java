package agitex;

import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client sylva = new Client("TAG", "Syl", 23, "Dev", 200000);
		
		System.out.println(sylva.getNames());
		
		FileReaders file = new FileReaders();
		try {
			file.readCsv();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

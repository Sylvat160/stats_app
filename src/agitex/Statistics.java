package agitex;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    private HashMap<String, Float> moyenneSP;
    
    public Statistics(List<Client> clients)
    {
    	this.moyenneSP = new HashMap<>();
    	
    	for (Client c : clients) {
    		String profession = c.getProfession();
    		float salaire = c.getSalaire();
    		
    		if (!moyenneSP.containsKey(profession))
    		{
    			moyenneSP.put(profession, salaire);
    		} else 
    		{
    			float moyenneActuelle = moyenneSP.get(profession);
    			int count = getClientCountByPofession(clients, profession);
    			moyenneSP.put(profession, (moyenneActuelle * (count - 1) + salaire) / count);
    			System.out.println("MA : " + moyenneActuelle + "count : " + count + "HM : " + moyenneSP  );
    		}
    	}
    }
    
    private int getClientCountByPofession(List<Client> clients, String profession)
    {
    	int count = 0;
    	for (Client c : clients)
    	{
    		if (c.getProfession().equals(profession)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public HashMap<String, Float> getMoyenneSP() {
    	return moyenneSP;
    }
}

package agitex;

public class Client {
	private String nom, prenom, profession;
	private long age;
	private long salaire;
	
	Client(String nom,String prenom,long age,String profession, long salaire){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.profession = profession;
		this.salaire = salaire;
	}
	
	public String getNames() {
		return nom + " " + prenom;
	}
	
	public void updateNames(String _nom, String _prenom)
	{
		this.nom = _nom;
		this.prenom = _prenom;
	}
	
	public String getProfession()
	{
		return profession;
	}
	
	public void updateProfession(String _profession)
	{
		this.profession = _profession;
	}
	
	public long getSalaire() {
		return salaire;
	}
	public void updateSalaire(long _salaire) 
	{
		this.salaire = _salaire;
	}
	
	public long getAge()
	{
		return age;
	}
	
	public void updateAge(long _age)
	{
		this.age = _age;
	}
	
}

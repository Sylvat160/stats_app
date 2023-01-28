package agitex;

public class Client {
	private String nom, prenom, profession;
	private int age;
	private float salaire;
	
	Client(String nom,String prenom,int age,String profession, float salaire){
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
	
	public float getSalaire() {
		return salaire;
	}
	public void updateSalaire(float _salaire) 
	{
		this.salaire = _salaire;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void updateAge(int _age)
	{
		this.age = _age;
	}
	
}

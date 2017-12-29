package co.simplon;

public interface Reservation {

	public String getNom();
	public void setNom(String nom);
	
	public String getPrenom();
	public void setPrenom(String prenom);
	
	public String getMail();
	public void setMail(String mail);
	
	public String getTelephone();
	public void setTelephone(String telephone);
	
	public String getDateArrive();
	public void setDateArrive(String dateArrive);
	
	public String getNbNuit();
	public void setNbNuit(String nbNuit);
	
	public String getNbPersonne();
	void setNbPersonne(String nbPersonne);
	
	public String getNomRegion();
	public void setNomRegion(String nomRegion);
	
	public String parkingCheck();
	public void setParking(Boolean parking);
	
	public String animalCheck();
	public void setAnimal(Boolean animal);
	
	public void setFumeur(Boolean fumeur);
	public String fumeurCheck();
	
	void add(Reservation reservation);
		
}

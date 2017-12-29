package co.simplon;


//Classe d'implémentation pour les objets reservation
public class ReservationImpl implements Reservation{

	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private String dateArrive;
	private String nbNuit;
	private String nbPersonne;
	private String nomRegion;
	private boolean parking;
	private boolean animal;
	private boolean fumeur;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
}
	@Override
	public String getMail() {
		// TODO Auto-generated method stub
		return mail;
	}
	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String getTelephone() {
		// TODO Auto-generated method stub
		return telephone;
	}
	@Override
	public void setTelephone(String telephone) {
		this.telephone = telephone;
		
	}
	@Override
	public String getDateArrive() {
		return dateArrive;
	}
	@Override
	public void setDateArrive(String dateArrive) {
		this.dateArrive = dateArrive;
	}
	@Override
	public void setNbNuit(String nbNuit) {
		this.nbNuit = nbNuit;
		
	}
	@Override
	public String getNbNuit() {
		return nbNuit;
	}
	@Override
	public String getNbPersonne() {
		return nbPersonne;
	}
	@Override
	public void setNbPersonne(String nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	@Override
	public String getNomRegion() {
		// TODO Auto-generated method stub
		return nomRegion;
	}
	@Override
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
		
	}
	
	public boolean isParking() {
		return parking;
	}
	
	@Override
	public String parkingCheck() {
		if (isParking()==true) {
			return "Oui";
		}
		return "Non";
	}
	
	public void setParking(Boolean parking) {
		this.parking = parking;
	}
	
	public boolean isAnimal() {
		return animal;
	}
	
	@Override
	public String animalCheck() {
		if (isAnimal()==true) {
			return "Oui";
		}
		return "Non";
	}
	
	public void setAnimal(Boolean animal) {
		this.animal = animal;
	}
	
	public boolean isFumeur() {
		return fumeur;
		}
	
	@Override
	public String fumeurCheck() {
		if (isFumeur()==true) {
			return "Oui";
		}
		return "Non";
	}
	
	public void setFumeur(Boolean fumeur) {
		this.fumeur = fumeur;
	}
	@Override
	public void add(Reservation reservation) {
		// TODO Auto-generated method stub
	}
}
	


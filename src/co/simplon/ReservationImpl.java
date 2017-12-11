package co.simplon;

import java.util.Date;


//Classe d'implémentation pour les objets reservation
public class ReservationImpl implements Reservation{

	private String nom;
	private String prenom;
	
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

}
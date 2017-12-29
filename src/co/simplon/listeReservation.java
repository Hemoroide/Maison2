package co.simplon;

import java.util.ArrayList;

public class listeReservation {

	private final static listeReservation INSTANCE = new listeReservation();
	private final ArrayList <Reservation> listeReservation = new ArrayList<>();
	
	private listeReservation(){
	}
	
	public static listeReservation getInstance() {
		return INSTANCE;
	}
	
	public void addReservation(Reservation reservation) throws Exception{
		this.listeReservation.add(reservation);
	}

	public ArrayList <Reservation> getReservation() {
		return listeReservation;
	}
	
}

package co.simplon;

import java.util.HashMap;
import java.util.Map;

public class ReservationManager {
	private final static ReservationManager INSTANCE = new ReservationManager();
	private final Map<String, Reservation> tickets = new HashMap<String, Reservation>();
	
	private ReservationManager(){
	}
	
	public static ReservationManager getInstance() {
		return INSTANCE;
	}
	
	public Map<String, Reservation> getTickets(){
		return tickets;
	}

}

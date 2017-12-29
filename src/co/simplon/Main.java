package co.simplon;

public class Main {
	
	//classe de Test

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GestionBdd dbtest = new GestionBdd();
		
		
		dbtest.Connection();
		
		dbtest.showData("nom", "prenom", "mail", "telephone", "datearive", "nbNuit", "nbPersonne", "nomRegion", true, true ,true);
		
				
	}
}

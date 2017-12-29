package co.simplon;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;

public class GestionBdd {

	private final String BDPATH = "jdbc:mysql://localhost:3306/maisonhote";
	private final String DBUSER = "admin";
	private final String DBPASSWORD = "admin";

	private Connection connection;

	public void Connection() throws Exception {																							// methode de connection a la base de données

		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create the jdbc connection
			connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
			
		}

		catch (Exception e) {
			
			throw e;
		}
	}

	public void InsertData(String nom, String prenom, String mail, String telephone, String dateArrive, String nbNuit,					// methode d'insertion de données
			String nbPersonne, String nomRegion, Boolean parking, Boolean animal, Boolean fumeur) throws SQLException {

		Statement statement = null;

		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `locataire`(`nom`, `prenom`, `mail`,`telephone`,`datearrive`, `nbNuit`,`nbPersonne`, `nomRegion`, `parking`, `animal`, `fumeur` )"
					+ "VALUES ('" + nom + "', '" + prenom + "', '" + mail + "', '" + telephone + "', '" + dateArrive
					+ "', '" + nbNuit + "', '" + nbPersonne + "', '" + nomRegion + "', " + parking + ", " + animal
					+ ", " + fumeur + ")";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("An error occured trying to insert the new data !");
		} finally {
			statement.close();
		}
		System.out.println();
	}

	public ArrayList<Reservation> showData(String nom, String prenom, String mail, String telephone, String dateArrive, String nbNuit,					// methode d'insertion de données
			String nbPersonne, String nomRegion, Boolean parking, Boolean animal, Boolean fumeur) throws SQLException {																							// methode d'affichage de données

		Statement statement = null;
		ResultSet rs = null;
		ArrayList <Reservation> listeReservationBDD = new ArrayList<>();

		try {
			// Create the statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM `locataire`";
			

			// Execute the query
			rs = statement.executeQuery(sql);

			// Loop on the results extracted from the database
			
			while (rs.next()) {
				Reservation reservation = new ReservationImpl();
				reservation.setNom( rs.getString("nom"));
				reservation.setPrenom( rs.getString("prenom"));
				reservation.setMail( rs.getString("mail"));
				reservation.setTelephone( rs.getString("telephone"));
				reservation.setDateArrive( rs.getString("dateArrive"));
				reservation.setNbNuit( rs.getString("nbNuit"));
				reservation.setNbPersonne( rs.getString("nbPersonne"));
				reservation.setNomRegion( rs.getString("nomRegion"));
				reservation.setParking( rs.getBoolean("parking"));
				reservation.setAnimal( rs.getBoolean("animal"));
				reservation.setFumeur( rs.getBoolean("fumeur"));
				
				listeReservationBDD.add(reservation);
				
//				System.out.println("  - Locataire " + rs.getInt("id") + " : " + rs.getString("nom") + ", "
//						+ rs.getString("prenom") + ", " + rs.getString("mail"));
				
			}
									
		} catch (SQLException e) {
			System.out.println("An error occured trying to read the data !");
		} finally {
			statement.close();
		}

		return listeReservationBDD;
		
	}

}

package co.simplon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formulaireDynamic
 */
@WebServlet("/Reservation")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Reservation> listeReservations;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormulaireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("reservation", listeReservation.getInstance().getReservation());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des informations saisies par l'utilisateur

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String telephone = request.getParameter("telephone");
		String dateArrive = request.getParameter("dateArrive");
		String nbNuit = request.getParameter("nbNuit");
		String nbPersonne = request.getParameter("nbPersonne");
		String nomRegion = request.getParameter("nomRegion");
		Boolean parking = request.getParameter("parking") != null;
		Boolean animal = request.getParameter("animal") != null;
		Boolean fumeur = request.getParameter("fumeur") != null;

		// Vérification des informations saisies

		boolean enregistrementOk = true;

		// Tout est en règle => Création du nouveau ticket
		Reservation newReservation = new ReservationImpl();
		newReservation.setNom(nom);
		newReservation.setPrenom(prenom);
		newReservation.setMail(mail);
		newReservation.setTelephone(telephone);
		newReservation.setDateArrive(dateArrive);
		newReservation.setNbNuit(nbNuit);
		newReservation.setNbPersonne(nbPersonne);
		newReservation.setNomRegion(nomRegion);
		newReservation.setParking(parking);
		newReservation.setAnimal(animal);
		newReservation.setFumeur(fumeur);

		// Ajout du ticket à la liste des tickets déjà entrés

		if (enregistrementOk) {
			
			GestionBdd db = new GestionBdd();
			
			try {															// connexion a la base de donnée
				db.Connection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try { 															// insertion des donnés dans bdd
				db.InsertData(nom, prenom, mail, telephone, dateArrive, nbNuit, nbPersonne, nomRegion, parking, animal,
						fumeur);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
			try {
				listeReservations = db.showData(nom, prenom, mail, telephone, dateArrive, nbNuit, nbPersonne, nomRegion, parking, animal,
						fumeur);							// affichage des données depuis la base de données
				request.setAttribute("listeResa", listeReservations);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}														
			

			// L'ajout du locataire s'est bien passé => Affichage de la page de
			// récapitulation
			try {
				listeReservation.getInstance().addReservation(newReservation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("reservation", listeReservation.getInstance().getReservation());
			getServletContext().getRequestDispatcher("/AfficheurReservation.jsp").forward(request, response);

		}
	}
}

/*
 * // CODE "SALE"
 * 
 * String nom = request.getParameter("nom"); request.setAttribute( "nom", nom );
 * String prenom = request.getParameter("prenom"); request.setAttribute(
 * "prenom", prenom ); String mail = request.getParameter("mail");
 * request.setAttribute( "mail", mail ); String telephone =
 * request.getParameter("telephone"); request.setAttribute( "telephone",
 * telephone ); String nbNuit = request.getParameter("nbNuit");
 * request.setAttribute( "nbNuit", nbNuit ); String region =
 * request.getParameter("region"); request.setAttribute( "region", region );
 * 
 * this.getServletContext().getRequestDispatcher( "/formulaire.jsp" ).forward(
 * request, response );
 */

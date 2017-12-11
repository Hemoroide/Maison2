package co.simplon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class formulaireDynamic
 */
@WebServlet("/Reservation")
public class formulaireDynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formulaireDynamic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations saisies par l'utilisateur
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
				
		// Vérification des informations saisies
				
					boolean enregistrementOk = true;
					
					// Tout est en règle => Création du nouveau ticket
					Reservation newReservation = new ReservationImpl();
					newReservation.setNom(nom);
					newReservation.setPrenom(prenom);
					
					
					// Ajout du ticket à la liste des tickets déjà entrés
					/* {
						ReservationManager.getInstance().addTicket(newReservation);
					}
					
					catch (Exception e) {
						// Gestion des exceptions
						enregistrementOk = false;
						request.setAttribute("message", e.getMessage());
						getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
					}
					*/
					if(enregistrementOk)
					{
						// L'ajout du ticket s'est bien passé => Affichage de la page de récapitulation
						request.setAttribute("reservation", newReservation);
						getServletContext().getRequestDispatcher("/formulaire.jsp").forward(request, response);
					}	
				}
			}
		
		
		
/*		
 * 		// CODE "SALE"
 * 
 * 		String nom = request.getParameter("nom");
		request.setAttribute( "nom", nom );
		String prenom = request.getParameter("prenom");
		request.setAttribute( "prenom", prenom );
		String mail = request.getParameter("mail");
		request.setAttribute( "mail", mail );
		String telephone = request.getParameter("telephone");
		request.setAttribute( "telephone", telephone );
		String nbNuit = request.getParameter("nbNuit");
		request.setAttribute( "nbNuit", nbNuit );
		String region = request.getParameter("region");
		request.setAttribute( "region", region );
					
		this.getServletContext().getRequestDispatcher( "/formulaire.jsp" ).forward( request, response ); */
	

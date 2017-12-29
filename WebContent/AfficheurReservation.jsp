<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.Reservation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/materialize.css">
<title>Liste des réservations</title>
</head>

<body>

	<div class="row">
		<div class="col s12">
			<h1 class="center-align">LISTE DES RESERVATIONS</h1>
		</div>

		<table class="bordered striped centered">
			<thead>
				<tr>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>MAIL</th>
					<th>TELEPHONE</th>
					<th>DATE D'ARRIVE</th>
					<th>NOMBRE DE NUIT</th>
					<th>NOMBRE DE PERSONNE</th>
					<th>REGION</th>
					<th>PARKING</th>
					<th>ANIMAL</th>
					<th>FUMEUR</th>
				</tr>
			</thead>

			<%
			  Collection<Reservation> listResa = (Collection<Reservation>) request.getAttribute("listeResa");
				if (listResa != null) {
					Iterator it = listResa.iterator();
					while (it.hasNext()) {
						Reservation serveur = (Reservation) it.next(); 
			%>

			<tbody>
				<tr>
					<td><%=serveur.getNom()%></td>
					<td><%=serveur.getPrenom()%></td>
					<td><%=serveur.getMail()%></td>
					<td><%=serveur.getTelephone()%></td>
					<td><%=serveur.getDateArrive()%></td>
					<td><%=serveur.getNbNuit()%></td>
					<td><%=serveur.getNbPersonne()%></td>
					<td><%=serveur.getNomRegion()%></td>
					<td><%=serveur.parkingCheck()%></td>
					<td><%=serveur.animalCheck()%></td>
					<td><%=serveur.fumeurCheck()%></td>
				</tr>

			</tbody>

			<%
										}
									}
			%>
		</table>

		<div class="col s12 center-align">
			<h4>
				<a href="http://localhost:8080/Maison2/Formulaire.html">RETOUR AU FORMULAIRE</a>
			</h4>
		</div>
	</div>

</body>
</html>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.Reservation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/materialize.css">
<title>Liste des réservations</title>
</head>

<body>
	<% Reservation reservation = (Reservation) request.getAttribute("reservation"); %>
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
							<th>NOMBRE DE NUIT</th>
							<th>REGION</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td><%=reservation.getNom()%></td>
			       			 <td><%=reservation.getPrenom()%></td>
			       			  <td><%=reservation.getMail()%>
			       			 </td>
			       			  <td>
							<% 
			            String telephone = (String) request.getAttribute("telephone");
			            out.println( telephone );
			       			 %>
			       			 </td>
			       			 <td>
							<% 
			            String nbNuit = (String) request.getAttribute("nbNuit");
			            out.println( nbNuit );
			       			 %>
			       			 </td>
			       			 <td>
							<% 
			            String region = (String) request.getAttribute("region");
			            out.println( region );
			       			 %>
			       			 </td>
						</tr>
					</tbody>
				</table>
		<div class="col s12 center-align">
			<h4><a href="http://localhost:8080/Maison2/Formulaire.html">RETOUR AU FORMULAIRE</a></h4>
		</div>
	</div>      
			 
			 
</body>
</html>
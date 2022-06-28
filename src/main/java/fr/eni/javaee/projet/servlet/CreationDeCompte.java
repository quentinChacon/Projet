package fr.eni.javaee.projet.servlet;

import java.io.IOException;
import java.time.LocalDate ;
import java.time.LocalTime ;
import java.time.format.DateTimeFormatter ;
import java.time.format.DateTimeParseException ;
import java.util.Arrays ;

import javax.servlet.RequestDispatcher ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CreationDeCompte
 */
public class CreationDeCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		
		
		
//
//				// lecture utilisateur
//				utilisateur = request.getParameter("noUtilisateur");
//
//				// TODO Controle de surface de la liste d'aliments
//				
//
//				// Appel de la BLL pour ajouter le repas
//				RepasManager repasManager = new RepasManager();
//				repasManager.ajouterRepas(date, heure, Arrays.asList(repas.split(",")));
//				
//				// une autre façon de faire est que le Manager attende un objet Repas dans sa signature méthode
//				// dans ce cas la servlet a la responsabilité d'instancier ce Repas
//
//				
//				
//				// Si tout s'est bien passé, afficher l'historique des repas...
//				RequestDispatcher rd = request.getRequestDispatcher(URL_HISTORIQUE);
//				rd.forward(request, response);
//		
//		
		
		
	}

}

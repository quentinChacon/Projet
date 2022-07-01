package fr.eni.javaee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projet.bll.UtilisateurManager ;


/**
 * Servlet implementation class CreationDeCompte
 */
public class CreationDeCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = null ;
		
		String nom = null ;
		
		String prenom = null;
		
		String email = null ;
		
		String telephone = null ;
		
		String rue = null;
		
		String codePostal = null ;
		
		String ville = null;
		
		String motDePasse = null ; 
		
		int credit = 0 ;
		
		String utilisateur = null ;
		
		utilisateur = request.getParameter("utilisateur");
		
		pseudo = request.getParameter("pseudo");
		
		nom = request.getParameter("nom");
		
		prenom = request.getParameter("prenom");
		
		email = request.getParameter("email");
		
		telephone = request.getParameter("telephone");
		
		rue = request.getParameter("rue");
		
		codePostal = request.getParameter("codepostal");
		
		ville = request.getParameter("ville");
		
		motDePasse = request.getParameter("motdepasse");
		
		request.setCharacterEncoding("UTF-8") ;
		
		//appel de la BLL 
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit);
		
		//Si tt s'est bien passé afficher l'accueil
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		
	}
	
	

}

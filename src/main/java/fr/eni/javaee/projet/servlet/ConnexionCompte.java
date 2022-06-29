package fr.eni.javaee.projet.servlet ;

import java.io.IOException ;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.projet.bll.Manager;
import fr.eni.javaee.projet.bo.Utilisateur;


/**
 * Servlet implementation class ConnexionCompte
 */
// nom de la route /accueil
public class ConnexionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L ;
	
	protected void doGet (HttpServletRequest request , HttpServletResponse response)
			throws ServletException , IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);

	}
	
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	/*
        // Création ou récupération de la session 
        HttpSession session = request.getSession();

        // Mise en session d'une chaîne de caractères 
        String exemple = "abc";
        session.setAttribute( "chaine", exemple );

        // Récupération de l'objet depuis la session 
        String chaine = (String) session.getAttribute( "chaine" );


        Utilisateur connexionTrouvee = Manager.getInstance().rechercherAllUtilisateur();

        // afficher le resultat (les informations du repas)
        System.out.println(connexionTrouvee);

        request.setAttribute("connexionUtilisateur", connexionTrouvee);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
   */
    	
    	
    	// récupération du paramètre HTTP issu du formulaire
    	
    			String choice = request.getParameter("pseudo");
    			String password = request.getParameter("motdepasse");
    			
    			Utilisateur co = new Utilisateur(choice, password);
    			
    			// déposer l'information dans un contexte de partage
    			request.setAttribute("pseudo", co);
    			request.setAttribute("motdepasse", co);
    			System.out.println(co);
    	
    			//SQL
    			//Recuperer les informations SQL du repas qui a l'id 
    			List<Utilisateur> connexion = Manager.getInstance().selectCoUtilisateur("pseudo");
    			
    			verifierConnexion(choice, password);
    			
    			// afficher le resultat 
    			System.out.println(connexion);	
    			request.setAttribute("connexionUtilisateur", connexion);
    			getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
    	
    }
    
    
	private void verifierConnexion(String choice, String password) {
    	
    	List<Utilisateur> connexion = Manager.getInstance().selectCoUtilisateur("pseudo"); ; 
    	
    	for(Utilisateur valeurTrouvee : connexion) {
    		if(choice.equals(valeurTrouvee.getPseudo())&& password.equals(valeurTrouvee.getMotDePasse())) {
    			
    			System.out.println("tu es connectée");
    		}
    		else {
    			System.out.println("l'identifiant ou le mot de passe est faux");
    		}
    		
    	}
    	
    	
    }
    




}

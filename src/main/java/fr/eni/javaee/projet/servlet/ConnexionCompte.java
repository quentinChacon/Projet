package fr.eni.javaee.projet.servlet ;

import java.io.IOException ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
    			
    			Utilisateur  co = new Utilisateur(choice, password);
    			
    			// déposer l'information dans un contexte de partage
    			request.setAttribute("pseudo", co);
    			request.setAttribute("motdepasse", co);
    			System.out.println(co);
    	
    			//SQL
    			//Recuperer les informations SQL du repas qui a l'id 1  
    			Utilisateur connexion = Manager.getInstance().selectCoUtilisateur();
    			
    			// afficher le resultat (les informations du repas)
    			System.out.println(connexion);	
    			request.setAttribute("connexionUtilisateur", connexion);
    			getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
    			
    	
    }
    	
    	
    }
    
    
	
	




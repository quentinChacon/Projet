package fr.eni.javaee.projet.servlet ;

import java.io.IOException ;
import java.util.List;

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

	
    	// récupération du paramètre HTTP issu du formulaire
    	
    			String choice = request.getParameter("pseudo");
    			String password = request.getParameter("motdepasse");
    			Utilisateur session = new Utilisateur(); 
    			
    			Utilisateur co = new Utilisateur(choice, password);
    			
    			// déposer l'information dans un contexte de partage
    			request.setAttribute("pseudo", co);
    			request.setAttribute("motdepasse", co);
    			System.out.println(co);
    	
    			//SQL
    			//Recuperer les informations SQL du repas qui a l'id 
    			List<Utilisateur> listeDesUtilisateurs = Manager.getInstance().selectCoUtilisateur("pseudo");
    			
    			if (verifierConnexion(choice, password)) {
    				request.getSession().setAttribute("id", session );
    				request.getSession().setMaxInactiveInterval(60);
    				
        			getServletContext().getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
    			} else {
    				
        			getServletContext().getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
    			}
    			
    			
    			
    	
    }
    
 
    
	private boolean verifierConnexion(String choice, String password) {
    	
		List<Utilisateur> listeDesUtilisateurs = Manager.getInstance().selectCoUtilisateur("pseudo");
    	
    	for(Utilisateur valeurTrouvee : listeDesUtilisateurs) {
    		if(choice.equals(valeurTrouvee.getPseudo())&& password.equals(valeurTrouvee.getMotDePasse())) {
    			
    			System.out.println("tu es connectée");
    			return true ; 
    		}
    		
    	}
    	System.out.println("tu ne peux pas te connecter");
		return false;
		
		

    	
    	
	}
}
    





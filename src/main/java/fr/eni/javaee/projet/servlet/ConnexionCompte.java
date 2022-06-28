package fr.eni.javaee.projet.servlet ;

import java.io.IOException ;
import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

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


}

package fr.eni.javaee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projet.bll.Manager;
import fr.eni.javaee.projet.bo.Categorie;
import fr.eni.javaee.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		

		//SQL
		//Recuperer les informations SQL du repas qui a l'id 1  
		Utilisateur utilTrouves = Manager.getInstance().rechercherAllUtilisateur();
		
		// afficher le resultat (les informations du repas)
		System.out.println(utilTrouves);	
		
	}

	
}

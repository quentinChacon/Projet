package fr.eni.javaee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.projet.bo.Utilisateur;


/**
 * Servlet implementation class GererSonProfil
 */

public class GererSonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




		Utilisateur utilisateurSession = (Utilisateur) request.getSession().getAttribute("id");
		request.setAttribute("profilutilisateur", utilisateurSession);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
		
	}

	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        
	}

}

package fr.eni.javaee.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.projet.bll.UtilisateurManager;
import fr.eni.javaee.projet.bo.Utilisateur;

public class Suppression extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurManager utilisateurManager = new UtilisateurManager();

		Utilisateur utilisateurConnecte = (Utilisateur) request.getSession().getAttribute("id");
		int numeroUtilisateur = utilisateurConnecte.getNoUtilisateur();

		utilisateurManager.supprimerUtilisateur(numeroUtilisateur);

		getServletContext().getRequestDispatcher("/WEB-INF/jsp/lesobjetssontnosamis.jsp").forward(request, response);
	}

}

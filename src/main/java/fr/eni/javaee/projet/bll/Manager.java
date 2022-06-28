package fr.eni.javaee.projet.bll;

import fr.eni.javaee.projet.bo.Categorie;
import fr.eni.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.jdbc.DAO;

public class Manager {
	
private DAO dao;
	
	//car Singleton
	private static Manager instance;

	//priver car Singleton
	private Manager() {
		dao = new DAO();
	}
	
	//car Singleton
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	
	//select all repas
	public Utilisateur rechercherAllUtilisateur () {
		Utilisateur resultat = null;
		
		resultat = dao.selectAllUtilisateur();
		
		return resultat;
		
		
	}

	


	


}

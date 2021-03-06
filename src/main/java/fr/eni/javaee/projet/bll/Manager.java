package fr.eni.javaee.projet.bll;


import java.util.List;

import fr.eni.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.jdbc.UtilisateurDAOJdbcImpl;


public class Manager {
	
private UtilisateurDAOJdbcImpl dao;
	
	//car Singleton
	private static Manager instance;

	//priver car Singleton
	private Manager() {
		dao = new UtilisateurDAOJdbcImpl();
	}
	
	//car Singleton
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	
	//select infos profil utilisateur
	public Utilisateur rechercherAllUtilisateur () {
		Utilisateur resultat = null;
		
		resultat = dao.selectAllUtilisateur();
		
		return resultat;
		
	}

	//select infos profil utilisateur
	public List<Utilisateur> selectCoUtilisateur (String pConnexionUtilisateur) {
		List<Utilisateur> resultat = null;
		
		resultat = dao.selectCoUtilisateur(pConnexionUtilisateur);
		
		return resultat;
		
	}

	public Utilisateur infosUtilisateur() {
Utilisateur resultat = null;
		
		resultat = dao.selectAllUtilisateur();
		
		return resultat;
	}


	


}

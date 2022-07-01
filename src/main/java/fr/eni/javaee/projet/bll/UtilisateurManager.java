package fr.eni.javaee.projet.bll;

import java.util.List;

import fr.eni.javaee.projet.bo.Utilisateur;
import fr.eni.javaee.projet.dal.jdbc.DAOFactory;
import fr.eni.javaee.projet.dal.jdbc.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO userDAO;

	public UtilisateurManager() {

		this.userDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit) {

		// TODO Vérification des régles métier

		Utilisateur user = null;

		// Construction de la grappe d'objets métiers
		user = new Utilisateur();
		user.setPseudo(pseudo);
		System.out.println(pseudo);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setRue(rue);
		user.setCodePostal(codePostal);
		user.setVille(ville);
		user.setMotDePasse(motDePasse);
		user.setCredit(credit);

		// Appel de la DAL
		this.userDAO.insert(user);

		return user;
	}

	public Utilisateur infosUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville) {

		Utilisateur user = null;

		// Construction de la grappe d'objets métiers
		user = new Utilisateur();
		user.getPseudo();
		user.getNom();
		user.getPrenom();
		user.getEmail();
		user.getTelephone();
		user.getRue();
		user.getCodePostal();
		user.getVille();

		// Appel de la DAL
		this.userDAO.donneesUtilisateur(user);

		return user;

	}

	public static Utilisateur findUtilisateurConnecte(String pseudo, List<Utilisateur> utilisateurs) {

		for (Utilisateur utilCo : utilisateurs) {
			if (pseudo.equals(utilCo.getPseudo())) {
				return utilCo;
			}

		}
		return null;

	}

}

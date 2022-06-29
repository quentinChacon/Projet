package fr.eni.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.projet.bo.Categorie;
import fr.eni.javaee.projet.bo.Utilisateur;

public class DAO {

	// ----------------------------------- SELECT
	// ALL Categorie ------------------------------------
	private static final String SQL_SELECT_ALL_CATEGORIES = "SELECT pseudo, nom, prenom FROM UTILISATEURS";

	private ConnectionProvider provider = new ConnectionProvider();

	public Utilisateur selectAllUtilisateur() {

		// 1. obtenir une connexion
		Connection cnx = provider.getConnexion();

		// 2. Obtenir un objet de commande
		Statement requete = null;
		try {
			requete = cnx.createStatement();

		} catch (SQLException sqle) {
			// TODO traitement d'exception ?

			System.err.println("Probleme pour obtenir le Statement");
			sqle.printStackTrace();
		}

		// 4. Déclencher l'appel à la BdD (BdD = Base de Donnes)
		ResultSet rs = null;
		try {
			rs = requete.executeQuery(SQL_SELECT_ALL_CATEGORIES);

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de l'exécution de la requete.");
			sqle.printStackTrace();
		}

		// 5. Utiliser le resultat de l'appel... (soit un ResultSet, soit le nombre de
		// lignes affectées)
		Utilisateur utilisateurTrouve = null;
		try {
			// Tant qu'il y a des lignes de résultat...
			while (rs.next()) {
				// ... construire le nouvel article à partir desinformations de la ligne...
				// int noCategorie = rs.getInt("no_categorie");
				// String libelle = rs.getString("libelle");

				//utilisateurTrouve = new Utilisateur("elo", "LEQUELLEC", "Eloise");

			}
		} catch (SQLException sqle) {

			System.err.println("Probleme lors de la lecture du resultat de la requete.");
			sqle.printStackTrace();
		}

		return utilisateurTrouve;
	}

	// ----------------------INSERT-------------------------------------

	private static final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)";

	
}


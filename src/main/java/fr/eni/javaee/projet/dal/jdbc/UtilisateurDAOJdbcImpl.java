package fr.eni.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.javaee.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	// ----------------------------------- SELECT
	// ALL Categorie ------------------------------------
	private static final String SQL_SELECT_ALL_UTILISATEUR = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM UTILISATEURS";

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
			rs = requete.executeQuery(SQL_SELECT_ALL_UTILISATEUR);

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de l'exécution de la requete.");
			sqle.printStackTrace();
		}

		// 5. Utiliser le resultat de l'appel... (soit un ResultSet, soit le nombre de
		// lignes affectées)
		Utilisateur utilisateurTrouve = null;

		try {

			String pseudo;

			String nom;

			String prenom;

			String email;

			String telephone;

			String rue;

			String codePostal;

			String ville;

			// Tant qu'il y a des lignes de résultat...
			while (rs.next()) {
				// ... construire le nouvel article à partir desinformations de la ligne...

				pseudo = rs.getString("pseudo");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				email = rs.getString("email");
				telephone = rs.getString("telephone");
				rue = rs.getString("rue");
				codePostal = rs.getString("code_postal");
				ville = rs.getString("ville");

				utilisateurTrouve = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville);

			}

			cnx.close();

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de la lecture du resultat de la requete.");
			sqle.printStackTrace();
		}

		return utilisateurTrouve;
	}

	private static final String SQL_SELECT_CONNEXION_UTILISATEUR = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe FROM UTILISATEURS";

	public List<Utilisateur> selectCoUtilisateur(String pUtilisateur) {

		List<Utilisateur> utilisateurListe = new ArrayList<Utilisateur>();

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
			rs = requete.executeQuery(SQL_SELECT_CONNEXION_UTILISATEUR);

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de l'exécution de la requete.");
			sqle.printStackTrace();
		}

		// 5. Utiliser le resultat de l'appel... (soit un ResultSet, soit le nombre de
		// lignes affectées)

		try {

			int noUtilisateur;
			String pseudo;
			String nom;
			String prenom;
			String email;
			String telephone;
			String rue;
			String codePostal;
			String ville;
			String motDePasse;

			// Tant qu'il y a des lignes de résultat...
			while (rs.next()) {
				// ... construire le nouvel article à partir desinformations de la ligne...

				noUtilisateur = rs.getInt("no_utilisateur");
				pseudo = rs.getString("pseudo");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				email = rs.getString("email");
				telephone = rs.getString("telephone");
				rue = rs.getString("rue");
				codePostal = rs.getString("code_postal");
				ville = rs.getString("ville");
				motDePasse = rs.getString("mot_de_passe");

				utilisateurListe.add(
						new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse));

			}

			cnx.close();

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de la lecture du resultat de la requete.");
			sqle.printStackTrace();
		}

		return utilisateurListe;
	}

	// ----------------------INSERT-------------------------------------

	private static final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * Ajoute un nouvel article en base de données. Si l'insertion se passe bien,
	 * l'identifiant de pNouvelArticle est mis à jour avec la valeur générée par la
	 * base de données.
	 * 
	 * @param pNouvelArticle le nouvel Article.
	 */
	public void insert(Utilisateur pNouvelUtilisateur) {

		System.out.println(pNouvelUtilisateur);
		// s'il n'y a pas de parametre, ca sert a rien de continuer.

		if (pNouvelUtilisateur == null) {
			return;
		}

		// 1. obtenir une connexion

		try (Connection cnx = provider.getConnexion()) {
			try {

				PreparedStatement requete = cnx.prepareStatement(SQL_INSERT_UTILISATEUR,
						PreparedStatement.RETURN_GENERATED_KEYS);

				// PAramétrer le PreparedStatement

				requete.setString(1, pNouvelUtilisateur.getPseudo());
				requete.setString(2, pNouvelUtilisateur.getNom());
				requete.setString(3, pNouvelUtilisateur.getPrenom());
				requete.setString(4, pNouvelUtilisateur.getEmail());
				requete.setString(5, pNouvelUtilisateur.getTelephone());
				requete.setString(6, pNouvelUtilisateur.getRue());
				requete.setString(7, pNouvelUtilisateur.getCodePostal());
				requete.setString(8, pNouvelUtilisateur.getVille());
				requete.setString(9, pNouvelUtilisateur.getMotDePasse());
				requete.setInt(10, pNouvelUtilisateur.getCredit());
				requete.setBoolean(11, false);

				// Executer la requete
				requete.executeUpdate();

				// Récupération de la clef générée

				ResultSet clef = requete.getGeneratedKeys();
				if (clef.next()) {

					// Mise à jour de l'article passé en paramètre
					pNouvelUtilisateur.setNoUtilisateur(clef.getInt(1));
				}

				clef.close();
				requete.close();

				// Libérer les ressources : fermer la connexion.
				cnx.close();

			} catch (Exception sqle) {
				// journaliser (pour faciliter le travail des exploitant

				sqle.printStackTrace();

				// Il y a un probleme ==> Transaction annulée

				cnx.rollback();
			}

		}

		catch (Exception sqle) {
			sqle.printStackTrace();
		}

	}

//  --------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static final String SQL_SELECT_UTILISATEUR = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM UTILISATEURS WHERE no_utilisateur = ? ";

	private ConnectionProvider providerConnexion = new ConnectionProvider();

	public Utilisateur donneesUtilisateur(Utilisateur pUtilisateurConnecte) {

		// 1. obtenir une connexion
		Connection cnx = providerConnexion.getConnexion();

		// 2. Obtenir un objet de commande
		PreparedStatement requete = null;
		try {
			requete = cnx.prepareStatement(SQL_SELECT_UTILISATEUR);

			requete.setInt(1, pUtilisateurConnecte.getNoUtilisateur());

		} catch (SQLException sqle) {
			// TODO traitement d'exception ?

			System.err.println("Probleme pour obtenir le Statement");
			sqle.printStackTrace();
		}

		// 4. Déclencher l'appel à la BdD (BdD = Base de Donnes)
		ResultSet rs = null;
		try {

			rs = requete.executeQuery();

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de l'exécution de la requete.");
			sqle.printStackTrace();
		}

		// 5. Utiliser le resultat de l'appel... (soit un ResultSet, soit le nombre de
		// lignes affectées)
		Utilisateur utilisateurConnecte = null;

		try {

			String pseudo;

			String nom;

			String prenom;

			String email;

			String telephone;

			String rue;

			String codePostal;

			String ville;

			// Tant qu'il y a des lignes de résultat...
			while (rs.next()) {
				// ... construire le nouvel article à partir desinformations de la ligne...

				pseudo = rs.getString("pseudo");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				email = rs.getString("email");
				telephone = rs.getString("telephone");
				rue = rs.getString("rue");
				codePostal = rs.getString("code_postal");
				ville = rs.getString("ville");

				utilisateurConnecte = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville);

			}

			cnx.close();

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de la lecture du resultat de la requete.");
			sqle.printStackTrace();
		}

		return utilisateurConnecte;

	}
	
	

//  --------------------------------------------------------------------------------------------------------------------------------------------------------------

	private static final String SQL_DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ? ";

	private ConnectionProvider providerCo = new ConnectionProvider();

	public void delete(int numeroUtilisateur) {

		// 1. obtenir une connexion
		Connection cnx = providerCo.getConnexion();

		// 2. Obtenir un objet de commande
		PreparedStatement requete = null;
		try {
			requete = cnx.prepareStatement(SQL_DELETE_UTILISATEUR);

			requete.setInt(1, numeroUtilisateur);

		} catch (SQLException sqle) {
			// TODO traitement d'exception ?

			System.err.println("Probleme pour obtenir le Statement");
			sqle.printStackTrace();
		}

		// 4. Déclencher l'appel à la BdD (BdD = Base de Donnes)
		try {

			requete.executeUpdate();

		} catch (SQLException sqle) {

			System.err.println("Probleme lors de l'exécution de la requete.");
			sqle.printStackTrace();
		}

			try {
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

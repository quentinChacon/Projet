package fr.eni.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.projet.bo.Utilisateur;

public class DAO {

    // ----------------------------------- SELECT
    // ALL Categorie ------------------------------------
    private static final String SQL_SELECT_ALL_UTILISATEUR = "SELECT pseudo, nom, prenom FROM UTILISATEURS";

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
            // Tant qu'il y a des lignes de résultat...
            while (rs.next()) {
                // ... construire le nouvel article à partir desinformations de la ligne...
                // int noCategorie = rs.getInt("no_categorie");
                // String libelle = rs.getString("libelle");

                utilisateurTrouve = new Utilisateur("elo", "LEQUELLEC", "Eloise");

            }
        } catch (SQLException sqle) {

            System.err.println("Probleme lors de la lecture du resultat de la requete.");
            sqle.printStackTrace();
        }

        return utilisateurTrouve;
    }





	// ----------------------INSERT-------------------------------------

	private static final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)";

	/**
	 * Ajoute un nouvel article en base de données. Si l'insertion se passe bien,
	 * l'identifiant de pNouvelArticle est mis à jour avec la valeur générée par la
	 * base de données.
	 * 
	 * @param pNouvelArticle le nouvel Article.
	 */
	public void insert(Utilisateur pNouvelUtilisateur) throws DALException {
		


			// 1. obtenir une connexion
			Connection cnx = provider.getConnexion();

		try {
			PreparedStatement requete = cnx.prepareStatement(SQL_INSERT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);

			// PAramétrer le PreparedStatement
			requete.setInt(1, pNouvelUtilisateur.getNoUtilisateur());
			requete.setString(1, pNouvelUtilisateur.getPseudo());
			requete.setString(1, pNouvelUtilisateur.getNom());
			requete.setString(1, pNouvelUtilisateur.getPrenom());
			requete.setString(1, pNouvelUtilisateur.getEmail());
			requete.setString(1, pNouvelUtilisateur.getTelephone());
			requete.setString(1, pNouvelUtilisateur.getRue());
			requete.setString(1, pNouvelUtilisateur.getCodePostal());
			requete.setString(1, pNouvelUtilisateur.getVille());
			requete.setString(1, pNouvelUtilisateur.getMotDePasse());
			requete.setInt(1, pNouvelUtilisateur.getCredit());
			requete.setByte(1, pNouvelUtilisateur.getAdministrateur());

			
			Utilisateur nouvelUtilisateur = null;

			if (pNouvelUtilisateur instanceof Utilisateur) {
				nouvelUtilisateur = (Utilisateur) pNouvelUtilisateur;
				
			} else {
				// TODO Gérer le cas d'erreur
			}

			// Executer la requete
			int nbLignesAffectees = requete.executeUpdate();

			// Récupération de la clef générée
			if (nbLignesAffectees == 1) {
				ResultSet clef = requete.getGeneratedKeys();
				clef.next(); // Pas besoin de tester car nous savons qu'il y a une ligne ( nbLignesAffectees
								// == 1)

				// Mise à jour de l'article passé en paramètre
				pNouvelUtilisateur.setNoUtilisateur(1); // "1" : indice de la 1ere colonne (dont je n'ai pas le
																// nom)
			}

			System.out.println(nbLignesAffectees + " lignes ont été insérées.");

			// Libérer les ressources : fermer la connexion.
			cnx.close();

		} catch (SQLException sqle) {
			// journaliser (pour faciliter le travail des exploitant
			System.err.println("Probleme pour insérer un nouvel article");
			sqle.printStackTrace();

			// envelopper l'exception JDBC dans une exception de la DAL
			throw new DALException("Impossible d'inserer l'article (article : " + pNouvelUtilisateur + ")", sqle);
		}
	}

	 Connection getConnection() {
		String urlConnexion = "jdbc:sqlserver://10.103.200.3;databaseName=ENCHERES" ; // parametres
																																		// pour
																																		// souhaitée
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection(urlConnexion);
		} catch (SQLException sqle) {

			// TODO traitement d'exception ?

			System.err.println("Probleme pour obtenir une connexion");
			sqle.printStackTrace();
		}
		return cnx;
	}
	


}

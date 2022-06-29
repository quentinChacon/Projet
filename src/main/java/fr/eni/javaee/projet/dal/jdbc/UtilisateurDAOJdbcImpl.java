package fr.eni.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl 
// implements UtilisateurDAO
{
	

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
        	
        	
        	 String pseudo ; 
        	
        	 String nom ;
        	
        	 String prenom;
        	
        	 String email ;
        	
        	 String telephone ;
        	
        	 String rue ;
        	
        	 String codePostal ;
        	
        	 String ville ;
        	
        	
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

            	
            	utilisateurTrouve = new Utilisateur( pseudo, nom, prenom, email, telephone, rue, codePostal, ville) ;

            }
            
            cnx.close();
            
        } catch (SQLException sqle) {

            System.err.println("Probleme lors de la lecture du resultat de la requete.");
            sqle.printStackTrace();
        }

        return utilisateurTrouve;
    }
    
    
    

    // ----------------------INSERT-------------------------------------

    private static final String SQL_INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)";

    
}
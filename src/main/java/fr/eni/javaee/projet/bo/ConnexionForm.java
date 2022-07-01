package fr.eni.javaee.projet.bo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ConnexionForm {
	
	private static String CHAMP_PSEUDO = "pseudo" ;
	private static String CHAMP_PASSWORD = "motDePasse" ;
	
	private String resultat ; 
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public String getResultat() {
		return resultat;
	}
	
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    /*
    public Utilisateur connecterUtilisateur(HttpServletRequest request) {
    	
    	// Récupération des champs du formulaire
    	
    	String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
    	String password = getValeurChamp(request, CHAMP_PASSWORD);
    	
    	Utilisateur utilisateur
    	
		return utilisateurPourConnexion;
    	
    	
    }
    
    */
	   
}

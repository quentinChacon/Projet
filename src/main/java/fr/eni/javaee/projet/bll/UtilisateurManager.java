package fr.eni.javaee.projet.bll;

import java.util.regex.Matcher ;
import java.util.regex.Pattern ;

import fr.eni.javaee.projet.bo.Utilisateur ;
import fr.eni.javaee.projet.dal.jdbc.DAOFactory ;
import fr.eni.javaee.projet.dal.jdbc.UtilisateurDAO ;


public class UtilisateurManager {
	
	private UtilisateurDAO userDAO ;
	
	public UtilisateurManager () {
	
	this.userDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur( String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit) {

		// TODO Vérification des régles métier
		
		Utilisateur user = null;

		// Construction de la grappe d'objets métiers		
		user = new Utilisateur();
		user.setPseudo(pseudo);
		System.out.println(pseudo) ;
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
	

	public static class PasswordValidator {

	    // digit + lowercase char + uppercase char + punctuation + symbol
	    private static final String PASSWORD_PATTERN =
	            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

	    
	    
	    public static boolean isValid(final String password) {
	        Matcher matcher = pattern.matcher(password);
	        return matcher.matches();
	    }

	}
	
	
	
	
}
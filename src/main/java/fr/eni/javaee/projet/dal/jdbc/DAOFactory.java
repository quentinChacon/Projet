package fr.eni.javaee.projet.dal.jdbc;



public abstract class DAOFactory {

	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return  new UtilisateurDAOJdbcImpl();
	}
	
	
	
}

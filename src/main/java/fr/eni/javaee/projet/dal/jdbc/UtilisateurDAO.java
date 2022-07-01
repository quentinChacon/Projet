package fr.eni.javaee.projet.dal.jdbc;

import fr.eni.javaee.projet.bo.Utilisateur ;


public interface UtilisateurDAO {

	public void insert(Utilisateur user);
	public Utilisateur donneesUtilisateur(Utilisateur user);
	public void delete(int numeroUtilisateur);
	
	
}

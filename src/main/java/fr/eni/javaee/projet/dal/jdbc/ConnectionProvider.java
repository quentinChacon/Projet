package fr.eni.javaee.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

		
		private DataSource pool; //correspond a la variable "dataSource" sur la diapo 9 du module 4
			
			public ConnectionProvider() {
				pool = obtenirPool();
			}
			
			
			
			private DataSource obtenirPool() {
				DataSource poolDeConnexions = null;
				
				//1- Obtenir l'annuaire
				InitialContext annuaire = null;
				try {
					annuaire = new InitialContext();
					
				} catch (NamingException ne) {
					ne.printStackTrace();
					System.err.println("Probleme pour obtenir l'annuaire");
				} 
						
				//2- Obtenir le pool de connexion en cherchant le composant dans l'annuaire
				String repertoireAnnuaire = "java:/comp/env/";
				String nomPool = "poolEncheres";
				
				
				try {
					poolDeConnexions = (DataSource) annuaire.lookup(repertoireAnnuaire + nomPool);
					
				} catch (NamingException ne) {
					ne.printStackTrace();
					System.err.println("Probleme pour obtenir le pool de connexion");
				}
				
				
				return poolDeConnexions;
			}



			/**
			 * 
			 * @return une connexion a la base de donné
			 */
			public Connection getConnexion() {
				
				Connection cnx  = null;
				
				
						
						//3- demander une connexion au pool
					
						try {
							cnx = pool.getConnection();
						} catch (SQLException sqle) {
							sqle.printStackTrace();
							System.err.println("Probleme pour obtenir une connexion");
						}
				
						return cnx;
			}
		}
	


package fr.eni.javaee.projet.dal.jdbc;

public class DALException extends Exception {

	public DALException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	// Constructeurs
	public DALException() {
		super();
	}

	public DALException(String message) {
		super(message);
	}

	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	// Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());

		return sb.toString();
	}

}

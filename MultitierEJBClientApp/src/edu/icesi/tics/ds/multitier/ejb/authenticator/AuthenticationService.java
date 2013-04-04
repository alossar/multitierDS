package edu.icesi.tics.ds.multitier.ejb.authenticator;

public interface AuthenticationService {	
	
	public boolean authenticate (String login, String password);	
	
}

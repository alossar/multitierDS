package edu.icesi.tics.dsmultitier.web;

import javax.ejb.EJB;

import edu.icesi.tics.ds.multitier.ejb.authenticator.AuthenticationService;



public class AuthenticatorController {

	
	
	
	private String login;
	private String password;
	
	@EJB(mappedName = "AuthenticatorServiceImpl")
	private  AuthenticationService authenticationService;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	
	
	//public String authenticate(){
//		return simpleAuthenticate();
		
	//}
	
	
	public String ejbAuthenticate(){
	return authenticationService.authenticate(login, password) ? "welcome":"failed"	;
	}
	
	
	private String simpleAuthenticate(){
		if("admin".equals(login)&&"password".equals(password)){
			return "welcome";
		}else{
			return "failed";
		}
		
		
	}

	
	
}

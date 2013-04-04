package edu.icesi.tics.ds.multitier.ejb.bo;

import java.io.Serializable;

public class UserAccountBO implements Serializable {
	private long id;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public UserAccountBO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package co.edu.icesi.ds.tics.multtier.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserAccount
 *
 */
@Entity
@Table(name="UserAccount", uniqueConstraints=@UniqueConstraint (columnNames = { "login" }))
@NamedQuery(name="UserAccount.findUserAccountBylogin", query="SELECT u FROM UserAccount u WHERE u.login =:login")

public class UserAccount implements Serializable {

	   
	@Id
	private long id;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public UserAccount() {
		super();
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
	public boolean authenticate(String password2) {
		
		
		return password.equals(password2);
		
	}
}

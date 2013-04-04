package edu.icesi.tics.ds.multitier.ejb.authenticator;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.ds.tics.multitier.model.UserAccount;

/**
 * Session Bean implementation class AuthenticatorSessionBean
 */
@Stateless (mappedName= "AuthenticatorServiceImpl")
public class AuthenticatorSessionBean implements AuthenticatorSessionBeanRemote, AuthenticatorSessionBeanLocal {

	@PersistenceContext(unitName =  "MulttierJPAApp")
	private EntityManager entityManager;
	
	
    /**
     * Default constructor. 
     */
    public AuthenticatorSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean authenticate(String login, String password) {
			Query query = entityManager.createNamedQuery("UserAccount.findUserAccountBylogin");
			query.setParameter ("login", login);
			try{
				UserAccount userAccount = (UserAccount) query.getSingleResult();
				return userAccount.authenticate(password);
			}catch (Exception e){
				return false;
			}
	}

}

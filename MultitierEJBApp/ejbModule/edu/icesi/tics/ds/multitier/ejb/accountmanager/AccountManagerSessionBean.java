package edu.icesi.tics.ds.multitier.ejb.accountmanager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.icesi.ds.tics.multitier.model.UserAccount;
import edu.icesi.tics.ds.multitier.ejb.bo.UserAccountBO;

/**
 * Session Bean implementation class AccountManagerSessionBean
 */
@Stateless(mappedName = "AccountManagerServiceImpl")
public class AccountManagerSessionBean implements
		AccountManagerSessionBeanRemote, AccountManagerSessionBeanLocal {

	@PersistenceContext(unitName = "MulttierJPAApp")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AccountManagerSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean crearCuenta(UserAccountBO userAccountBO) {

		UserAccount entidad = em.find(UserAccount.class, userAccountBO.getId());
		if (entidad == null) {
			entidad = new UserAccount();
		} else {
			return false;
		}

		try {
			entidad.setId(userAccountBO.getId());
			entidad.setLogin(userAccountBO.getLogin());
			entidad.setPassword(userAccountBO.getPassword());
			em.persist(entidad);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<UserAccountBO> listarUsuariosCuenta() {
		String query = "SELECT c FROM UserAccount c";
		Query q = em.createQuery(query);
		List<UserAccountBO> usuariosBO = new ArrayList<UserAccountBO>();
		List<UserAccount> usuarios = q.getResultList();
		if (usuarios != null) {
			for (UserAccount userAccount : usuarios) {
				UserAccountBO ax = new UserAccountBO();
				ax.setId(userAccount.getId());
				ax.setLogin(userAccount.getLogin());
				usuariosBO.add(ax);
			}
		}
		return usuariosBO;
	}

	@Override
	public boolean actualizarCuenta(UserAccountBO userAccountBO) {
		UserAccount entidad = em.find(UserAccount.class, userAccountBO.getId());
		if (entidad == null) {
			return false;
		}

		try {
			entidad.setLogin(userAccountBO.getLogin());
			entidad.setPassword(userAccountBO.getPassword());
			em.merge(entidad);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminarCuenta(UserAccountBO userAccountBO) {
		UserAccount entidad = em.find(UserAccount.class, userAccountBO.getId());
		if (entidad == null) {
			return false;
		}
		try {
			em.remove(entidad);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

package edu.icesi.tics.ds.multitier.ejb.accountmanager;

import java.util.List;

import edu.icesi.tics.ds.multitier.ejb.bo.UserAccountBO;

public interface AccountManagerService {

	public boolean crearCuenta(UserAccountBO userAccountBO);
	public List<UserAccountBO> listarUsuariosCuenta();
	public boolean actualizarCuenta(UserAccountBO userAccountBO);
	public boolean eliminarCuenta(UserAccountBO userAccountBO);

}

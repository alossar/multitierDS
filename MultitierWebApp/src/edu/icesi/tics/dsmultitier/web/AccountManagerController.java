package edu.icesi.tics.dsmultitier.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIForm;
import javax.faces.component.html.HtmlDataTable;

import com.sun.security.auth.UserPrincipal;

import edu.icesi.tics.ds.multitier.ejb.accountmanager.AccountManagerService;
import edu.icesi.tics.ds.multitier.ejb.bo.UserAccountBO;

public class AccountManagerController {
	private List<UserAccountBO> users;
	private UserAccountBO user;
	private UserAccountBO editUser;
	// JavaServerFaces related variables
	private UIForm tableForm;
	private HtmlDataTable dataTable;
	private String editPassword1;
	private String editPassword2;
	private String password1;
	private String password2;
	private String login;
	private int id;

	@EJB(mappedName = "AccountManagerServiceImpl")
	private AccountManagerService accountManagerService;

	@PostConstruct
	public void init() {
		users = accountManagerService.listarUsuariosCuenta();
	}

	public UIForm getTableForm() {
		return tableForm;
	}

	public void setTableForm(UIForm tableForm) {
		this.tableForm = tableForm;
	}

	public List<UserAccountBO> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccountBO> users) {
		this.users = users;
	}

	public UserAccountBO getUser() {
		return user;
	}

	public void setUser(UserAccountBO user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String ejbUserAccountsList() {
		users = accountManagerService.listarUsuariosCuenta();
		user = new UserAccountBO();
		return "list";
	}

	public String addAccount() {
		if (password1.equals(password2)) {
			UserAccountBO userAccountBO = new UserAccountBO();
			userAccountBO.setLogin(login);
			userAccountBO.setPassword(password1);
			userAccountBO.setId(id);
			accountManagerService.crearCuenta(userAccountBO);
			init();
		}
		return null;
	}

	public String deleteAccount() {
		user = (UserAccountBO) dataTable.getRowData();
		accountManagerService.eliminarCuenta(user);
		init();
		return null;
	}

	public String changePasswordAccount() {
		editUser = (UserAccountBO) dataTable.getRowData();
		return "change";
	}

	public String editAccount() {
		if (editPassword1.equals(editPassword2)) {
			editUser.setPassword(editPassword1);
			accountManagerService.actualizarCuenta(editUser);
			return null;
		} else {
			return null;
		}
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String getEditPassword1() {
		return editPassword1;
	}

	public void setEditPassword1(String editPassword1) {
		this.editPassword1 = editPassword1;
	}

	public String getEditPassword2() {
		return editPassword2;
	}

	public void setEditPassword2(String editPassword2) {
		this.editPassword2 = editPassword2;
	}

	public UserAccountBO getEditUser() {
		return editUser;
	}

	public void setEditUser(UserAccountBO editUser) {
		this.editUser = editUser;
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Accounts</title>
</head>
<body>
	<f:view>
		<h1>User Accounts</h1>
		<%-- Here we start the form for the data table --%>
		<h:form binding="#{accountManagerController.tableForm}">
			<%-- Here we start the data table --%>

			<h:dataTable binding="#{accountManagerController.dataTable}"
				value="#{accountManagerController.users}" var="user">
				
				<h:column>
					<h:outputText value="#{user.login}"></h:outputText>
				</h:column>
				<h:column>
					<h:commandButton value="Change Password"
						action="#{accountManagerController.changePasswordAccount}" />
				</h:column>
				<h:column>
					<h:commandButton value="Delete"
						action="#{accountManagerController.deleteAccount}" />
				</h:column>

			</h:dataTable>
		</h:form>

		<h3>Add Account</h3>

		<h:form>
			<table>
				
				<tr>
					<td>Login :</td>
					<td><h:inputText size="20"
							value="#{accountManagerController.login}" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><h:inputSecret size="20"
							value="#{accountManagerController.password1}" /></td>
				</tr>
<tr>
					<td>Retype Password :</td>
					<td><h:inputSecret size="20"
							value="#{accountManagerController.password2}" /></td>
				</tr>
			</table>

			<h:commandButton value="Add"
				action="#{accountManagerController.addAccount}" />

		</h:form>
	</f:view>

</body>
</html>
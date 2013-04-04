<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body>
	<f:view>
		<h3>Add Account</h3>

		<h:form>
			<table>
				
				<tr>
					<td>Password :</td>
					<td><h:inputSecret size="20"
							value="#{accountManagerController.editPassword1}" /></td>
				</tr>
				<tr>
					<td>Retype Password :</td>
					<td><h:inputSecret size="20"
							value="#{accountManagerController.editPassword2}" /></td>
				</tr>

			</table>

			<h:commandButton value="Add"
				action="#{accountManagerController.editAccount}" />

		</h:form>
	</f:view>
</body>
</html>
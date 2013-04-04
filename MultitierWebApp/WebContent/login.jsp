<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:view>
		<h:form>
			<h:panelGrid border="1" columns="2"
				style="width: 402px; height: 100px">
				<h:outputText value="Login:"></h:outputText>
				<h:inputText value="#{authenticatorController.login}">
				</h:inputText>
				<h:outputText value="Password:"></h:outputText>
				<h:inputSecret value="#{authenticatorController.password}"></h:inputSecret>
				<h:commandButton value="Sign In"
					action="#{authenticatorController.ejbAuthenticate}"></h:commandButton>
				<h:commandButton value="Listar Usuarios"
					action="#{accountManagerController.ejbUserAccountsList}"></h:commandButton>
			</h:panelGrid>
		</h:form>


	</f:view>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rustico</title>
</head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<style>
h2{
	text-align: center;
	color: red;
}
</style>
<body>
	<form:form method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/verificarusuario">
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Restaurante<span>Rústico</span></div>
		</div>
		<br>
		<div class="login">
		
				<form:input type="text" path="usuario" placeholder="usuario" name="usuario"/>
				<form:errors path="usuario" cssStyle="color:#FF0000;"></form:errors><br>
				
				<form:input type="password" path="contraseña" placeholder="contraseña" name="contraseña"/>
				<form:errors path="contraseña" cssStyle="color:#FF0000;"></form:errors><br>
				
				<input type="submit" value="Login">
		</div>
	</form:form>
	
	<c:if test = "${resultado eq 0}">
		<h2>No se encontró el usuario</h2>
	</c:if>
</body>
</html>
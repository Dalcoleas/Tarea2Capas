<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucursales</title>
</head>
<style>
.content {
	margin: auto;
	text-align: center
}

th, td {
	padding: 10px
}

button{
	margin: 5px
}


</style>
<body>
	<div class="content">
		<h2>Todas las Sucursales</h2>
			<table align="center">
				<tr>
					<th>Sucursal</th>
					<th>Acciones</th>
				</tr>
				<c:forEach items="${sucursales}" var="s">
					<tr>
						<td>${s.nSucursal}</td>
						<td><button type="button" value="Ver" onclick="location.href='${pageContext.request.contextPath}/perfilSucursal?cSucursal=${s.cSucursal}'">Perfil</button><button type="button">Eliminar</button></td>
					</tr>
				</c:forEach>
			</table>
	</div>
</body>
</html>
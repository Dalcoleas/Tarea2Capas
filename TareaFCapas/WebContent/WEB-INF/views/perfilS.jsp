<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil Sucursal</title>
</head>
<style>
.content {
	margin: auto;
	text-align: center
}

th, td {
	padding: 10px
}
</style>
<body>
	<div class="content">
	<h2>Perfil de ${sucursal.nSucursal}</h2>
		<table align="center">
			<tr>
				<th>Nombre Sucursal</th>
				<th>Nombre Gerente</th>
				<th>Cantidad de Mesas</th>
				<th>Ubicación</th>
				<th>Horario Apertura</th>
				<th>Horario Cierre</th>
				<th>Acción</th>
			</tr>
			<tr>
				<td>${sucursal.nSucursal}</td>
				<td>${sucursal.nGerente}</td>
				<td>${sucursal.nMesas}</td>
				<td>${sucursal.uSucursal}</td>
				<td>${sucursal.hApertura}</td>
				<td>${sucursal.hCierre}</td>
				<td><button type="button">Editar</button></td>
			</tr>
		</table>
	<h2>Empleados</h2>
		<table align="center">
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Genero</th>
				<th>Estado</th>
			</tr>
			<c:forEach items="${empleados}" var="e">
				<tr>
					<td>${e.nombre}</td>
					<td>${e.edad}</td>
					<td>${e.genero}</td>
					<td>${e.activoDelegate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
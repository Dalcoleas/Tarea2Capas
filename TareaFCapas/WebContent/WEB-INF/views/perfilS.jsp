<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil Sucursal</title>
<link href="https://fonts.googleapis.com/css?family=Exo&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<style>
.content {
	margin: auto;
	text-align: center
}

th, td {
	padding: 10px
}

th{
	color : white;
}

body {
	margin: auto;
	padding: 10px;
	text-align: center;
	background: #4CAF50;
	font-weight: bold;
	font-family: 'Exo', sans-serif;
	font-size: 20px;
}

.table th, .table td{
	padding: 10px;
	border: 5px solid black;
	
}

span{
	color:white;
}


</style>
<body>
	<div class="content">
	<h2>Perfil de <span >${sucursal.nSucursal}</span></h2>
		<table align="center" class="table table-bordered">
			<tr>
				<th>Nombre Sucursal</th>
				<th>Nombre Gerente</th>
				<th>Cantidad de Mesas</th>
				<th>Ubicación</th>
				<th>Horario Apertura</th>
				<th>Horario Cierre</th>
			</tr>
			<tr>
				<td>${sucursal.nSucursal}</td>
				<td>${sucursal.nGerente}</td>
				<td>${sucursal.nMesas}</td>
				<td>${sucursal.uSucursal}</td>
				<td>${sucursal.hApertura}</td>
				<td>${sucursal.hCierre}</td>
			</tr>
		</table>
	<h2>Perfil Empleados <span>${sucursal.nSucursal}</span></h2>
		<table class="table table-bordered" align="center">
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Genero</th>
				<th>Estado</th>
				<th>Editar</th>
				<th>Eliminar</th>
			</tr>
			<c:forEach items="${empleados}" var="e">
				<tr>
					<td>${e.nombre}</td>
					<td>${e.edad}</td>
					<td>${e.genero}</td>
					<td>${e.activoDelegate}</td>
					<td><button class="btn btn-dark" type="button" onclick="location.href='${pageContext.request.contextPath}/editarEmpleado?cSucursal=${sucursal.cSucursal}&cEmpleado=${e.cEmpleado}'">Editar</button></td>
					<td><button class="btn btn-dark" type="button" onclick="location.href='${pageContext.request.contextPath}/borrarEmpleado?cEmpleado=${e.cEmpleado}&cSucursal=${sucursal.cSucursal}'">Eliminar</button></td>
				</tr>
			</c:forEach>
		</table>		
		<form name ="addEmpleado" action="${pageContext.request.contextPath}/agregarEmpleado" method="post">
			<input type="hidden" name ="sucursalID" value="${sucursal.cSucursal}">
			<button class="btn btn-dark" type="submit">Agregar Empleado</button>
		</form>
	</div>
</body>
</html>
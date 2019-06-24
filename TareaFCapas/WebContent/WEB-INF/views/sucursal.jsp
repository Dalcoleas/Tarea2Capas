<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucursales</title>
<link href="https://fonts.googleapis.com/css?family=Exo&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<style>
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

th{
	color : white;
}


button{
	margin: 5px
}

</style>
<body>
	<c:set var="count" value="0" scope="page" />
	<div class="content">
		<h2>Todas las Sucursales</h2>
			<table class="table table-bordered" align="center">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th>Sucursal</th>
					<th>Perfil</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
				<c:forEach items="${sucursales}" var="s">
				<c:set var="count" value="${count + 1}"/>
				<tbody>
					<tr>
						<th scope="row">${count}</th>
						<td>${s.nSucursal}</td>
						<td><button type="button" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/perfilSucursal?cSucursal=${s.cSucursal}'">Perfil</button></td>
												<td><button type="button" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/editarSucursal?cSucursal=${s.cSucursal}'">Editar</button></td>
						<td><button type="button" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/eliminarSucursal?cSucursal=${s.cSucursal}'">Eliminar</button></td>
					</tr>
				</tbody>
				</c:forEach>
			</table>
	</div>
	<button type="button"  class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/addSucursal'">Agregar Sucursal</button>
</body>
</html>
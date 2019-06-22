<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucursal</title>
</head>
<link rel="stylesheet" type="text/css" href="resources/css/style_new_suc.css">
<body>
	<div class="container">   
  	<form:form id="contact" method="post" modelAttribute="sucursal" action="${pageContext.request.contextPath}/savesucursal">
  	<form:input type="hidden" id="csucursal" path="cSucursal" />
    <h3>Información Sucursal</h3>
    <fieldset>
      <form:input placeholder="Nombre Sucursal" id="nombresuc" path="nSucursal" type="text" />
      <form:errors path="nSucursal" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <form:input placeholder="Nombre Gerente" id="nombreger" path="nGerente" type="text"  />
      <form:errors path="nGerente" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <form:input placeholder="Número de mesas" id="numemesas" path="nMesas" type="text" />
      <form:errors path="nMesas" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <form:input placeholder="Ubicación" id="ubicacion" path="uSucursal" type="text"  />
      <form:errors path="uSucursal" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <form:input placeholder="Horario Apertura" id="horaper" path="hApertura" type = "text" />
      <form:errors path="hApertura" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
     <fieldset>
      <form:input placeholder="Horario Cierre" id="horcierre" path="hCierre" type = "text" />
      <form:errors path="hCierre" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Guardando">Guardar</button>
    </fieldset>
  </form:form>
</div>
</body>
</html>
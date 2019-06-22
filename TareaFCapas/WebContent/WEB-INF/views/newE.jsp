<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado</title>
</head>
<link rel="stylesheet" type="text/css" href="resources/css/style_new_suc.css">
<body>

	
	<div class="container">   
  	<form:form id="contact" method="post" modelAttribute="empleado" action="${pageContext.request.contextPath}/saveempleado">
  	<form:input id="idEmpleado" type="hidden" path="cEmpleado"/>
    <h3>Información Empleado</h3>
    <fieldset>
      <form:input placeholder="Nombre Empleado" id="nombreemp" path="nEmpleado" type="text" />
      <form:errors path="nEmpleado" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
    <fieldset>
      <form:select id="genero" path="gEmpleado">
      	<form:option value="Masculino" selected="true" >Masculino</form:option>
      	<form:option value="Femenino">Femenino</form:option>
      </form:select>
    </fieldset>
    <fieldset>
      <form:input placeholder="Edad" id="edad" path="eEmpleado" type="text"  />
      <form:errors path="eEmpleado" cssStyle="color:#FF0000;"></form:errors><br>
    </fieldset>
     <fieldset>
      <form:select id="estado" path="eActivo">
      	<form:option value="true" selected="true">Activo</form:option>
      	<form:option value="false">Inactivo</form:option>
      </form:select>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Guardando">Guardar</button>
    </fieldset>
    <input type="hidden" name="cSucursal" value="${sucursal.cSucursal}"/>
     <c:if test = "${resultado eq 0}">
		<h2>Favor regresar a pantalla anterior para agregar nuevo empleado.</h2>
	</c:if>
  </form:form> 
</div>
</body>
</html>
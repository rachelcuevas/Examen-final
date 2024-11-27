<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Poema</title>
<link rel="stylesheet" href="/css/agregarPoema.css"/>
</head>
<body>

<h1>Agregar Poema</h1>

<ul id="nav">
    <li><a href="/poemas">Todos los poemas</a></li>
    <li><a href="/form/agregar">Agregar Poema</a></li>
    <li><a href="/logout">Logout</a></li>
</ul>

<form:form action="${pageContext.request.contextPath}/guardar" method="POST" modelAttribute="poema">
    <form:label path="titulo">Título:</form:label>
    <form:input path="titulo" type="text" />
    <form:errors path="titulo" cssClass="error"/>

    <form:label path="autor">Autor:</form:label>
    <form:input path="autor" type="text" />
    <form:errors path="autor" cssClass="error"/>

    <form:label path="año">Año:</form:label>
    <form:input path="año" type="text" />
    <form:errors path="año" cssClass="error"/>

    <form:label path="letra">Letra:</form:label>
    <form:textarea path="letra" />
    <form:errors path="letra" cssClass="error"/>

    <input type="submit" value="Agregar" />
</form:form>

</body>
</html>
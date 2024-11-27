<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Poema</title>
<link rel="stylesheet" href="/css/editarPoema.css"/>
</head>
<body>
<h1>Poemas</h1>

<ul id="nav">
    <li><a href="/poemas">Todos los poemas</a></li>
    <li><a href="/form/agregar">Agregar Poema</a></li>
    <li><a href="/logout">Logout</a></li>
</ul>

<h2>Editar Poema</h1>



<form:form action="/actualizar/${poema.id}" method="POST" modelAttribute="poema">
    <input type="hidden" name="_method" value="PUT" />

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

    <input type="submit" value="Editar" />
</form:form>

</body>
</html>
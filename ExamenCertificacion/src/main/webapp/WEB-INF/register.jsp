<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="/css/register.css"/>
</head>
<body>
<h1>Poemas</h1>
<h2>Registro</h2>

    <ul id="nav">
<li><a href="/login">Login</a></li>
<li><a href="/register">Registro</a></li>
</ul>

<form:form action="/register" method="POST" modelAttribute="usuario">
    <form:label path="nombre">Nombre:</form:label>
    <form:input path="nombre" type="text"/>
    <form:errors path="nombre" cssClass="error"/>

    <form:label path="apellido">Apellido:</form:label>
    <form:input path="apellido" type="text"/>
    <form:errors path="apellido" cssClass="error"/>

    <form:label path="email">Email:</form:label>
    <form:input path="email" type="text"/>
    <form:errors path="email" cssClass="error"/>

    <form:label path="password">Contraseña:</form:label>
    <form:input path="password" type="password"/>
    <form:errors path="password" cssClass="error"/>

    <form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
    <form:input path="confirmarPassword" type="password"/>
    <form:errors path="confirmarPassword" cssClass="error"/>

    <input type="submit" value="Registrarse"/>
</form:form>

</body>
</html>
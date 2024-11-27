<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css"/>
</head>
<body>
    <h1>Poemas</h1>
    <h2>Login</h2>
    
<ul id="nav">
    <li><a href="${pageContext.request.contextPath}/">Login</a></li>
    <li><a href="${pageContext.request.contextPath}/registro">Registro</a></li>
</ul>
    
    <form:form action="/login" method="POST" modelAttribute="loginUsuario"> <!-- Cambiado a loginUsuario -->
        <form:label path="email">Correo:</form:label>
        <form:input path="email" type="text"/>
        <form:errors path="email" cssClass="error" />

        <form:label path="password">Contraseña:</form:label>
        <form:input path="password" type="password"/>
        <form:errors path="password" cssClass="error" />

        <input type="submit" value="Login"/>
    </form:form>

    <p>No tienes una cuenta? <a href="/registro">Regístrarse</a></p>
</body>
</html>
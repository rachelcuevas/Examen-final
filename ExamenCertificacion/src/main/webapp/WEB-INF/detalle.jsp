<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Poema</title>
<link rel="stylesheet" href="/css/detalle.css"/>
</head>
<body>
<h1>Poemas</h1>

<ul id="nav">
<li><a href="/poemas">Todos Los Poemas</a></li>
<li><a href="/form/agregar">Agregar Poema</a></li>
<li><a href="/logout">Logout</a></li>
</ul>

<h2>Detalle del Poema</h2>
<ul>
    <li>Título: ${poema.titulo}</li>
    <li>Autor: ${poema.autor}</li>
    <li>Año: ${poema.año}</li>
    <li>Letra: ${poema.letra}</li>
</ul>

<form action="/eliminar/${poema.id}" method="POST">
    <input type="hidden" name="_method" value="DELETE"/>
    <button>Eliminar poema</button>
</form>

<a href="/poemas">Volver a la lista de poemas</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>  
<html>  
<head>  
    <meta charset="UTF-8">  
    <title>Poemas</title>  
    <link rel="stylesheet" href="/css/poema.css" />  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">  
    <style>  
        /* Agregamos algunos estilos básicos para los botones */  
        .poema-actions button {  
            font-size: 18px;  
            color: #4A90E2; /* Color del texto */  
            background: none; /* Sin fondo */  
            border: none; /* Sin borde */  
            cursor: pointer; /* Cursor de mano */  
            margin: 0 5px; /* Margen entre botones */  
        }  
        .poema-actions button:hover {  
            text-decoration: underline; /* Subraya al pasar el mouse */  
        }  
    </style>  
</head>  
<body>  
    <ul id="nav">  
        <li><a href="/poemas">Todos los poemas</a></li>  
        <li><a href="/form/agregar">Agregar poema</a></li>  
        <li><a href="/logout">Logout</a></li>  
    </ul>  

    <h2>Bienvenido, ${nombreCompleto}</h2>  

    <div id="poemas-container">  
        <c:forEach var="poema" items="${poemas}">  
            <div class="poema-card">  
                <h3>${poema.titulo}</h3>  
                <p>Autor: ${poema.autor}</p>  
                <div class="poema-actions">  
                    <!-- Botón para ver el poema -->  
                    <form action="${pageContext.request.contextPath}/detalle/${poema.id}" method="get">  
                        <button type="submit">  
                            <i class="fas fa-eye"></i> Ver  
                        </button>  
                    </form>  
                    
                    <!-- Solo mostramos el botón de editar si el usuario es el creador del poema -->  
                    <c:if test="${poema.creador.id == idUsuario}">  
                        <form action="${pageContext.request.contextPath}/form/editar/${poema.id}" method="get">  
                            <button type="submit">  
                                <i class="fas fa-pencil-alt"></i> Editar  
                            </button>  
                        </form>  
                    </c:if>  
                </div>  
            </div>  
        </c:forEach>  
    </div>  
</body>  
</html>
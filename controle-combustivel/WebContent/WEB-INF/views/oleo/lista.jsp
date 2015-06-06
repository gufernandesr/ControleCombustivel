<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/div.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oleos Cadastrados</title>
</head>
<body>
<div class="area">
<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
	<div class="conteudo">
	<table border=1>
	<tr>
		<th>Marca</th>
		<th>Tipo</th>
		<th>Classificação</th>
		<th>Duração em Km</th>
		<th>Litragem</th>
	</tr>
	<c:forEach var="oleo" items="${oleos }">
		<tr>
			<td>${oleo.marca }</td>
			<td>${oleo.tipo }</td>
			<td>${oleo.classificacao }</td>
			<td>${oleo.duracaoKm }</td>
			<td>${oleo.litragem }</td>
			<td><a href="mostraOleo?id=${oleo.id }">Alterar</a>
			<td><a href="removeOleo?id=${oleo.id }">Remover</a>
		</tr>
	</c:forEach>
	</table>
	</div>
</div>
</body>
</html>
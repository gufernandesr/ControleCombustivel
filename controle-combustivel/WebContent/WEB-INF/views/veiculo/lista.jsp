<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/div.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Veiculos Cadastrados</title>
</head>
<body>
<div class="area">
	<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
	<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
<div class="conteudo">
<table border=1>
	<tr>
		<th>Modelo</th>
		<th>Montadora</th>
		<th>Placa</th>
		<th>Cor</th>
		<td>Km</td>
	</tr>
	<c:forEach var="veiculo" items="${veiculos}">
		<tr>
			<td>${veiculo.modelo}</td>
			<td>${veiculo.montadora}</td>
			<td>${veiculo.placa}</td>
			<td>${veiculo.cor}</td>
			<td>${veiculo.km}</td>
			<td><a href="mostraVeiculo?id=${veiculo.id }">Alterar</a>
			<td><a href="removeVeiculo?id=${veiculo.id }">Remove</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</div>
</body>
</html>
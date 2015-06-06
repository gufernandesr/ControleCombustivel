<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/div.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Postos Cadastrados</title>
</head>
<body>
<div class="area">
	<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
	<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
<div class="conteudo">

	<table border=1>
		<tr>
			<th>Nome</th>
			<th>Bandeira</th>
			<th>Endereço</th>
		</tr>
		<c:forEach var="posto" items="${postos}">
			<tr>
				<td>${posto.nome}</td>
				<td>${posto.bandeira}</td>
				<td>${posto.endereco}</td>
				<td><a href="mostraPosto?id=${posto.id }">Alterar</a>
				<td><a href="removePosto?id=${posto.id }">Remove</a>
				
			</tr>
		</c:forEach>
	</table>
</div>
</div>
</body>

</html>
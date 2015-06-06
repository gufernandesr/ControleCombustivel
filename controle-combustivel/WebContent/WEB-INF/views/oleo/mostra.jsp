<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/div.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="area">
	<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
	<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
	

<div class="conteudo">
	<form action="alteraOleo" method="post">
	<input type="hidden" name="id" value="${oleo.id }"/>
	Marca: <input type="text" name="marca" value="${oleo.marca }"/><br>
	Tipo: <input type="text" name="tipo" value="${oleo.tipo }"/><br>
	Classificação: <input type="text" name="classificacao" value="${oleo.classificacao }"/><br>
	Duração em Km: <input type="text" name="duracaoKm" value="${oleo.duracaoKm }"/><br>
	Litragem: <input type="text" name="litragem" value="${oleo.litragem }"/><br>
	<input type="submit" value="Alterar" />
	
	</form>
</div>
</div>
</body>
</html>
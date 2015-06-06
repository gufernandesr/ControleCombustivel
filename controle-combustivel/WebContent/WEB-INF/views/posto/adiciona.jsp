<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/div.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adciona Posto</title>
</head>
<body>
<div class="area">
	<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
	<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
<div class="conteudo">
	<form action="adicionaPosto" method="post">
		Nome: <input type="text" name="nome"/><br>
		Bandeira: <input type="text" name="bandeira"/><br>
		Endereco: <input type="text" name="endereco"/><br>
		<input type="submit" value="Adicionar"/>
	</form>
</div>
</div>
</body>
</html>
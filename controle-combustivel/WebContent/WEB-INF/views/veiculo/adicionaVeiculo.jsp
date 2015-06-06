<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="adicionaVeiculo" method="post">
		Modelo: <input type="text" name="modelo" /><br>
		Placa: <input type="text" name="placa" /><br>
		Montadora: <input type="text" name="montadora"><br>
		Cor: <input type="text" name="cor"/><br>
		Km: <input type="text"  name="km" /><br>
		<input type="submit" value="Adicionar" />
	</form>
</div>
</div>
</body>
</html>
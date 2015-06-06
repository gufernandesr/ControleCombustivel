<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/div">
<title>Adiciona Oleo</title>
</head>
<body>
<div class="area">
<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
<div class="conteudo">
<form action="adicionaOleo" method="post">
	Marca: <input type="text" name="marca" /><br>
	Tipo: <input type="text" name="tipo" /><br>
	Classificação: <input type="text" name="classificacao" /><br>
	Duração em Km: <input type="text" name="duracaoKm" /><br>
	Litragem: <input type="text" name="litragem" /><br>
	<input type="submit" value="Adicionar" />
	
	</form>
</div>	
</div>
</body>
</html>
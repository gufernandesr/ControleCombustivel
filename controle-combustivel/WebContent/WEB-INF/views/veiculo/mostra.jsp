<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="area">
	<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
	<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
<div class="conteudo">

	<form action="alteraVeiculo" method="post">
		<input type="hidden" value="${veiculo.id }" name="id"/>
		Modelo: <input type="text" name="modelo" value="${veiculo.modelo }"/><br>
		Placa: <input type="text" name="placa" value="${veiculo.placa }"/><br>
		Montadora: <input type="text" name="montadora" value="${veiculo.montadora }" /><br>
		Cor: <input type="text" name="cor"value="${veiculo.cor }" /><br>
		Km: <input type="text"  name="km" value="${veiculo.km }" /><br>
		<input type="submit" value="Alterar" />
	</form>
</div>
</div>
</body>
</html>
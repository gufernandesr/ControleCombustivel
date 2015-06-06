<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<form action="alteraControleComb" method="post">
	<input type="hidden" name="id" value="${controle.id }"/>
	<input type="hidden" name="idVeiculo" value="${controle.idVeiculo }"/>
		Posto:
			<select name="idPosto">
				<c:forEach var="posto" items="${postos}" >
						<option value="${posto.id}">${posto.nome}</option>
				</c:forEach>
			</select>
			<br>
			Litros: <input type="text" name="litros" value="${controle.litros }"/><br>
 			Data: <input type="text" name="data" value="<fmt:formatDate value="${controle.data.time }" pattern="dd/MM/yyyy"/>"/><br>
			Km Inicial: <input type="text" name="kmInicial" value="${controle.kmInicial }"/><br>
			Km Final: <input type="text" name="kmFinal" value="${controle.kmFinal }"/><br>
			<input type="submit" value="Alterar">
	 </form>
</div>
</div>	 
</body>
</html>
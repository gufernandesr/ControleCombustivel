<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/div;css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<script type="text/javascript">
	function mostrar(id){
		var idr = parseInt(id)+1;
		 
		$('tr').each(function(i){ 
             if(this.id == idr | this.id == "titulo"){
            $(this).show();
           } else{
        	 $(this).hide();
           }
         });
		
	}
		
</script>
<div class="area">
<c:import url="/WEB-INF/views/padroes/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/padroes/menu.jsp"/>
	<div class="conteudo">
	<select name="idVeiculo" onclick="mostrar(this.selectedIndex)">
					<c:forEach var="veiculo" items="${veiculos}" >
							<option value="${veiculo.id}">${veiculo.modelo}</option>
					</c:forEach>
	</select>

	<table border=1 id="tabela">
		<tr id="titulo">
			<th>Posto</th>
			<th>Litros</th>
			<th>Data</th>
			<th>Km Inicial</th>
			<th>Km Final</th>
		</tr>
		<c:forEach var="comb" items="${combustivel }">
			<tr id="${comb.idVeiculo }">
				<td>${comb.idPosto }</td>
				<td>${comb.litros }</td>
				<td><fmt:formatDate value="${comb.data.time }" pattern="dd/MM/yyyy"/></td>
				<td>${comb.kmInicial }</td>
				<td>${comb.kmFinal }</td>
				<td><a href="mostraControleComb?id=${comb.id }">Alterar</a>
				<td><a href="removeControleComb?id=${comb.id }">Remover</a>
			</tr>			
		</c:forEach>	
	</table>
	</div>
</div>
</body>

</html>
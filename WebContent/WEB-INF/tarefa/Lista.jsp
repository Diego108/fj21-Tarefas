<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<title>Insert title here</title>
</head>

<body>

<script>
	function finalizaAgora(id){
		
		$.post("finalizaTarefa", {'id':id}, function(){ 
			$("#tarefa_"+ id).html("Finalizado");
		});
	}
</script>

	<table>
			<c:forEach var="tarefa" items="${lista}">
			<tr id="tarefa_${tarefa.id}">
				<td>${tarefa.descricao}</td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado!</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq false}">
					<td>
					<a href="#" onCick="finalizaAgora(${tarefa.id})"> 
					  Finalizado!
					</a>
					</td>
				</c:if>
				</tr>
			</c:forEach>
	</table>
</body>
</html>
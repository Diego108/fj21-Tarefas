<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:errors path="tarefa.descricao" cssStyle="color:red"/>
	<form action="adicionaTarefa" method="POST">
		<textarea rows="5" cols="15" name="descricao" id="descricao"></textarea>
		
	<input type="submit" value="Enviar"/>
	</form>
</body>
</html>
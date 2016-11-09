<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro de Tarefas</title>
	</head>
	
	<body>
	
		<c:import url="/WEB-INF/views/template/cabecalho.jsp" /> 
		
		<h1>Adicionar nova Tarefa</h1>
		
		<form:errors path="tarefa.descricao" cssStyle="color:red"/>
		<form action="adicionaTarefa" method="post">
			Descricao: <br />
			<textarea name="descricao" rows="5" cols="100"></textarea> <br />
			<input type="submit" value="Adicionar">
		</form>
		
		<c:import url="/WEB-INF/views/template/rodape.jsp" />
		
	</body>
</html>
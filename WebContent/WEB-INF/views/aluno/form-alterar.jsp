<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar dados de aluno </title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Alterando dados de aluno:</h1>
	<form action="/ifmail/aluno/alterar" method="post">
		<div>
			<label>Matricula: ${aluno.matricula}</label> <input type="hidden" name="matricula"
				value="${aluno.matricula }">
		</div>
		<div>
			<label>Nome: </label> <input type="text" name="nome"
				value="${aluno.nome }" />
		</div>
		<div>
			<label>Email: </label> <input type="text" name="email"
				value="${aluno.email }" />
		</div>
		<div>
			<label>Endereço: </label> <input type="text" name="endereco"
				value="${aluno.endereco }" />
		</div>
		<div>
			<label>Data de Nascimento: </label> <input type="text"
				name="dataNascimento"
				value='<fmt:formatDate value="${aluno.dataNascimento.time }" pattern="dd/MM/yyyy"/>' />
		</div>
		<div>
			<button type="submit">Alterar</button>
		</div>
	</form>
</body>
</html>
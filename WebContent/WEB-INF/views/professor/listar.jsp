
<%@page import="java.util.List"%>
<%@page import="professor.dao.ProfessorDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <c:import url="cabecalho.jsp" /> --%>
</head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #e7e7e7;
	background-color: #f3f3f3;
}

li {
	float: left;
}

li a {
	display: block;
	color: #666;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #ddd;
}

li a.active {
	color: white;
	background-color: #4CAF50;
}
</style>

<body>
	<ul>
		<li><a class="active" href="#home"></a></li>
		<li><a href="/ifmail/">Home</a></li>
		<li><a href="/ifmail/professor/formp">Adicionar professor</a></li>
		<li><a href="/ifmail/aluno/form">Adicionar aluno</a></li>
		<li><a href="/ifmail/aluno">Listar aluno</a></li>

	</ul>
	<center>
		<h1>professor adicionados na turma</h1>
	</center>

	<table align="center" border="1">
		<tr>
			<th>Matricula</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Disciplina</th>
			<th>Data de Nascimento</th>
		</tr>

		<c:forEach var="professor" items="${professor}">
			<tr>
				<td>${professor.matriculap }</td>
				<td>${professor.nome }</td>
				<td><c:if test="${not empty professor.email}">
						<a href="mailto:${professor.email}">${professor.email }</a>
					</c:if> <c:if test="${empty professor.email}">
						E-mail não informado :(!
					</c:if></td>
				<!-- <td>${professor.email }</td> -->
				<td>${professor.endereco}</td>
				<td><fmt:formatDate value="${professor.dataNascimento.time}"
						pattern="dd/MMM/yyyy" /></td>
				<td><a href="/ifmail/professor/remover?matriculap=${professor.matriculap}">Remover</a></td>
				<td><a href="/ifmail/professor/alterar?matriculap=${professor.matriculap}">Alterar</a></td>


			</tr>
		</c:forEach>
	</table>
<%-- 	<c:import url="rodape.jsp" /> --%>

</body>
</html>
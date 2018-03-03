<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

li a:hover:not(.active) {
    background-color: #ddd;
}

li a.active {

    color: white;
    background-color: #4CAF50;
}
</style>
</head>

<body>
<ul>
  <li><a class="active" href="#home"></a></li>
  <li><a href="/ifmail/">Home</a></li>
  <li><a href="/ifmail/professor">Listar todos os professores</a></li>
  
</ul>
<center>
	<h1>Adicionando um professor: </h1>
	<form action="/ifmail/professor" method = "post" >
		<div>
			<label>Matricula: </label>
			<input type="text" name="matriculap" />
		</div>
		
		
		<div>
			<label>Nome: </label>
			<input type="text" name="nome" />
		</div>
		<div>
			<label>Email: </label>
			<input type="text" name="email" />
		</div>
		<div>
			<label>Endereço: </label>
			<input type="text" name="endereco" />
		</div>
		<div>
			<label>Disciplina: </label>
			<input type="text" name="disciplina" />
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento" />
		</div>
		<div>
			<button type="submit">Adicionar</button>
			
		</div>
	</form>
	</center>
	


	
</body>
</html>
<%@page import="model.Cliente"%>
<%@page import="dao.ClienteDAO"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ page import="dao.PrestadorDAO"%>
<%@ page import="model.Prestador"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Easy Service</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Optional theme -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script src="/js/bootstrap.min.js"></script>
<script src="js/time.js"></script>
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
</script>
<![endif]-->


<style type="text/css">
@import url("css/adminEasyService.css");

@import url("css/rankingStars.css");

body {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 14px;
	background-color: #FFF;
	width: auto;
	margin-left: auto;
	margin-right: auto;
}

#name {
	margin: auto;
}

#ranking {
	text-align: center;
	vertical-align: center;
}

td
{
font-family: sans-serif;
}
</style>

</head>
<body onLoad="getDateTime()">
	<header class="bg-primary">
		<h1 id="name">Easy Service</h1>
	</header>
	<nav>
		<ul>
			<li><a href="adminMain.jsp">Inicio</a></li>
			<li><a href="adminListarClientes.jsp">Clientes</a></li>
			<li><a href="adminListarPrestadores.jsp">Prestadores de
					Serviços</a></li>
			<li><a href="ControllerAdmin?action=sair">Sair</a></li>
		</ul>
	</nav>
	<section>
		<h2>Menu Principal</h2>

		<%
			String nomeadmin = session.getAttribute("admin").toString();
			
			PrestadorDAO daoP = new PrestadorDAO();
			List<Prestador> prestadorList = new ArrayList<Prestador>();
			prestadorList = daoP.getAllPrestadores("AVALIACAO");
			
			ClienteDAO daoC =new ClienteDAO();
			List<Cliente> clienteList = new ArrayList<Cliente>();
			clienteList = daoC.getAllClientes();
		%>

		<article>
			<h2 align="center">Seja Bem Vindo</h2>
			<div class="row">
				<div class="col-sm-2">
					<label id="nameAdmin"> </label>
				</div>
				<div class="col-sm-8"></div>
				<div class="col-sm-2">
					<label id="time"></label>
				</div>
			</div>
			<table class="table table-striped">
				<tr>
					<td><b>Usuário</b></td>
				</tr>
				<tr>
					<td><%=nomeadmin%></td>
				</tr>
				<tr>
					<td><b>Clientes Cadastrados</b></td>
				</tr>
				<tr>
					<td><%=clienteList.size()%></td>
				</tr>
				<tr>
					<td><b>Prestadores Cadastrados</b></td>
				</tr>
				<tr>
					<td><%=prestadorList.size()%></td>
				</tr>
			</table>

		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>
</html>

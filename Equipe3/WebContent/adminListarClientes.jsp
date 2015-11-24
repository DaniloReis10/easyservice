<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Easy Service</title>

<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- jTable -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet"
	type="text/css" />
<link href="css/validationEngine.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/validationEngine.js"></script>
<script type="text/javascript" src="js/validationEngine-pt.js"></script>


<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>

<!-- AJAX adminListar Clientes -->
<script type="text/javascript" src="js/functionsClientes.js"></script>

<style type="text/css">
@import url("css/adminEasyService.css");

@import url("css/rankingStars.css");

@import url("css/adminListarClientes.css");
</style>

</head>

<body>
	<header class="bg-primary">
		<h1 id="header">Easy Service</h1>
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

		<article>
			<h2 align="center">Clientes Cadastrados</h2>
			<div class="container">
				<div id="ClientTableContainer"></div>
			</div>
		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>

<style>
</style>

</html>
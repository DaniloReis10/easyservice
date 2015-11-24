<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Easy Service</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8" />

<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-rating-input.js"></script>

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

<!-- AJAX Prestador -->
<script type="text/javascript" src="js/functionsPrestador.js"></script>

<style type="text/css">
@import url("css/adminEasyService.css");
@import url("css/rankingStars.css");
@import url("css/adminListarPrestadores.css");

</style>

</head>
<body>
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

		<article>
			<h2 align="center">Prestadores de Serviços</h2>
			<div class="container">
				<div id="PrestadoresTableContainer"></div>
			</div>
		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>
</html>

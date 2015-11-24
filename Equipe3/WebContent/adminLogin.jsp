<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<title>Easy Service</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/bootstrap.min.js"></script>

<style type="text/css">
@import url("css/adminEasyService.css");

#submitAdmin {
	width: 100px;
	height: 25px;
	margin-left: 2px;
	margin-top: 2px;
}

#name {
	font-family: Verdana, Geneva, sans-serif;
	margin-left: 10px;
}
</style>

<body onload="validation()">
	<header class="bg-primary">
		<h1 id="name">Easy Service</h1>
	</header>
	<section>
		<h2 align="center">Login Administrador</h2>
		<article>
			<h2>Bem vindo</h2>
			<form id="myForm" action="ControllerAdmin?action=login" method="post">
				<table class="table">
					<tr>
						<td>login:</td>
						<td><input type="text" name="loginAdmin" max="10" min="4"></td>
					</tr>
					<tr>
						<td>Senha:</td>
						<td><input type="password" name="passwordAdmin"></td>
					</tr>
					<tr>
						<td><button class="btn btn-primary btn-md" type="button"
								name="submitAdmin" value="Login"
								onclick="document.getElementById('myForm').submit();">Login</button></td>
						<td></td>
					</tr>
				</table>
			</form>
		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>
<script type="text/javascript">
	function validation()
	{
<%String str = null;
			if (request.getAttribute("alert") != null) {
				str = request.getAttribute("alert").toString();

				if (str.equals("false")) {%>
	alert("Login ou Senha Inválidos");
<%}
			}

			if (request.getAttribute("login") != null) {
				str = request.getAttribute("login").toString();

				if (str.equals("true")) {%>
	alert("Administrador/Operador Cadastrado com sucesso!");
<%}
			}%>
	}
</script>
</html>
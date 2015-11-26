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


<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<!-- RATING STAR -->
<link rel="stylesheet" href="css/jquery.rating.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.rating.js"></script>

<style type="text/css">
@import url("css/adminEasyService.css");

body {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 14px;
	background-color: #FFF;
}

#name {
	margin: auto;
}

span.tab {
	padding: 0 80px; /* Or desired space*/
}

.table {
	table-layout: fixed;
	word-wrap: break-word;
	width: 400px;
}
</style>

</head>
<body>
	<header class="bg-primary">
		<h1 id="name">Easy Service</h1>
	</header>
	<section>
		<h2 align="center">Avaliação de Serviço</h2>
		<article>
			<h2 align="left" style="padding-left: 20px;">Detalhes</h2>
			<div class="container">
				<table class="table table-striped">
					<tbody>
						<%
							Prestador prestador = (Prestador) request.getAttribute("prestador");
							String servico = (String) request.getAttribute("servico");
						%>

						<tr>
							<td><b>Prestador</b></td>
						</tr>
						<tr>
							<td><%=prestador.getNome()%></td>
						</tr>
						<tr>
							<td><b>Serviço</b></td>
						</tr>
						<tr>
							<td><%=servico%></td>
						</tr>
					</tbody>
				</table>

				<form id="avaliacao"
					action="ControllerPrestador?action=updateRating" method="post">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Avaliação</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><b>Qualidade</b></td>
							</tr>

							<tr>
								<td><input name="star1" type="radio" value="20"
									class="star required"></input> <input name="star1" type="radio"
									value="40" class="star" /></input> <input name="star1" type="radio"
									value="60" class="star" checked="checked" /></input> <input
									name="star1" type="radio" value="80" class="star" /></input> <input
									name="star1" type="radio" value="100" class="star" /></input></td>
							</tr>

							<tr>
								<td><b>Comunicação</b></td>
							</tr>

							<tr>
								<td><input name="star2" type="radio" value="20"
									class="star required"></input> <input name="star2" type="radio"
									value="40" class="star" /></input> <input name="star2" type="radio"
									value="60" class="star" checked="checked" /></input> <input
									name="star2" type="radio" value="80" class="star" /></input> <input
									name="star2" type="radio" value="100" class="star" /></input></td>
							</tr>

							<tr>
								<td><b>Limpeza</b></td>
							</tr>

							<tr>
								<td><input name="star3" type="radio" value="20"
									class="star required"></input> <input name="star3"
									type="radio" value="40" class="star" /></input> <input name="star3"
									type="radio" value="60" class="star" checked="checked" /></input> <input
									name="star3" type="radio" value="80" class="star" /></input> <input
									name="star3" type="radio" value="100" class="star" /></input></td>
							</tr>

							<tr>
								<td><b>Preço</b></td>
							</tr>

							<tr>
								<td><input name="star4" type="radio" value="20"
									class="star required"></input> <input name="star4" type="radio"
									value="40" class="star" /></input> <input name="star4" type="radio"
									value="60" class="star" checked="checked" /></input> <input
									name="star4" type="radio" value="80" class="star" /></input> <input
									name="star4" type="radio" value="100" class="star" /></input></td>
							</tr>


						</tbody>

					</table>

				</form>
				<button onclick="document.getElementById('avaliacao').submit();"
					class="btn btn-primary btn-md" type="button">Confirmar</button>
			</div>

		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>

</body>
</html>



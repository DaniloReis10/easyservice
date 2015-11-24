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

<style type="text/css">
@import url("css/adminEasyService.css");

@import url("css/mostraCliente.css");
</style>

</head>
<body>
	<header class="bg-primary">
		<h1 id="name">Easy Service</h1>
	</header>
	<section>
		<h2>Prestadores de Serviços</h2>
		<article>
			<h2 align="center">Detalhes</h2>
			<div class="container">
				<table class="table">
					<tbody>
						<%
							PrestadorDAO dao = new PrestadorDAO();
							List<Prestador> prestadorList = new ArrayList<Prestador>();

							prestadorList = dao.getAllPrestadores("AVALIACAO", request.getParameter("id"));

							for (int i = 0; i < prestadorList.size(); i++)

							{
						%>

						<tr>
							<td><b>Nome</b></td>
						</tr>
						<tr>
							<td><%=prestadorList.get(i).getNome()%></td>
						</tr>
						<tr>
							<td><b>Telefone</b></td>
						</tr>
						<tr>
							<td><%=prestadorList.get(i).getTelefone()%></td>
						</tr>
						<tr>
							<td><b>Serviços</b></td>
						</tr>
						<tr>
							<td><%=prestadorList.get(i).getServicos()%></td>
						</tr>
						<tr>
							<td><b>Avaliação</b></td>
						</tr>
						<tr>
							<td><div class='rating_bar'>
									<div class="rating"
										style="width: <%=prestadorList.get(i).getAvaliacao()%>%;"></div>
								</div></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td><button onclick="document.location = 'ranking.jsp'"
									class="btn btn-primary btn-md" type="button">Voltar</button></td>
						</tr>
					</tbody>

				</table>

			</div>

		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>
</html>

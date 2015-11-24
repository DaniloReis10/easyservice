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

@import url("css/ranking.css");
</style>

</head>
<body>
	<header class="bg-primary">
		<h1 id="name">Easy Service</h1>
	</header>
	<section>
		<h2>Ranking Prestadores de Serviços</h2>
		<article>
			<h2 align="center">Prestadores de Serviços</h2>
			<div class="container">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Serviços</th>
							<th id="ranking">Ranking</th>
						</tr>
					</thead>
					<tbody>
						<%
							PrestadorDAO dao = new PrestadorDAO();
							List<Prestador> prestadorList = new ArrayList<Prestador>();

							prestadorList = dao.getAllPrestadores("AVALIACAO");

							for (int i = 0; i < prestadorList.size(); i++)

							{
						%>

						<tr onclick="document.location = 'mostraCliente.jsp?id=<%=i%>';">
							<td><%=prestadorList.get(i).getNome()%></td>
							<td><%=prestadorList.get(i).getServicos()%></td>
							<td align="center">
								<div class='rating_bar'>
									<div class="rating"
										style="width: <%=prestadorList.get(i).getAvaliacao()%>%;"></div>
								</div>
							</td>
						</tr>
						<%
							}
						%>

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

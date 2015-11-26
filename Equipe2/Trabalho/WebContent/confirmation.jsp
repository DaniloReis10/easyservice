<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirme Seus Dados</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" href="style/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="style/bootstrap.min.css">
		<link rel="stylesheet" href="style/datepicker.css">
		<link rel="stylesheet" href="style/style.css">
	</head>
	<body>
		<!-- BARRA DO TOPO DO SITE -->
		<div class="top-bar">
			<div class="col-md-10 col-md-offset-1 bar-title">
				EasyService
			</div>
		</div>
		<!-- BARRA DO TOPO DO SITE -->

		<!-- CONTEUDO -->
		<div class="card">
			<div class="card-head">
				Confirmação de Dados
			</div>
			<div class="card-body">
			<form method="POST" action="save" id="form">
				<% if((request.getParameter("name") != "") || (request.getParameter("surname") != "") || (request.getParameter("email") != "")) { %>
				<div class="tab-pane body" ng-class="account_class">
					<section>
						<% if((request.getParameter("name") != "") || (request.getParameter("surname") != "")) { %>
						<div class="row">
							<% if(request.getParameter("name") != "") { %>
							<div class="col-md-6">
								<div class="form-group">
									<label>Nome</label>
									<input type="text" class="form-control" value="<%= request.getParameter("name") %>" disabled>
									<input type="hidden" name="name" value="<%= request.getParameter("name") %>">
								</div>
							</div>
							<% } %>
							<% if(request.getParameter("surname") != "") { %>
							<div class="col-md-6">
								<div class="form-group">
									<label>Sobrenome</label>
									<input type="text" class="form-control" value="<%= request.getParameter("surname") %>" disabled>
									<input type="hidden" name="surname" value="<%= request.getParameter("surname") %>">
								</div>
							</div>
							<% } %>
						</div>
						<% } %>
						<% if(request.getParameter("email") != "") { %>
						<div class="row">
							<div class="col-md-7">
								<div class="form-group" ng-class="errorEmail">
									<label>E-mail</label>
									<input type="text" class="form-control" value="<%= request.getParameter("email") %>" disabled>
									<input type="hidden" name="email" value="<%= request.getParameter("email") %>">
								</div>
							</div>
						</div>
						<% } %>
					</section>
				</div>
				
				<% } %>
				
				<% if((request.getParameter("profession") != "") || (request.getParameter("value") != "") || (request.getParameter("fix_phone") != "") || (request.getParameter("mobile_phone") != "")) { %>
				<hr />
				<div class="tab-pane body" ng-class="professional_class">
					<section>
						<% if((request.getParameter("profession") != "") || (request.getParameter("value") != "")) { %>
						<div class="row">
							<% if(request.getParameter("profession") != "") { %>
							<div class="col-md-6">
								<div class="form-group">
									<label>Atuação (separando por virgulas)</label>
									<input type="text" class="form-control" value="<%= request.getParameter("profession") %>" disabled>
									<input type="hidden" name="profession" value="<%= request.getParameter("profession") %>">
								</div>
							</div>
							<% } %>
							<% if(request.getParameter("value") != "") { %>
							<div class="col-md-4">
								<div class="form-group">
									<label>Preço/hora</label>
									<input type="text" class="form-control" value="<%= request.getParameter("value") %>" disabled>
									<input type="hidden" name="value" value="<%= request.getParameter("value") %>">
								</div>
							</div>
							<% } %>
						</div>
						<% } %>
						<% if((request.getParameter("fix_phone") != "") || (request.getParameter("mobile_phone") != "")) { %>
						<div class="row">
							<% if(request.getParameter("fix_phone") != "") { %>
							<div class="col-md-5">
								<div class="form-group fix_phone_error">
									<label>Telefone Fixo</label>
									<input type="text" class="form-control" name="fix_phone" value="<%= request.getParameter("fix_phone") %>" disabled>
									<input type="hidden" name="fix_phone" value="<%= request.getParameter("fix_phone") %>">
								</div>
							</div>
							<% } %>
							<% if(request.getParameter("mobile_phone") != "") { %>
							<div class="col-md-5">
								<div class="form-group mobile_phone_error">
									<label>Telefone Móvel</label>
									<input type="text" class="form-control" value="<%= request.getParameter("mobile_phone") %>" disabled>
									<input type="hidden" name="mobile_phone" value="<%= request.getParameter("mobile_phone") %>">
								</div>
							</div>
							<% } %>
						</div>
						<% } %>
					</section>
				</div>
				
				<% } %>
				<% if((request.getParameter("dob") != "") || (request.getParameter("cpf") != "") || (request.getParameter("addres") != "") || (request.getParameter("postal_code") != "") || (request.getParameter("addres_details") != "")) { %>
				<hr />
				
				<div class="tab-pane body" ng-class="personal_class">
					<section>
						<% if((request.getParameter("dob") != "") || (request.getParameter("cpf") != "")) { %>
						<div class="row">
							<% if(request.getParameter("dob") != "") { %>
							<div class="col-md-4">
								<div class="form-group">
									<label>Data de Nascimento</label>
									<input type="text" class="form-control" value="<%= request.getParameter("dob") %>" disabled>
									<input type="hidden" name="dob" value="<%= request.getParameter("dob") %>">
								</div>
							</div>
							<% } %>
							<% if(request.getParameter("cpf") != "") { %>
							<div class="col-md-5">
								<div class="form-group">
									<label>CPF</label>
									<input type="text" class="form-control" value="<%= request.getParameter("cpf") %>" disabled>
									<input type="hidden" name="cpf" value="<%= request.getParameter("cpf") %>">
								</div>
							</div>
							<% } %>
						</div>
						<% } %>
						<% if((request.getParameter("addres") != "") || (request.getParameter("postal_code") != "")) { %>
						<div class="row">
							<% if(request.getParameter("addres") != "") { %>
							<div class="col-md-8">
								<div class="form-group">
									<label>Endereço</label>
									<input type="text" class="form-control" value="<%= request.getParameter("addres") %>" disabled>
									<input type="hidden" name="addres" value="<%= request.getParameter("addres") %>">
								</div>
							</div>
							<% } %>
							<% if(request.getParameter("postal_code") != "") { %>
							<div class="col-md-4">
								<div class="form-group">
									<label>CEP</label>
									<input type="text" class="form-control" value="<%= request.getParameter("postal_code") %>" disabled>
									<input type="hidden" name="postal_code" value="<%= request.getParameter("postal_code") %>">
								</div>
							</div>
							<% } %>
						</div>
						<% } %>
						<% if(request.getParameter("addres_details") != "") { %>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Complemento</label>
									<input type="text" class="form-control" value="<%= request.getParameter("addres_details") %>" disabled>
									<input type="hidden" name="addres_details" value="<%= request.getParameter("addres_details") %>">
								</div>
							</div>
						</div>
						<% } %>
					</section>
				</div>
				<% } %>
				<% if(request.getParameter("password") != ""){ %>
				<input type="hidden" name="password" value="<%= request.getParameter("password") %>">
				<% } %>
			</form>
			</div>
			<div class="card-footer">
				<div class="row">
					<div class="col-md-12">
						<div class="footer-options text-left">
							<a class="footer-button clickable" id="confirm">Confirmar</a>
							<a class="footer-button clickable" id="cancel">Cancelar</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- CONTEUDO -->
	</body>

	<!-- SCRIPTS -->
	<script src="style/jquery-2.1.4.min.js"></script>
	<script src="style/angular.min.js"></script>
	<script src="style/datepicker.js"></script>
	<script src="style/mask.js"></script>
	<!-- <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCK3dIwcYIdrAvJKoJx8dJUt4fIUqvNcB0&callback=initMap"></script> -->
	<script>
		var request = <%= request %>;
	</script>
	<script src="style/script_confirmation.js"></script>
	<!-- SCRIPTS -->
</html>

<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<title>Easy Service</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- BOOTSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<!-- JQUERY VALIDATE FIELDS -->
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>


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
		<h2 align="center">Cadastro Administrador</h2>
		<article>
			<h2>Cadastro</h2>
			<form name="cadastroAdmin" method="post"
				action="ControllerAdmin?action=cadastro">
				<div class="form-group">
					<label class="control-label" for="nome">Nome:</label>
					<div class="input-group">
						<span class="input-group-addon"> </span> <input
							class="form-control" placeholder="Digite seu nome Completo"
							name="nome" type="text" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="email">Email:</label>
					<div class="input-group">
						<span class="input-group-addon">@</span> <input
							class="form-control" placeholder="Digite um email válido"
							name="email" type="email" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="login">Login:</label>
					<div class="input-group">
						<span class="input-group-addon"> </span> <input
							class="form-control" placeholder="Digite seu login" name="login"
							type="text" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="senha">Senha:</label>
					<div class="input-group">
						<span class="input-group-addon"> </span> <input
							class="form-control" placeholder="Digite Senha" name="senha"
							id="senha" type="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="senhanovamente">Senha
						Novamente:</label>
					<div class="input-group">
						<span class="input-group-addon"> </span> <input
							class="form-control" placeholder="Digite Senha Novamente"
							name="senhanovamente" type="password" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label" for="modo">Previlégio:</label>
					<div class="input-group">
						<input name="operador" type="checkbox" value="operador">Operador
						<input name="administrador" type="checkbox" value="administrador">Administrador
					</div>
				</div>

				<button type="submit" class="btn btn-primary"
					onclick="document.getElementById('cadastroAdmin').submit();">Cadastrar</button>
			</form>

		</article>
	</section>
	<footer class="bg-primary">
		<p>&copy; 2015 Easy Sevice. Todos os direitos Reservados.</p>
	</footer>
</body>

<script type="text/javascript">
	$('form').validate({
		rules : {
			nome : {
				minlength : 2,
				lettersonly : true,
				required : true
			},
			login : {
				minlength : 2,
				lettersonly : true,
				required : true
			},
			email : {
				email : true,
				required : true
			},

			senha : {
				minlength : 4,
				required : true
			},

			senhanovamente : {
				equalTo : "#senha",
				minlength : 4,
				required : true
			},

		},

		messages : {
			nome : {
				required : "O campo nome é obrigatorio!",
				lettersonly : "Letras e espaços apenas!",
				minlength : "O campo nome deve conter no mínimo 2 caracteres!"
			},
			login : {
				required : "O campo login é obrigatorio!",
				lettersonly : "Letras e espaços apenas!",
				minlength : "O campo nome deve conter no mínimo 2 caracteres!"
			},
			email : {
				required : "O campo email é obrigatorio!",
				email : "O campo email deve conter um email válido!"
			},
			senha : {
				required : "O campo email é obrigatorio!",
				minlength : "O campo nome deve conter no mínimo 4 caracteres!"
			},
			senhanovamente : {
				required : "O campo email é obrigatorio!",
				minlength : "O campo nome deve conter no mínimo 4 caracteres!",
				equalTo : "Senha diferente!"
			},
		},

		highlight : function(element)
		{
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element)
		{
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function(error, element)
		{
			if (element.parent('.input-group').length)
			{
				error.insertAfter(element.parent());
			} else
			{
				error.insertAfter(element);
			}
		}
	});

	jQuery.validator.addMethod("lettersonly", function(value, element)
	{
		return this.optional(element) || /^[a-z ]+$/i.test(value);
	}, "Letters and spaces only please");

	function validation()
	{
<%String str = null;
			if (request.getAttribute("alert") != null) {
				str = request.getAttribute("alert").toString();

				if (str.equals("false")) {%>
	alert("Usuário já existente!");
<%}
			}%>
	}
</script>
</html>
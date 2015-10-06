$(function()
{
	var index = 0;
	function Adicionar()
	{
		index++;
		$("#tblCadastro tbody")
				.append(		"<tr>"
								+ "<td><input type='text' size='16' name='nome"+index+"' placeholder='Nome'/></td>"
								+ "<td><input type='text'size='16' 	name='email"+index+"' placeholder='exemplo@com'/></td>"
								+ "<td><input type='text' size='12' name='cpf"+index+"' placeholder='12345678900'/></td>"
								+ "<td><input type='text'size='12'	name='telefone"+index+"' placeholder='85999887766'/></td>"
								+ "<td><input type='text'size='16' 	name='endereco"+index+"' placeholder='Av. Abolição'/></td>"
								+ "<td><input type='text'size='12'	name='cep"+index+"' placeholder='XXXXX-XXX'/></td>"
								+ "<td><input type='text'size='6'	name='numero"+index+"' placeholder='XX'/></td>"
								+ "<td><img src='images/disk.png' class='btnSalvar'><img src='images/delete.png' class='btnExcluir'/></td>"
								+ "</tr>");

		$(".btnSalvar").bind("click", Salvar);
		$(".btnExcluir").bind("click", Excluir);
		inputTextValidation();
	}
	;

	function Editar()
	{
		var par = $(this).parent().parent(); // tr
		var tdNome = par.children(":nth-child(1)").children();
		var tdEmail = par.children(":nth-child(2)").children();
		var tdCpf = par.children(":nth-child(3)").children();
		var tdTel = par.children(":nth-child(4)").children();
		var tdEndereco = par.children(":nth-child(5)").children();
		var tdCep = par.children(":nth-child(6)").children();
		var tdNumero = par.children(":nth-child(7)").children();
		var tdBotoes = par.children("td:nth-child(8)");

		tdNome.html("<input type='text' size='16' name='nome"+index+"'/>");
		tdEmail.html("<input type='text' id='tdEmail' value='" + tdEmail.html()
				+ "' size='16'/>");
		tdCpf.html("<input type='text' id='tdCpf' value='" + tdCpf.html()
				+ "' size='12'/>");
		tdTel.html("<input type='text' id='tdTel' value='" + tdTel.html()
				+ "' size='12'/>");
		tdEndereco.html("<input type='text' id='tdEndereco' value='"
				+ tdEndereco.html() + "' size='16'/>");
		tdCep.html("<input type='text' id='tdCep' value='" + tdCep.html()
				+ "' size='12'/>");
		tdNumero.html("<input type='text' id='tdNumero' value='"
				+ tdNumero.html() + "' size='6'/>");
		tdBotoes.html("<img src='images/disk.png' class='btnSalvar'/>");

		$(".btnSalvar").bind("click", Salvar);
		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	}
	;

	function Salvar()
	{
		var par = $(this).parent().parent(); // tr
		var tdNome = par.children(":nth-child(1)").children();
		var tdEmail = par.children(":nth-child(2)").children();
		var tdCpf = par.children(":nth-child(3)").children();
		var tdTel = par.children(":nth-child(4)").children();
		var tdEndereco = par.children(":nth-child(5)").children();
		var tdCep = par.children(":nth-child(6)").children();
		var tdNumero = par.children(":nth-child(7)").children();
		var tdBotoes = par.children("td:nth-child(8)");

		tdNome.html(tdNome.children("input[type=text]").val());
		tdEmail.html(tdEmail.children("input[type=text]").val());
		tdCpf.html(tdCpf.children("input[type=text]").val());
		tdTel.html(tdTel.children("input[type=text]").val());
		tdEndereco.html(tdEndereco.children("input[type=text]").val());
		tdCep.html(tdCep.children("input[type=text]").val());
		tdNumero.html(tdNumero.children("input[type=text]").val());
		tdBotoes
				.html("<img src='images/delete.png' class='btnExcluir'/><img src='images/pencil.png' class='btnEditar'/>");

		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	}
	;

	function Excluir()
	{
		var par = $(this).parent().parent(); // tr
		par.remove();
		index--;
	}
	;

	$(".btnEditar").bind("click", Editar);
	$(".btnExcluir").bind("click", Excluir);
	$("#btnAdicionar").bind("click", Adicionar);

});

/*function validFields()
{
	var elements = [];
	var inputs = document.getElementsByTagName("input");
	for(var i = 0; i < inputs.length; i++) {
	    if(inputs[i].name.indexOf('name') == 0) {
	    	elements.push(inputs[i]);
	    }
	}
}*/
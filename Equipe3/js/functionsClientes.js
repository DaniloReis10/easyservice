$(function(){

	function Adicionar(){
		$("#tblCadastro tbody").append(
			"<tr>"+
			"<td><input type='text' size='16'/></td>"+
			"<td><input type='text'size='16'/></td>"+
			"<td><input type='text'size='12'/></td>"+
			"<td><input type='text'size='12'/></td>"+
			"<td><input type='text'size='16'/></td>"+
			"<td><input type='text'size='12'/></td>"+
			"<td><input type='text'size='6'/></td>"+
			"<td><img src='images/disk.png' class='btnSalvar'><img src='images/delete.png' class='btnExcluir'/></td>"+
			"</tr>");
	
		$(".btnSalvar").bind("click", Salvar);		
		$(".btnExcluir").bind("click", Excluir);
	};

	function Editar(){
		var par = $(this).parent().parent(); //tr
		var tdNome = par.children("td:nth-child(1)");
		var tdEmail = par.children("td:nth-child(2)");
		var tdCpf = par.children("td:nth-child(3)");
		var tdTel = par.children("td:nth-child(4)");
		var tdEndereco = par.children("td:nth-child(5)");
		var tdCep = par.children("td:nth-child(6)");
		var tdNumero = par.children("td:nth-child(7)");
		var tdBotoes = par.children("td:nth-child(8)");


		tdNome.html("<input type='text' id='tdNome' value='"+tdNome.html()+"' size='16'/>");
		tdEmail.html("<input type='text' id='tdEmail' value='"+tdEmail.html()+"' size='16'/>");
		tdCpf.html("<input type='text' id='tdCpf' value='"+tdCpf.html()+"' size='12'/>");
		tdTel.html("<input type='text' id='tdTel' value='"+tdTel.html()+"' size='12'/>");
		tdEndereco.html("<input type='text' id='tdEndereco' value='"+tdEndereco.html()+"' size='16'/>");
		tdCep.html("<input type='text' id='tdCep' value='"+tdCep.html()+"' size='12'/>");
		tdNumero.html("<input type='text' id='tdNumero' value='"+tdNumero.html()+"' size='6'/>");
		tdBotoes.html("<img src='images/disk.png' class='btnSalvar'/>");

		$(".btnSalvar").bind("click", Salvar);
		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	};

	function Salvar(){
		var par = $(this).parent().parent(); //tr
		var tdNome = par.children("td:nth-child(1)");
		var tdEmail = par.children("td:nth-child(2)");
		var tdCpf = par.children("td:nth-child(3)");
		var tdTel = par.children("td:nth-child(4)");
		var tdEndereco = par.children("td:nth-child(5)");
		var tdCep = par.children("td:nth-child(6)");
		var tdNumero = par.children("td:nth-child(7)");
		var tdBotoes = par.children("td:nth-child(8)");

		tdNome.html(tdNome.children("input[type=text]").val());
		tdEmail.html(tdEmail.children("input[type=text]").val());
		tdCpf.html(tdCpf.children("input[type=text]").val());
		tdTel.html(tdTel.children("input[type=text]").val());
		tdEndereco.html(tdEndereco.children("input[type=text]").val());
		tdCep.html(tdCep.children("input[type=text]").val());
		tdNumero.html(tdNumero.children("input[type=text]").val());
		tdBotoes.html("<img src='images/delete.png' class='btnExcluir'/><img src='images/pencil.png' class='btnEditar'/>");

		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	};

	function Excluir(){
		var par = $(this).parent().parent(); //tr
		par.remove();
	};

	$(".btnEditar").bind("click", Editar);
	$(".btnExcluir").bind("click", Excluir);
	$("#btnAdicionar").bind("click", Adicionar);			

});
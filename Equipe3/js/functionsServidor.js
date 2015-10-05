$(function(){
	var index = 0;
	function Adicionar(){
		index++;
		$("#tblCadastro tbody").append(
			"<tr>"+
			"<td><input type='text' size='16' min='0' name='nome"+index+"'/></td>"+
			"<td><input type='text'size='12' min='0' onblur='' /></td>"+
			"<td><input type='text'size='12' min='0'/></td>"+
			"<td><input type='text'size='12' min='0'/></td>"+
			"<td><input type='text'size='12' min='0'/></td>"+
			"<td><form id='ratingsForm'>"+
                "<div class='stars'>"+
                 "<input type='radio' name='star' class='star-1' id='star_"+index+"_1' />"+
                  "<label class='star-1' for='star_"+index+"_1'>1</label>"+

                  "<input type='radio' name='star' class='star-2' id='star_"+index+"_2' />"+
                  "<label class='star-2' for='star_"+index+"_2'>2</label>"+

                  "<input type='radio' name='star' class='star-3' id='star_"+index+"_3' />"+
                  "<label class='star-3' for='star_"+index+"_3'>3</label>"+

                  "<input type='radio' name='star' class='star-4' id='star_"+index+"_4' />"+
                  "<label class='star-4' for='star_"+index+"_4'>4</label>"+

                  "<input type='radio' name='star' class='star-5' id='star_"+index+"_5' />"+
                  "<label class='star-5' for='star_"+index+"_5'>5</label>"+

                  "<span></span>"+
                "</div>"+
              "</form></td>"+
			"<td><img src='images/disk.png' class='btnSalvar'><img src='images/delete.png' class='btnExcluir'/></td>"+
			"</tr>");
	
		$(".btnSalvar").bind("click", Salvar);		
		$(".btnExcluir").bind("click", Excluir);
		
	};

	function Editar(){
		var par = $(this).parent().parent(); //tr
		var tdNome = par.children("td:nth-child(1)");
		var tdCpf = par.children("td:nth-child(2)");
		var tdTel = par.children("td:nth-child(3)");
		var tdServico = par.children("td:nth-child(4)");
		var tdCarteira = par.children("td:nth-child(5)");
		var tdRanking = par.children("td:nth-child(6)");
		var tdBotoes = par.children("td:nth-child(7)");


		tdNome.html("<input type='text' id='tdNome' value='"+tdNome.html()+"' size='16'/>");
		tdCpf.html("<input type='text' id='tdCpf' value='"+tdCpf.html()+"' size='12'/>");
		tdTel.html("<input type='text' id='tdTel' value='"+tdTel.html()+"' size='12'/>");
		tdServico.html("<input type='text' id='tdServico' value='"+tdServico.html()+"' size='12'/>");
		tdCarteira.html("<input type='text' id='tdCarteira' value='"+tdCarteira.html()+"' size='12'/>");
		tdRanking.html("<input type='text' id='tdRanking' value='"+tdNumero.html()+"' size='6'/>");
		tdBotoes.html("<img src='images/disk.png' class='btnSalvar'/>");

		$(".btnSalvar").bind("click", Salvar);
		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	};

	function Salvar(){
		var par = $(this).parent().parent(); //tr
		var tdNome = par.children("td:nth-child(1)");
		var tdCpf = par.children("td:nth-child(2)");
		var tdTel = par.children("td:nth-child(3)");
		var tdServico = par.children("td:nth-child(4)");
		var tdCarteira = par.children("td:nth-child(5)");
		var tdRanking = par.children("td:nth-child(6)");
		var tdBotoes = par.children("td:nth-child(7)");

		tdNome.html(tdNome.children("input[type=text]").val());
		tdCpf.html(tdCpf.children("input[type=text]").val());
		tdTel.html(tdTel.children("input[type=text]").val());
		tdServico.html(tdServico.children("input[type=text]").val());
		tdCarteira.html(tdCarteira.children("input[type=text]").val());
		tdRanking.html(tdRanking.children("input[type=text]").val());
		tdBotoes.html("<img src='images/delete.png' class='btnExcluir'/><img src='images/pencil.png' class='btnEditar'/>");

		$(".btnEditar").bind("click", Editar);
		$(".btnExcluir").bind("click", Excluir);
	};

	function Excluir(){
		var par = $(this).parent().parent(); //tr
		par.remove();
		index--;
	};

	$(".btnEditar").bind("click", Editar);
	$(".btnExcluir").bind("click", Excluir);
	$("#btnAdicionar").bind("click", Adicionar);			

});


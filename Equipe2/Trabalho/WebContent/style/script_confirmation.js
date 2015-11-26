/**
* 
* Função que faz a requisição ajax para salvar no banco
* 
**/
$("#confirm").click(function(){
	form = $("#form");
	$.post(form.attr('action'), form.serialize(), function(){
		window.alert("Cadastro Salvo!");
		window.location = "/Trabalho";
	});
});

/**
* 
* Função para cancelar o processo e redirecionar para pagina inicial
* 
**/
$("#cancel").click(function(){
	if(window.confirm("Tem certeza que deseja cancelar?")){
		window.location = "/Trabalho";
	}
})
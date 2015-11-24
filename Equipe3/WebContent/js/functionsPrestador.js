$(document).ready(function()
{
	
	$('#PrestadoresTableContainer').jtable({
		title : 'Lista de Prestadores de Serviço',
        paging: true,
		pageSize: 10,
		sorting: true,
		defaultSorting: 'nome ASC',
		
		actions : {
            listAction : 	'ControllerPrestador?action=list',
            createAction : 	'ControllerPrestador?action=create',
            updateAction : 	'ControllerPrestador?action=update',
            deleteAction : 	'ControllerPrestador?action=delete'
		},
		fields : {
			nome : {
				title : 'Nome',
				width : '10%',
				edit : true
			},
			telefone : {
				title : 'Telefone',
				width : '10%',
				edit : true
			},
			cpf : {
				title : 'CPF',
				width : '10%',
				edit : true,
				key: true,
				create: true
			},
			servicos : {
				title : 'Serviços',
				width : '10%',
				edit : true
			},
			carteira : {
				title : 'Nº Carteira de Trabalho',
				width : '10%',
				edit : true
			},
			avaliacao : {
				title : 'Avaliação',
				width : '10%',
				edit : true,
				create: false
				}
			
		},
		//Initialize validation logic when a form is created
		formCreated : function(event, data)
		{
			data.form.find('input[name="nome"]').addClass('validate[required, custom[onlyLetterAccentSp]]');
			data.form.find('input[name="telefone"]').addClass('validate[required, minSize[11], maxSize[11], custom[phone]]');
			data.form.find('input[name="cpf"]').addClass('validate[required, custom[cpf]]');
            data.form.find('input[name="servicos"]').addClass('validate[required]');
            data.form.find('input[name="carteira"]').addClass('validate[required, minSize[7], maxSize[7], custom[onlyNumberSp]]');
            data.form.find('input[name="avaliacao"]').addClass('validate[required, min[0], max[100], custom[onlyNumberSp]]');
            
            data.form.find('input[name="nome"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="telefone"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="cpf"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="servicos"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="carteira"]').attr('data-prompt-position','topLeft:0,10');
            data.form.find('input[name="avaliacao"]').attr('data-prompt-position','topLeft:0,10');
            data.form.validationEngine();
		},
		//Validate form when it is being submitted
		formSubmitting : function(event, data)
		{
			return data.form.validationEngine('validate');
		},
		//Dispose validation logic when form is closed
		formClosed : function(event, data)
		{
			data.form.validationEngine('hide');
			data.form.validationEngine('detach');
		}
	});
	$('#PrestadoresTableContainer').jtable('load');
});
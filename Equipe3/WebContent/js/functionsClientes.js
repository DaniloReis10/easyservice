$(document).ready(function()
{

	$('#ClientTableContainer').jtable({
		title : 'Lista de Clientes',
        paging: true,
		pageSize: 10,
		sorting: true,
		defaultSorting: 'nome ASC',
		
		actions : {
			listAction : 'ControllerCliente?action=list',
			createAction : 'ControllerCliente?action=create',
			updateAction : 'ControllerCliente?action=update',
			deleteAction : 'ControllerCliente?action=delete'
		},
		fields : {
			nome : {
				title : 'Nome',
				width : '10%',
				edit : true
			},
			email : {
				title : 'Email',
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
			telefone : {
				title : 'Telefone',
				width : '10%',
				edit : true
			},
			endereco : {
				title : 'Endereço',
				width : '10%',
				edit : true
			},
			cep : {
				title : 'CEP',
				width : '10%',
				edit : true
			},
			numero : {
				title : 'Número',
				width : '10%',
				edit : true
			}
		},
		//Initialize validation logic when a form is created
		formCreated : function(event, data)
		{
			data.form.find('input[name="nome"]').addClass('validate[required, custom[onlyLetterAccentSp]]');
            data.form.find('input[name="email"]').addClass('validate[required, custom[email]]');
            data.form.find('input[name="cpf"]').addClass('validate[required, custom[cpf]]');
            data.form.find('input[name="telefone"]').addClass('validate[required, minSize[11], maxSize[11], custom[phone]]');
            data.form.find('input[name="endereco"]').addClass('validate[required]');
            data.form.find('input[name="cep"]').addClass('validate[required, minSize[8], maxSize[8], custom[onlyNumberSp]]');
            data.form.find('input[name="numero"]').addClass('validate[required, custom[onlyNumberSp]]');
            
            data.form.find('input[name="nome"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="email"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="cpf"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="telefone"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="cep"]').attr('data-prompt-position','bottomLeft');
            data.form.find('input[name="numero"]').attr('data-prompt-position','topLeft:0,10');
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
	$('#ClientTableContainer').jtable('load');
});
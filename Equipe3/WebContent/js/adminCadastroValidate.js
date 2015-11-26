/**
 * 
 */

$('form').validate({
    rules: {
        nome: {
            minlength: 2,
            lettersonly: true,
            required: true
        },
        login: {
            minlength: 2,
            lettersonly: true,
            required: true
        },
        email: {
            email: true,
            required: true
        },
        
        senha: {
        	minlength: 4,
            required: true
        },
        
        senhanovamente: {
        	equalTo: "#senha",
        	minlength: 4,
            required: true
        },
        
    },
    
    messages:{
		nome:{
			required: "O campo nome é obrigatorio!",
			lettersonly: "Letras e espaços apenas!",
			minlength: "O campo nome deve conter no mínimo 2 caracteres!"
		},
		login: {
			required: "O campo login é obrigatorio!",
			lettersonly: "Letras e espaços apenas!",
			minlength: "O campo nome deve conter no mínimo 2 caracteres!"
		},
		email: {
			required: "O campo email é obrigatorio!",
			email: "O campo email deve conter um email válido!"
		},
		senha: {
			required: "O campo email é obrigatorio!",
			minlength: "O campo nome deve conter no mínimo 4 caracteres!"
		},
		senhanovamente: {
			required: "O campo email é obrigatorio!",
			minlength: "O campo nome deve conter no mínimo 4 caracteres!",
			equalTo: "Senha diferente!"
		},
	},
    
    highlight: function(element) {
        $(element).closest('.form-group').addClass('has-error');
    },
    unhighlight: function(element) {
        $(element).closest('.form-group').removeClass('has-error');
    },
    errorElement: 'span',
    errorClass: 'help-block',
    errorPlacement: function(error, element) {
        if(element.parent('.input-group').length) {
            error.insertAfter(element.parent());
        } else {
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
	  if(request.getAttribute("alert") != null)
	  {
		  str = request.getAttribute("alert").toString();
		  
		  if(str.equals("false"))
		  {
			  %> alert("Usuário já existente!");<%
		  }
	  }
	  %>
	   
}
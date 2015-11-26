/**
 * 
 */

function validName(input)
{
	var resp = /^[A-z ]+$/.test(input.value);
	if (resp == false)
	{
		input.value = "";
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}

function validEmail(input)
{
	var resp = /\S+@\S+\.\S+/.test(input.value);
	if (resp == false)
	{
		input.value = "";
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}

function validCpf(strCPF)
{
	var input = strCPF;
	strCPF = strCPF.value;
	var ret;
	var Soma;
	var Resto;
	Soma = 0;
	if (strCPF == "00000000000")
		ret = false;
	for (i = 1; i <= 9; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
	Resto = (Soma * 10) % 11;
	if ((Resto == 10) || (Resto == 11))
		Resto = 0;
	if (Resto != parseInt(strCPF.substring(9, 10)))
		ret = false;
	Soma = 0;
	for (i = 1; i <= 10; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
	Resto = (Soma * 10) % 11;
	if ((Resto == 10) || (Resto == 11))
		Resto = 0;
	if (Resto != parseInt(strCPF.substring(10, 11)))
		ret = false;
	else
	ret = true;
	
	if (ret == false)
	{
		input.value = "";
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}

function validTelefone(input)
{
	var ret = input.value.match(/\d/g).length===11;
	if (ret == false)
	{
		input.value = "";
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}

function validEndereco(input)
{
	if (input.value == "")
	{
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}

function validCep(cep){  
	
	var ret = false;
    var strcep = cep.value;  
    if(strcep != "")
	{  
        if (strcep.length != 8){  
            ret = false;
     	} 
		else
		{
			ret = true;
		}
    } 
	
	if (ret == false)
	{
		cep.value = "";
		$(cep).parent().addClass("has-error");

	} else
	{
		$(cep).parent().addClass("has-success");
	}
	      
}

function validNumero(input)
{
	if (input.value == "")
	{
		$(input).parent().addClass("has-error");

	} else
	{
		$(input).parent().addClass("has-success");
	}
}
  
function inputTextValidation()
{
	$(document).ready(function()
	{

		$("input[type=text]").wrap("<div class='form-group'></div>");
		$("input[type=number]").wrap("<div class='form-group'></div>");
		$("input[type=text]").bind('focus', function()
		{
			$(this).parent().removeClass("has-success has-error");
		});
		$("input[type=text]").addClass("form-control");

		$("[name^='nome']").blur(function()
		{
			validName(this);
		});
		$("[name^='email']").blur(function()
		{
			validEmail(this);
		});
		$("[name^='cpf']").blur(function()
		{
			validCpf(this);
		});
		
		$("[name^='telefone']").blur(function()
		{
			validTelefone(this);
		});
		
		$("[name^='endereco']").blur(function()
		{
			validEndereco(this);
		});
		
		$("[name^='cep']").blur(function()
		{
			validCep(this);
		});

		$("[name^='numero']").blur(function()
		{
			validNumero(this);
		});

	});
}

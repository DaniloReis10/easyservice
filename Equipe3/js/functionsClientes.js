$(document).ready(function()
		{
			/* A complex JSON example */

			var jsonContentComplex = [ {
				"index" : 1,
				"nome" : "Eric",
				"email" : "eric@gmail.com",
				"cpf" : "930.549.392-00",
				"telefone" : "85996180188",
				"endereco" : "Av. Rua Tal",
				"cep" : "60165230",
				"numero" : "455",
			}, {
				"index" : 2,
				"nome" : "Eric",
				"email" : "eric@gmail.com",
				"cpf" : "930.549.392-00",
				"telefone" : "85996180188",
				"endereco" : "Av. Rua Tal",
				"cep" : "60165230",
				"numero" : "455",
			} ];

			/* Activates the complete example */

			$('#example2').mounTable(jsonContentComplex, {

				/* The model class */

				model : '.mountable-model',

				/* No console messages */

				noDebug : false,

				/* Options to your new line button */

				addLine : {

					/* New line button selector */

					button : "#button2",

					/* Callback function */

					onClick : function(element)
					{
						console.log('Line added!');
						return true;
					}
				},

				/* Options to your delete line button */

				deleteLine : {

					/* Delete line button selector */

					button : ".mountable-remove-line-2",

					/* Callback function */

					onClick : function(element)
					{
						if (confirm("Você tem Certeza?"))
						{
							console.log('Line removed!');
							return true;
						}
					}

				}

			});

		});
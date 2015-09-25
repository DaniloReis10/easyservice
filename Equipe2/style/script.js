/**
* 
* Inicializa a variavel status como 'closed' para
* fazer um efeito toggle no menu principal
* 
**/
var status = "closed";
$("#menuButtonOpen").click(function(){
	if(status == "closed"){
		$("#menu").animate({left: "0px"}, 300);
		status = "opened";
	} else{
		$("#menu").animate({left: "-16.33%"}, 300);
		status = "closed";
	}
});

/**
* 
* Efeito do dropdown de dentro do menu principal
* 
**/
$("#dropdown-signin-button").click(function(){
	$("#dropdown-signin").toggle(300);
});

/**
* 
* Mascara para validar CPF
* 
**/
$("#cpf").mask("NNN.NNN.NNN-99", {
	translation: {
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});

/**
* 
* Mascara para validar data de nascimento
* 
**/
$("#dob").mask("NO/NO/9999", {
	translation: {
		N: {
			pattern: /[0-9]/, optional: false
		},
		O: {
			pattern: /[0-9]/, optional: true
		}
	}
});

/**
* 
* Mascara para validar CEP
* 
**/
$("#cep").mask("NNNNN-999", {
	translation: {
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});

/**
* 
* Mascara para validar telefone fixo
* 
**/
$("#fix_phone").mask("(N99) NNNN-9999", {
	translation: {
		N: {
			pattern: /[0-9]/, optional: false
		}
	}
});

/**
* 
* Mascara para validar telefone movel
* 
**/
$("#mobile_phone").mask("(N99) O NNNN-9999", {
	translation: {
		O: {
			pattern: /[0-9]/, optional: true
		},
		N: {
			pattern: /[0-9]/, optional: false
		}
	}
});

/**
* 
* Mascara para validar valor da hora trabalhada
* 
**/
$("#value").mask("#.##0,00", {reverse: true});

/**
* 
* Inicializa o angularJS
* 
**/
angular.module("view", []);
angular.module("view").controller("viewController", function($scope){

	/**
	* 
	* Função para verificar se as senhas informadas são iguais
	* 
	**/
	$scope.error = function(user){
		if(user && user.password && user.password_conf && !(user.password == user.password_conf)){
			$scope.errorPass = "has-error";
		} else {
			$scope.errorPass = "";
		}
	};

	/**
	* 
	* Função para validar email com REGEX
	* 
	**/
	$scope.emailValidate = function(user){
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(user && user.email){
			if(re.exec(user.email) === null){
				$scope.errorEmail = "has-error";
				window.alert("Informe um e-mail valido!");
			} else{
				$scope.errorEmail = "";
			}
		}
	};

	/**
	* 
	* Inicializa 'account_class' para ficar ativado como padrão
	* Inicializa botao back para não aparecer por padrão
	* 
	**/
	$scope.account_class = "active";
	$("#back").addClass("hide");

	/**
	* 
	* Função que altera as telas do cadastro
	* Define se os botoes next e back irão aparecer
	* 
	**/
	$scope.active = function(data){
		if(data == "account") {
			$scope.account_class = "active";
			$scope.professional_class = "";
			$scope.personal_class = "";
			$("#next").removeClass("hide");
			$("#back").addClass("hide");
		} else if (data == "professional") {
			$scope.account_class = "";
			$scope.professional_class = "active";
			$scope.personal_class = "";
			$("#next").removeClass("hide");
			$("#back").removeClass("hide");
		} else if (data == "personal") {
			$scope.account_class = "";
			$scope.professional_class = "";
			$scope.personal_class = "active";
			$("#next").addClass("hide");
			$("#back").removeClass("hide");
		}
	};

	/**
	* 
	* Função que passa para a próxima aba, se possivel
	* 
	**/
	$scope.next = function(){
		if($scope.account_class == "active"){
			$scope.active("professional");
		} else if($scope.professional_class == "active") {
			$scope.active('personal');
		}
	};

	/**
	* 
	* Função que retorna para a aba anterior, se possivel
	* 
	**/
	$scope.back = function(){
		if($scope.professional_class == "active"){
			$scope.active("account");
		} else if($scope.personal_class == "active"){
			$scope.active("professional");
		}
	};

	/**
	* 
	* Função que limpa todos os campos e variaveis
	* 
	**/
	$scope.clear = function(){
		$scope.user = "";
		$scope.errorEmail = "";
		$scope.errorPass = "";
	}


	/**
	* 
	* Função para salvar os dados via ajax
	* 
	**/
	$scope.save = function(){
		if(!$scope.user){
			window.alert("Nenhum dado foi preenchido!");
			return;
		}
		console.log($scope.user);
	}
});
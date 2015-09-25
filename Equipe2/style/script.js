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

$("#dropdown-signin-button").click(function(){
	$("#dropdown-signin").toggle(300);
});

$("#cpf").mask("NNN.NNN.NNN-NN", {
	translation: {
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});
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
$("#cep").mask("NNNNN-999", {
	translation: {
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});
$("#fix_phone").mask("(N99) 9999-9999", {
	translation: {
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});
$("#mobile_phone").mask("(N99) O 9999-9999", {
	translation: {
		O: {
			pattern: /[0-9]/, optional: true
		},
		N: {
			pattern: /[0-9]/, optional:false
		}
	}
});
$("#value").mask("#.##0,00", {reverse: true});

angular.module("view", []);
angular.module("view").controller("viewController", function($scope){
	$scope.disabled = function(user){
		if($scope.user){
			return false;
		}
		return true;
	};
	$scope.error = function(user){
		if(user && user.password && user.password_conf && !(user.password == user.password_conf)){
			$scope.errorPass = "has-error";
		} else {
			$scope.errorPass = "";
		}
	};
	$scope.emailValidate = function(user){
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(user && user.email){
			if(re.exec(user.email) === null){
				$scope.errorEmail = "has-error";
			} else{
				$scope.errorEmail = "";
			}
		}
	};
	$scope.account_class = "active";
	$("#back").addClass("hide");
	$scope.active = function(data){
		if(data == "account") {
			$scope.account_class = "active";
			$scope.professional_class = "";
			$scope.personal_class = "";
			$("#finish_footer_options").addClass("hide");
			$("#next").removeClass("hide");
			$("#back").addClass("hide");
		} else if (data == "professional") {
			$scope.account_class = "";
			$scope.professional_class = "active";
			$scope.personal_class = "";
			$("#finish_footer_options").addClass("hide");
			$("#next").removeClass("hide");
			$("#back").removeClass("hide");
		} else if (data == "personal") {
			$scope.account_class = "";
			$scope.professional_class = "";
			$scope.personal_class = "active";
			$("#finish_footer_options").removeClass("hide");
			$("#next").addClass("hide");
			$("#back").removeClass("hide");
		}
	};
	$scope.next = function(){
		if($scope.account_class == "active"){
			$scope.active("professional");
		} else if($scope.professional_class == "active") {
			$scope.active('personal');
		}
	};
	$scope.back = function(){
		if($scope.professional_class == "active"){
			$scope.active("account");
		} else if($scope.personal_class == "active"){
			$scope.active("professional");
		}
	};
	$scope.clear = function(){
		$scope.user = "";
		$scope.errorEmail = "";
		$scope.errorPass = "";
	}
});
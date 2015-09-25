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

$("#account").click(function(){
	$("#professional").removeClass("active");
	$("#content_professional").removeClass("active");
	$("#personal").removeClass("active");
	$("#content_personal").removeClass("active");

	$(this).addClass("active");
	$("#content_account").addClass("active");
});

$("#professional").click(function(){
	$("#account").removeClass("active");
	$("#content_account").removeClass("active");
	$("#personal").removeClass("active");
	$("#content_personal").removeClass("active");

	$(this).addClass("active");
	$("#content_professional").addClass("active");
});

$("#personal").click(function(){
	$("#account").removeClass("active");
	$("#content_account").removeClass("active");
	$("#professional").removeClass("active");
	$("#content_professional").removeClass("active");

	$(this).addClass("active");
	$("#content_personal").addClass("active");
});

$("#cpf").mask("999-999-999-99");
$("#dob").mask("99/99/9999");	
$("#cep").mask("99999-999");
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
			$scope.errorFlag = "has-error";
		} else {
			$scope.errorFlag = "";
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
	}
});
var os = new Array(
["1001","Paulo","2015-10-03","Pintura"], ["1002","Claudio","2015-10-10","Carpintaria"], 
["1003","Marcio","2015-10-13","Carpintaria"], ["1004","Maria","2015-10-18","Limpeza"], 
["1005","Zenaide","2015-10-09","Limpeza"], ["1006","Fabio","2015-10-24","Encanador"]
);


function carregaOS() {
	var x = document.getElementById("OS");
			
	for(var i = 0; i < os.length; i++) {
		var opt = os[i][0] + " " + os[i][1] + " " + os[i][2] + " " + os[i][3];
		var option = document.createElement("option");
		option.text = opt;
		option.value = os[i][0];
		x.add(option);
	}
}

function cancelaOS() {
	var x = document.getElementById("OS");
	
	x.remove(x.selectedIndex);
}

function finalizaOS() {
	//var x = document.getElementById("OS").value;  //x.selectedIndex faz o mesmo efeito.
	var x = document.getElementById("OS");
	
	x.remove(x.selectedIndex);
	
	//document.getElementById("questionario").innerHTML = "Questionário";
	//document.getElementById("q01").innerHTML = "1 - Qualidade do Seviço:";
	document.getElementById("q01p").style.display = "inline";
}
	
function salvar() {
	alert("Dados salvos com sucesso!");
}

function cancelar() {
	var x;
    if (confirm("Deseja realmente cancelar?") == true) {
        x = "You pressed OK!";
    } else {
        x = "You pressed Cancel!";
    }
}

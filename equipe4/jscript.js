/* Não funciona
window.onload = function {
	carregaServico();
} */
//Profissional, ranking, dia, servico.
var p = new Array(
["Paulo",3,"Pintura"], ["Claudio",4,"Carpintaria"], ["Marcio",3,"Carpintaria"], ["Maria",3,"Limpeza"], 
["Zenaide",4,"Limpeza"], ["Fabio",2,"Encanador"]
);

var ds = new Array (
["Paulo","2015-10-02"], ["Paulo","2015-10-05"],["Claudio","2015-10-10"],["Claudio","2015-10-12"],["Marcio","2015-10-14"],
["Maria","2015-10-16"],["Zenaide","2015-10-18"],["Fabio","2015-10-20"],["Fabio","2015-10-05"]
);

function limpaCampos() {
	document.getElementById("os").value = "1001";
}

function limpaCampos1() { 
	var valor_cookie = "1000";
	// verifica se o cookie "nome_visitante" existe
    var nome_cookie = getCookie("oServico"); document.getElementById("os").value = "Johnny";
    if(nome_cookie == null) {  //window.alert("O cookie nome_visitante não existe");
		document.cookie="oServico=1000";
		
	} else {  //window.alert("O cookie nome_visitante existe");
		valor_cookie = LerCookie("oServico");
		
	}
    document.cookie="oServico=" + valor_cookie;
	
	document.getElementById("os").value = valor_cookie;
	
} 

function LerCookie(strCookie)
{
    var strNomeIgual = strCookie + "=";
    var arrCookies = document.cookie.split(';');
 
    for(var i = 0; i < arrCookies.length; i++)
    {
        var strValorCookie = arrCookies[i];
        while(strValorCookie.charAt(0) == ' ')
        {
            strValorCookie = strValorCookie.substring(1, strValorCookie.length);
        }
        if(strValorCookie.indexOf(strNomeIgual) == 0)
        {
            return strValorCookie.substring(strNomeIgual.length, strValorCookie.length);
        }
    }
    return null;
}

function adicionaServico() {
			var x = document.getElementById("servico");
			var option = document.createElement("option");
			option.text = "Kiwi";
			x.add(option);
		}

function carregaServico() {
	var x = document.getElementById("servico");
	var options = ["Pintura", "Carpintaria", "Encanador", "Limpeza"]; 
			
	for(var i = 0; i < options.length; i++) {
		var opt = options[i];
		var option = document.createElement("option");
		option.text = opt;
		x.add(option);
	}
}

function carregaProfissionais() {
	var ini = document.getElementById("di").value;
	var fin = document.getElementById("df").value;
	
	var s = document.getElementById("servico").value;
	var x = document.getElementById("profissional");
	
	var prof = ""; 
	for(var i = 0; i < p.length; i++) { 
		if (s == p[i][2] ) {  //localizou profissional pelo serviço (campo[2]).
			//var opt = p[i][0];
						
			for (var k = 0; k < ds.length; k++) { 
				if (p[i][0]==ds[k][0]) { //localiza pelo nome.
					
					if ((ds[k][1]>ini) && (ds[k][1]<fin)) {
					//if (([k][1]>di) && (ds[k][1]<df)) { //localizou a data.
						opt = p[i][0] + " " + p[i][1] + "* " + ds[k][1]; //Adicionou nome, estrelas e data.
						//opt += ds[k][1];
						//document.getElementById("data_i").innerHTML = ds[0][1];
						var option = document.createElement("option");
						option.text = opt;
						x.add(option);
					} 
				}
				//var opd = d[k][1];
			}
			
			
		}
	} 
	
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

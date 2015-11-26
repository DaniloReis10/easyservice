<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>teste</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="css/tooplate_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.lightbox-0.5.css" rel="stylesheet" type="text/css" media="screen" /> 
</head>
<body>
<div id="tooplate_wrapper"><span id="top"></span>
	<div id="tooplate_header">
	    	<div id="site_title"><h1><a href="#">Personal Website</a></h1></div>

        <div id="tooplate_menu">
            <ul>
			                
                
            </ul>    	
        </div> <!-- end of tooplate_menu -->
		
        <div class="cleaner"></div>
    </div> <!-- end of header -->
    
    <div id="tooplate_main">
    	
    	<div class="content"><span id="home"></span>
    		<h2>Identifique-se</h2>
            <div class="cleaner h30"></div>
			
            <div class="col_w330 float_l">
            	<h3> Já é Cadastrado ?</h3>
	             <div id="contact_form">
                	<form method="post" name="contact" action="login"> 
	
						<label for="author">Login:</label> <input type="text" id="login" name="login" class="required input_field" /> 
						<div class="cleaner h10"></div> 
	
						<label for="email">Senha:</label> <input type="text" class="validate-email required input_field" name="senha" /> 
						<div class="cleaner h10"></div> 
					<button type="submit" class="submit_btn float_l">Logar</button>
	
						<input type="submit" value="Esqueci Minha Senha" id="esqueci" name="esqueci"class="submit_btn float_r" onclick="document.forms[0].action = 'esqueci_senha.jsp'; return true;"/>
					</form> 
                
                </div> 
			   
			   </div>
			
            <div class="col_w330 float_r">
                <h3>Ainda não é Cadastrado?</h3>
                <div id="contact_form">
                	<form method="post" name="contact" action="CadastroPessoaServlet" > 
	
						<label for="nome">* Nome: </label> <input type="text" id="nome" name="nome" class="required input_field" /> 
						<div class="cleaner h10"></div> 
						
						<label for="endereco">* Endereço:</label> <input type="text" id="endereco" name="endereco" class="required input_field" /> 
						<div class="cleaner h10"></div> 
						
						<label for="telefone">* Telefone:</label> <input type="text" id="telefone" name="telefone" onkeypress="mascara(this, '## #####-####')" class="required input_field" /> 
						<div class="cleaner h10"></div> 
						
						<label for="login">* Email:</label> <input type="text" id="email" name="email" class="required input_field" /> 
						<div class="cleaner h10"></div> 
	
						<label for="senha">* Senha:</label> <input type="password" class="validate-email required input_field" name="senha" id="senha" /> 
						<div class="cleaner h10"></div> 
	
						
						<input type="submit" NAME="submit" value="Enviar" onclick="valida_form()" class="submit_btn float_l">
	
						
	
					</form> 
                
                </div> 
			   
			   
            </div>
			
            <div class="cleaner h30"></div>
            <div class="cleaner"></div>
			
    	</div>
        <div class="content_bottom"></div>
        
      
       
              	
            
   
         
	
</div>
</div>
</body>
</html>
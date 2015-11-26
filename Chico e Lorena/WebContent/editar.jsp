<%@page import="servlet.PerfilServlet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar</title>

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
			    <li><a href="file:///C:/Users/Alysson/Desktop/trabalho/Nova%20pasta%20(4)/2028_personal/index.html"><span class="home"></span>Pagina Inicial</a></li>
                <li><a href="file:///C:/Users/Alysson/Desktop/trabalho/Nova%20pasta%20(4)/2028_personal/clientes.html"><span class="aboutus"></span>Clientes</a></li>
                <li><a href="file:///C:/Users/Alysson/Desktop/trabalho/Nova%20pasta%20(4)/2028_personal/editar.html"><span class="services"></span>Editar</a></li>
                        
                
            </ul>   	
        </div> <!-- end of tooplate_menu -->
		
        <div class="cleaner"></div>
    </div> <!-- end of header -->
    
    <div id="tooplate_main">
    	
    	<div class="content"><span id="home"></span>
    		<h2>Editar Perfil</h2>
            <div class="cleaner h30"></div>
			
            <div class="col_w330 float_l">
            	
	             <div id="contact_form">
                		<form method="post" name="contact" action="#" action="${pageContext.request.contextPath}/PerfilServlet"> 
	
						<label for="nome">* Nome: </label> <input type="text" id="nome" name="nome" class="required input_field" value="${teste}"/> 
						<div class="cleaner h10"></div> 
						
						<label for="endereco">* Endereço:</label> <input type="text" id="endereco" name="endereco" class="required input_field" /> 
						<div class="cleaner h10"></div> 
						
						<label for="telefone">* Telefone:</label> <input type="text" id="telefone" name="telefone" onkeypress="mascara(this, '## #####-####')" class="required input_field" /> 
						<div class="cleaner h10"></div> 
						
						<label for="login">* Email:</label> <input type="text" id="email" name="email" class="required input_field" /> 
						<div class="cleaner h10"></div> 
	
						<label for="senha">* Senha:</label> <input type="password" class="validate-email required input_field" name="senha" id="senha" /> 
						<div class="cleaner h10"></div> 
	
						
						<input TYPE="BUTTON" NAME="submit" value="Editar" onclick="valida_form()" class="submit_btn float_l">
	
						
	
					</form> 
                
                </div> 
			   
			   </div>
		
			
            <div class="cleaner h30"></div>
            <div class="cleaner"></div>
			
    	</div>
        <div class="content_bottom"></div>
        
      
       
              	
            
   
         
	
</div>
</body>
</html>
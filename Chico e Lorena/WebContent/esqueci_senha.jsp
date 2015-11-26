<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/tooplate_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.lightbox-0.5.css" rel="stylesheet" type="text/css" media="screen" /> 

<script type='text/javascript' src='js/jquery.min.js'></script>
<script type='text/javascript' src='js/jquery.scrollTo-min.js'></script>
<script type='text/javascript' src='js/jquery.localscroll-min.js'></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script> 

</head>
<body>

<div id="tooplate_wrapper"><span id="top"></span>
	<div id="tooplate_header">
	    	<div id="site_title"><h1><a href="#">Personal Website</a></h1></div>

         <!-- end of tooplate_menu -->
		
        <div class="cleaner"></div>
    </div> <!-- end of header -->
    
    <div id="tooplate_main">
    	
    	<div class="content"><span id="home"></span>
    		<h2>Recuperar Senha</h2>
            <div class="cleaner h30"></div>
			
            <div class="col_w330 float_l">
            	<div id="contact_form">
                	<form method="post" name="contact" action="EsqueciSenhaServlet"> 
	
								<label for="author">Email:</label> <input type="text" id="email" name="email" class="required input_field" /> 
						<div class="cleaner h10"></div> 
					
	
					
	
												<input type="submit" value="Enviar" id="esqueci" name="esqueci" class="submit_btn float_l" /> 
						<input type="submit" value="Voltar" id="voltar" name="voltar"class="submit_btn float_r" onclick="document.forms[0].action = 'index.jsp'; return true;"/>

	
					</form> 
			   
			   </div>
			
            <div class="col_w330 float_r">
                
                
                </div> 
			   
			   
            </div>
			
            <div class="cleaner h30"></div>
            <div class="cleaner"></div>
			
    	</div>
        <div class="content_bottom"></div>
        
      
       
              	
            
   
         
	
</div>


</body>
</html>
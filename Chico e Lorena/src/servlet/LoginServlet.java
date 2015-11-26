package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
	        String meuHtml = "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
	                         "<head><title>Desenvolvimento Aberto</title></head>" +
	                         "<body>" +
	                         "<h1>Desenvolvimento Aberto</h1> <br />" +
	                         "<h3>Java - Servlet - doGet</h3>" +
	                         "Pagina criada pelo metodo do Servlet <br />" +
	 
	                         // Para que o método post seja disparado
	                         // o form precisa saber o método - method="post"
	                         // também funciona com o metodo get
	 
	                         "<form action=\"MeuServlet\" method=\"post\"> <br />" +
	                         "<input type=\"submit\" value=\"Enviar\">" +
	                         "</form>" +
	                         "</body>" +
	                         "</html>";
	 
	        PrintWriter imprimir = response.getWriter();
	 
	        imprimir.println(meuHtml);      
	 
	        // Recupera Parametros da URL
	 
	        String parametro = request.getParameter("Parametro1");  
	 
	        if (parametro != null )
	        {
	            imprimir.println("O parametro digitado foi: " + parametro);
	        }
	 
	    }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
	        PrintWriter imprimir = response.getWriter();
	 
	        imprimir.println("Método POST foi disparado!");
	    }
}

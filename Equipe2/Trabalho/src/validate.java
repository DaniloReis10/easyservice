

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		* 
		* Instancia as senhas para serem verificadas
		* 
		**/
		String pass = request.getParameter("password");
		String pass_c = request.getParameter("password_conf");
		
		/**
		* 
		* Verifica a senha
		* 
		**/
		if((pass != "") && (pass.length() > 5) && (pass.equals(pass_c))){
			/**
			* 
			* Redireciona para o arquivo JSP
			* 
			**/
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			/**
			* 
			* Redireciona para o arquivo index
			* 
			**/
			request.getRequestDispatcher("index.html").forward(request, response);;
		}
	}

}

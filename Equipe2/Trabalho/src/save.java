

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class save
 */
@WebServlet("/save")
public class save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		* 
		* Instancia todos os valores
		* 
		**/
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("name");
		String sobrenome = request.getParameter("surname");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String profissao = request.getParameter("profession");
		String prcHora = request.getParameter("value");
		String telFixo = request.getParameter("fix_phone");
		String telMovel = request.getParameter("mobile_phone");
		String nascimento = request.getParameter("dob");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("addres");
		String complemento = request.getParameter("addres_details");
		String cep = request.getParameter("postal_code");
		
		/**
		* 
		* Referencia uma conexão com o banco
		* 
		**/
		Connection conn;
		
		/**
		* 
		* Referencia um statement
		* 
		**/
		Statement stmt;
		
		try {
			/**
			* 
			* Cria conexão com banco
			* 
			**/
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/trabalho", "root", "");
			stmt = conn.createStatement();
			/**
			* 
			* Executa a query para inserir os dados instanciados na tabela do banco
			* 
			**/
			stmt.executeUpdate("INSERT INTO `users` (`id`, `name`, `surname`, `email`, `password`, `profession`, `value`, `fix_phone`, `mobile_phone`, `dob`, `cpf`, `addres`, `postal_code`, `addres_details`) VALUES (NULL, '"+nome+"', '"+sobrenome+"', '"+email+"', md5('"+pass+"'), '"+profissao+"', '"+prcHora+"', '"+telFixo+"', '"+telMovel+"', '"+nascimento+"', '"+cpf+"', '"+endereco+"', '"+cep+"', '"+complemento+"')");
			
			/**
			* 
			* Encerra o statement
			* 
			**/
			stmt.close();
		} catch (ClassNotFoundException e){
			/**
			* 
			* Retorna erro de Driver
			* 
			**/
			out.println("Erro no driver: "+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e){
			/**
			* 
			* Retorna erro de SQL
			* 
			**/
			out.println("Erro no DB: "+e.getMessage());
			e.printStackTrace();
		}
	}

}

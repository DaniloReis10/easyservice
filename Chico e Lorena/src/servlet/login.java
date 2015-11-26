package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;

/**
 * Servlet implementation class Teste
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		PessoaDAO pessoaDAO = new PessoaDAO();

		boolean resposta = pessoaDAO.verificaLogin(login, senha);

		if (resposta) {
			boolean respostasenha = pessoaDAO.verificaSenha(login, senha);
			if (respostasenha) {
				response.sendRedirect("bemvindo.jsp");

			} else {
				response.sendRedirect("erro_login.jsp");

			}
		}else{
			response.sendRedirect("index.jsp");

		}

	}

}

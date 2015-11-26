package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PessoaDAO;
import model.Pessoa;
import util.JavaMailApp;

/**
 * Servlet implementation class EsqueciSenhaServlet
 */
@WebServlet("/EsqueciSenhaServlet")
public class EsqueciSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EsqueciSenhaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = gerarSenha().replace("-", "");
		JavaMailApp mail = new JavaMailApp();
		Pessoa pessoa = buscarPessoa(email);
		atualizarSenha(pessoa.getId(), senha);
		mail.enviar(email, "Ola "+ pessoa.getNome()+" sua nova senha eh : " + senha);
	}

	public String gerarSenha() {
		Random gerador = new Random();
		return String.valueOf(gerador.nextInt());
	}

	public Pessoa buscarPessoa(String email) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.buscarPorEmail(email);
	}
	public void atualizarSenha(Integer id,String novaSenha){
		PessoaDAO pessoaDAO = new PessoaDAO();
	pessoaDAO.atualizaEmailPessoa(id, novaSenha);
	}

}

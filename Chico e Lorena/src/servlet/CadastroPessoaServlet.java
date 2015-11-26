package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class CadastroPessoaServlet
 */
@WebServlet("/CadastroPessoaServlet")
public class CadastroPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String nome = request.getParameter("nome");
	String endereco = request.getParameter("endereco");
	String senha = request.getParameter("senha");
	String telefone = request.getParameter("telefone");
	String email = request.getParameter("email");
	
	Pessoa p = new Pessoa();
		p.setNome(nome);
		p.setEndereco(endereco);
		p.setSenha(senha);
		p.setTelefone(telefone);
		p.setEmail(email);
	
	PessoaDAO pessoaDAO = new PessoaDAO();
	pessoaDAO.salvar(p);
	response.sendRedirect("perfil.jsp");

	
	}

}

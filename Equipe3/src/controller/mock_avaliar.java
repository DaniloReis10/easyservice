package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrestadorDAO;
import jdbc.DBUtility;
import model.Prestador;

/**
 * Servlet implementation class login
 */
@WebServlet("/mock_avaliar")
public class mock_avaliar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrestadorDAO dao;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public mock_avaliar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		DBUtility.getConnection();
		
		dao = new PrestadorDAO();
		
		RequestDispatcher requestDispatcher;
		List<Prestador> prestadorList = new ArrayList<Prestador>();
		
		prestadorList = dao.getAllPrestadores("NOME", "0");
		
		request.setAttribute("prestador", prestadorList.get(0));
		request.setAttribute("servico", "Cozinheiro");
		
		requestDispatcher = request.getRequestDispatcher("/avaliarServico.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*String action = request.getParameter("action");
		List<Prestador> prestadorList = new ArrayList<Prestador>();
		
		if (action.equals("updateRating"))
		{
			prestadorList = dao.getAllPrestadores("NOME", "0");
			Prestador prestador = prestadorList.get(0);
			int avaliacao = prestadorList.get(0).getAvaliacao();
			int qualidade = Integer.parseInt(request.getParameter("star1"));
			int comunicacao = Integer.parseInt(request.getParameter("star2"));
			int limpeza = Integer.parseInt(request.getParameter("star3"));
			int preco = Integer.parseInt(request.getParameter("star4"));

			int media = (((qualidade + comunicacao + limpeza + preco) * 100) / 4);
			avaliacao = (avaliacao + media) / 2;

			prestador.setAvaliacao(avaliacao);
			dao.updatePrestador(prestador);

		}*/
		doGet(request, response);
		
	}

}

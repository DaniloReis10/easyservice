package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.PrestadorDAO;
import model.Prestador;

/**
 * Servlet implemetation to Prestador model.
 * It is used to create, list, update and delete a Prestador model from database.
 * @author Eric
 * @version %I%, %G%
 */
public class ControllerPrestador extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	private PrestadorDAO dao;
	RequestDispatcher requestDispatcher;

	public ControllerPrestador()
	{
		dao = new PrestadorDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String action = request.getParameter("action");
		List<Prestador> prestadorList = new ArrayList<Prestador>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		

		if (action != null)
		{
			try
			{

				if (action.equals("list"))
				{
					int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
					int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));
					String orderBy = request.getParameter("jtSorting");
					String col[] = orderBy.split(" ");
					String newOrderBy = "\""+col[0]+"\" "+col[1];
					
					// Fetch Data from Student Table
					prestadorList = dao.getAllPrestadores(startPageIndex, recordsPerPage, newOrderBy);
					
					int userCount = dao.getPrestadorCount();
					
					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", prestadorList);
					JSONROOT.put("TotalRecordCount", userCount);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				} else if (action.equals("create") || action.equals("update"))
				{
					Prestador prestador = new Prestador();

					if (request.getParameter("nome") != null)
					{
						String nome = request.getParameter("nome");
						prestador.setNome(nome);
					}

					if (request.getParameter("cpf") != null)
					{
						String cpf = request.getParameter("cpf");
						prestador.setCpf(cpf);
					}

					if (request.getParameter("servicos") != null)
					{
						String servicos = request.getParameter("servicos");
						prestador.setServicos(servicos);
					}

					if (request.getParameter("carteira") != null)
					{
						String carteira = request.getParameter("carteira");
						prestador.setCarteira(carteira);
					}

					if (request.getParameter("avaliacao") != null)
					{
						int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));
						prestador.setAvaliacao(avaliacao);
					}
					else
					{
						prestador.setAvaliacao(20);
					}
					
					if (request.getParameter("telefone") != null)
					{
						String telefone = request.getParameter("telefone");
						prestador.setTelefone(telefone);
					}

					if (action.equals("create"))
					{
						// Create new record
						dao.addPrestador(prestador);
					} else if (action.equals("update"))
					{
						// Update existing record
						dao.updatePrestador(prestador);
					}

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Record", prestador);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					response.getWriter().print(jsonArray);
				}

				else if (action.equals("delete"))
				{
					// Delete record
					if (request.getParameter("cpf") != null)
					{
						String prestadorCpf = request.getParameter("cpf");
						dao.deletePrestador(prestadorCpf);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
				}
				
				else if(action.equals("updateRating"))
				{
					prestadorList = dao.getAllPrestadores("NOME", "0");
					Prestador prestador = prestadorList.get(0);
					int avaliacao =  prestadorList.get(0).getAvaliacao();
					int qualidade = Integer.parseInt(request.getParameter("star1"));
					int comunicacao = Integer.parseInt(request.getParameter("star2"));
					int limpeza = Integer.parseInt(request.getParameter("star3"));
					int preco = Integer.parseInt(request.getParameter("star4"));
					
					float media = (((qualidade + comunicacao + limpeza + preco))/4);
					avaliacao = (avaliacao + (int)media)/2;
					
					prestador.setAvaliacao(avaliacao);
					dao.updatePrestador(prestador);
					
					request.setAttribute("alert", "false");
					requestDispatcher = request.getRequestDispatcher("/ranking.jsp");
					requestDispatcher.forward(request, response);
					
				}
			} catch (Exception ex)
			{
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", ex.getMessage());
				String error = gson.toJson(JSONROOT);
				response.getWriter().print(error);
			}
		}
	}
}

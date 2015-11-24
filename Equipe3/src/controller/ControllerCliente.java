package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.ClienteDAO;
import model.Cliente;

/**
 * Servlet implemetation to Cliente model.
 * It is used to create, list, update and delete a Cliente model from database.
 * @author Eric
 * @version %I%, %G%
 */
public class ControllerCliente extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	private ClienteDAO dao;

	/**
	 * Init the Cliente DAO.
	 */
	public ControllerCliente()
	{
		dao = new ClienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String action = request.getParameter("action");
		List<Cliente> clienteList = new ArrayList<Cliente>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");

		if (action != null)
		{
			try
			{

				// Check is a list request
				if (action.equals("list"))
				{
					// Get parameters to sorting and paging features.
					int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
					int recordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));
					String orderBy = request.getParameter("jtSorting");
					String col[] = orderBy.split(" ");
					String newOrderBy = "\""+col[0]+"\" "+col[1];
					int userCount = 0;
					
					clienteList = dao.getAllClientes(startPageIndex, recordsPerPage, newOrderBy);
					
					// Get Cliente number from database.
					userCount = dao.getClienteCount();
					
					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", clienteList);
					JSONROOT.put("TotalRecordCount", userCount);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				
					// Check if is a create or update request
				} else if (action.equals("create") || action.equals("update"))
				{
					Cliente cliente = new Cliente();

					if (request.getParameter("nome") != null)
					{
						String nome = request.getParameter("nome");
						cliente.setNome(nome);
					}

					if (request.getParameter("email") != null)
					{
						String email = request.getParameter("email");
						cliente.setEmail(email);
					}

					if (request.getParameter("cpf") != null)
					{
						String cpf = request.getParameter("cpf");
						cliente.setCpf(cpf);
					}

					if (request.getParameter("telefone") != null)
					{
						String telefone = request.getParameter("telefone");
						cliente.setTelefone(telefone);
					}

					if (request.getParameter("endereco") != null)
					{
						String endereco = request.getParameter("endereco");
						cliente.setEndereco(endereco);
					}

					if (request.getParameter("cep") != null)
					{
						String cep = request.getParameter("cep");
						cliente.setCep(cep);
					}

					if (request.getParameter("numero") != null)
					{
						String numero = request.getParameter("numero");
						cliente.setNumero(numero);
					}

					if (action.equals("create"))
					{
						// Create new record
						dao.addCliente(cliente);
					} else if (action.equals("update"))
					{
						// Update existing record
						dao.updateCliente(cliente);
					}

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Record", cliente);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					response.getWriter().print(jsonArray);
				}

				else if (action.equals("delete"))
				{
					// Delete record
					if (request.getParameter("cpf") != null)
					{
						String clienteCpf = request.getParameter("cpf");
						
						// Delete from database
						dao.deleteCliente(clienteCpf);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
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

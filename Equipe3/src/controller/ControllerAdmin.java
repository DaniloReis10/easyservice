package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.DBUtility;

/**
 * Servlet implementation class login
 * @author Eric
 * @version 1.0.4
 * 
 */
@WebServlet("/ControllerAdmin")
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection dbConnection;
	private PreparedStatement pStmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		dbConnection = DBUtility.getConnection();
		RequestDispatcher requestDispatcher;
		HttpSession session = request.getSession();

		// Check if is a login request
		if (request.getParameter("action").equals("login"))
		{
			String login = request.getParameter("loginAdmin");
			String query = "SELECT * from \"ADMIN\" WHERE \"LOGIN\" = '" + login + "'";

			try
			{
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				// Check if the Login doesn't exists.
				if (!rs.next())
				{
					request.setAttribute("alert", "false");
					requestDispatcher = request.getRequestDispatcher("/adminLogin.jsp");
					requestDispatcher.forward(request, response);
				} 
				
				// If exists, checks the password
				else
				{
					String senha = rs.getString("SENHA");
					String senhadigitada = request.getParameter("passwordAdmin");

					// If the password is equal
					if (senha.equals(senhadigitada))
					{
						session.setAttribute("admin", rs.getString("LOGIN"));
						requestDispatcher = request.getRequestDispatcher("/adminMain.jsp");
						requestDispatcher.forward(request, response);
					} 
					// Invalid Password
					else
					{
						request.setAttribute("alert", "false");
						requestDispatcher = request.getRequestDispatcher("/adminLogin.jsp");
						requestDispatcher.forward(request, response);
					}

				}
			} catch (SQLException e)
			{
				System.err.println(e.getMessage());
			}
		}
		
		// Check if is a register request
		if (request.getParameter("action").equals("cadastro"))
		{
			
			String login = request.getParameter("login");
			String query = "SELECT * from \"ADMIN\" WHERE \"LOGIN\" = '" + login + "'";

			try
			{
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				String operador = request.getParameter("operador");
				String administrador = request.getParameter("administrador");

				// Check if the login exists.
				if (!rs.next())
				{
					String insertQuery = "INSERT INTO \"ADMIN\"(\"NOME\", \"EMAIL\", \"LOGIN\", \"SENHA\","
							+ "\"OPERADOR\", \"ADMINISTRADOR\") VALUES (?,?,?,?,?,?)";
					try
					{
						pStmt = dbConnection.prepareStatement(insertQuery);
						pStmt.setString(1, request.getParameter("nome"));
						pStmt.setString(2, request.getParameter("email"));
						pStmt.setString(3, request.getParameter("login"));
						pStmt.setString(4, request.getParameter("senha"));
						
						if (operador == null)
						{
							pStmt.setString(5, "false");
						}
						else
						{
							pStmt.setString(5, "true");
						}
						
						if (administrador == null)
						{
							pStmt.setString(6, "false");
						}
						else
						{
							pStmt.setString(6, "true");
						}
						pStmt.executeUpdate();

						// Redirect to adminLogin.jsp
						request.setAttribute("login", "true");
						requestDispatcher = request.getRequestDispatcher("/adminLogin.jsp");
						requestDispatcher.forward(request, response);
					}

					catch (java.sql.SQLException e)
					{
						System.err.println(e.getMessage());
					}

				}
				
				// The login already exists
				else
				{
					// Redirect to adminCadastro.jsp
					request.setAttribute("alert", "false");
					requestDispatcher = request.getRequestDispatcher("/adminCadastro.jsp");
					requestDispatcher.forward(request, response);

				}
			} catch (SQLException e)
			{
				System.err.println(e.getMessage());
			}
		}
		
		// Check is a exit request
		if (request.getParameter("action").equals("sair"))
		{
			session.setAttribute("login", "false");
			requestDispatcher = request.getRequestDispatcher("/adminLogin.jsp");
			requestDispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

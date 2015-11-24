package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtility;
import model.Cliente;
/**
 * This class implements the communication of Cliente model with the database.
 * 
 * @author Eric
 * @version 1.0.0
 */
public class ClienteDAO
{

	private Connection dbConnection;
	private PreparedStatement pStmt;

	public ClienteDAO()
	{
		dbConnection = DBUtility.getConnection();
	}

	/**
	 * Add a Cliente model into database.
	 * @param cliente Cliente to add.
	 */ 
	public void addCliente(Cliente cliente)
	{
		String insertQuery = "INSERT INTO \"CLIENTES\"(\"NOME\", \"EMAIL\", \"CPF\", \"TELEFONE\","
				+ "\"ENDERECO\", \"CEP\", \"NUMERO\") VALUES (?,?,?,?,?,?,?)";
		try
		{
			pStmt = dbConnection.prepareStatement(insertQuery);
			pStmt.setString(1, cliente.getNome());
			pStmt.setString(2, cliente.getEmail());
			pStmt.setString(3, cliente.getCpf());
			pStmt.setString(4, cliente.getTelefone());
			pStmt.setString(5, cliente.getEndereco());
			pStmt.setString(6, cliente.getCep());
			pStmt.setString(7, cliente.getNumero());
			pStmt.executeUpdate();
		} catch (java.sql.SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 * This method prepare a statement to get all existing Cliente model.
	 * @return a List of Cliente model.
	 */
	public List<Cliente> getAllClientes()
	{
		List<Cliente> clientes = new ArrayList<Cliente>();

		String query = "SELECT * FROM \"CLIENTES\" ORDER BY \"NOME\"";
		System.out.println(query);
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				Cliente cliente = new Cliente();

				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setTelefone(rs.getString("TELEFONE"));
				cliente.setEndereco(rs.getString("ENDERECO"));
				cliente.setCep(rs.getString("CEP"));
				cliente.setNumero(rs.getString("NUMERO"));
				clientes.add(cliente);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return clientes;
	}

	/**
	 * This method is used to paging,sorting and ordination features used in the jtable.
	 * @param startPageIndex Index page to start
	 * @param recordsPerPage Number of records to show
	 * @param orderBy	Column to order by.
	 * @return a List of Cliente model.
	 */
	public List<Cliente> getAllClientes(int startPageIndex, int recordsPerPage, String orderBy)
	{
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		String query = "SELECT * from \"CLIENTES\" ORDER BY "+orderBy.toUpperCase()+" LIMIT " + recordsPerPage + " OFFSET " + startPageIndex;
		System.out.println(query);

		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				Cliente cliente = new Cliente();

				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setTelefone(rs.getString("TELEFONE"));
				cliente.setEndereco(rs.getString("ENDERECO"));
				cliente.setCep(rs.getString("CEP"));
				cliente.setNumero(rs.getString("NUMERO"));
				clientes.add(cliente);
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return clientes;
	}

	/**
	 * Update a existing Cliente model.
	 * @param cliente Cliente to update.
	 */
	public void updateCliente(Cliente cliente)
	{
		String updateQuery = "UPDATE \"CLIENTES\" SET \"NOME\" = ?, \"EMAIL\" = ?, \"TELEFONE\" = ?,"
				+ "\"ENDERECO\" = ?, \"CEP\" = ?, \"NUMERO\" = ? WHERE \"CPF\" = ?";
		try
		{
			pStmt = dbConnection.prepareStatement(updateQuery);
			pStmt.setString(1, cliente.getNome());
			pStmt.setString(2, cliente.getEmail());
			pStmt.setString(3, cliente.getTelefone());
			pStmt.setString(4, cliente.getEndereco());
			pStmt.setString(5, cliente.getCep());
			pStmt.setString(6, cliente.getNumero());
			pStmt.setString(7, cliente.getCpf());
			pStmt.executeUpdate();

		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Delete a Cliente model from database, using the cpf primary key.
	 * @param cpf It is the primary key used to delete from database.
	 */
	public void deleteCliente(String cpf)
	{
		String deleteQuery = "DELETE FROM \"CLIENTES\" WHERE \"CPF\" = ?";
		try
		{
			pStmt = dbConnection.prepareStatement(deleteQuery);
			pStmt.setString(1, cpf);
			pStmt.executeUpdate();
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * It is used to get the Cliente model number.
	 * @return The Cliente model number into database.
	 */
	public int getClienteCount()
	{
		int count = 0;
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM \"CLIENTES\"");
			while (rs.next())
			{
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return count;
	}

}

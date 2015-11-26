package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtility;
import model.Prestador;

/**
 * 
 * @author Eric
 * @version 1.0.0
 */
public class PrestadorDAO
{

	private Connection dbConnection;
	private PreparedStatement pStmt;

	/**
	 * Constructor from Prestador DAO.
	 */
	public PrestadorDAO()
	{
		dbConnection = DBUtility.getConnection();
	}

	/**
	 * 
	 * @param prestador The element that will be added.
	 */
	public void addPrestador(Prestador prestador)
	{
		String insertQuery = "INSERT INTO \"PRESTADORES\"(\"NOME\", "
				+ "\"TELEFONE\", \"CPF\", \"SERVICOS\", \"CARTEIRA\", \"AVALIACAO\") VALUES (?,?,?,?,?,?)";
		try
		{
			pStmt = dbConnection.prepareStatement(insertQuery);

			pStmt.setString(1, prestador.getNome());
			pStmt.setString(2, prestador.getTelefone());
			pStmt.setString(3, prestador.getCpf());
			pStmt.setString(4, prestador.getServicos());
			pStmt.setString(5, prestador.getCarteira());
			pStmt.setInt(6,prestador.getAvaliacao());
			pStmt.executeUpdate();
		} catch (java.sql.SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param byOrder Column to be order. 
	 * @param id The index offset to search in the database.
	 * @return Return a Prestador List.
	 */
	public List<Prestador> getAllPrestadores(String byOrder, String id)
	{
		List<Prestador> prestadores = new ArrayList<Prestador>();
		String query;
		
		if(byOrder.equals("AVALIACAO"))
		{
			query = "SELECT * FROM \"PRESTADORES\" ORDER BY \""+byOrder+"\" DESC LIMIT 1 OFFSET "+id;
				
		}
		else
		{
			query = "SELECT * FROM \"PRESTADORES\" ORDER BY \""+byOrder+"\"";
		}
			
		try
		{
			System.out.println(query);
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next())
			{
				Prestador prestador = new Prestador();
				prestador.setNome(rs.getString("NOME"));
				prestador.setCpf(rs.getString("CPF"));
				prestador.setTelefone(rs.getString("TELEFONE"));
				prestador.setServicos(rs.getString("SERVICOS"));
				prestador.setCarteira(rs.getString("CARTEIRA"));
				prestador.setAvaliacao(rs.getInt("AVALIACAO"));
				prestadores.add(prestador);

			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return prestadores;
	}

	/**
	 * 
	 * @param byOrder Column to be order. 
	 * @return A Prestador List.
	 */
	public List<Prestador> getAllPrestadores(String byOrder)
	{
		List<Prestador> prestadores = new ArrayList<Prestador>();
		String query;
		
		if(byOrder.equals("AVALIACAO"))
		{
			query = "SELECT * FROM \"PRESTADORES\" ORDER BY \""+byOrder+"\" DESC";
				
		}
		else
		{
			query = "SELECT * FROM \"PRESTADORES\" ORDER BY \""+byOrder+"\"";
		}
			
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next())
			{
				Prestador prestador = new Prestador();
				prestador.setNome(rs.getString("NOME"));
				prestador.setCpf(rs.getString("CPF"));
				prestador.setTelefone(rs.getString("TELEFONE"));
				prestador.setServicos(rs.getString("SERVICOS"));
				prestador.setCarteira(rs.getString("CARTEIRA"));
				prestador.setAvaliacao(rs.getInt("AVALIACAO"));
				prestadores.add(prestador);

			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return prestadores;
	}
	
	/**
	 * 
	 * @param startPageIndex A index to paging feature.
	 * @param recordsPerPage The number of Prestador to show in the jtable.
	 * @param orderBy	The column to order by. It is used to ordering the jtable.
	 * @return The Prestador List.
	 */
	public List<Prestador> getAllPrestadores(int startPageIndex, int recordsPerPage, String orderBy)
	{
		List<Prestador> prestadores = new ArrayList<Prestador>();
		
		String query = "SELECT * from \"PRESTADORES\" ORDER BY "+orderBy.toUpperCase()+" LIMIT " + recordsPerPage + " OFFSET " + startPageIndex;
		System.out.println(query);

		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next())
			{
				Prestador prestador = new Prestador();
				prestador.setNome(rs.getString("NOME"));
				prestador.setCpf(rs.getString("CPF"));
				prestador.setTelefone(rs.getString("TELEFONE"));
				prestador.setServicos(rs.getString("SERVICOS"));
				prestador.setCarteira(rs.getString("CARTEIRA"));
				prestador.setAvaliacao(rs.getInt("AVALIACAO"));
				prestadores.add(prestador);

			}
		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
		return prestadores;
	}
	
	/**
	 * 
	 * @param prestador The prestador element to be update in the database.
	 */
	public void updatePrestador(Prestador prestador)
	{
		String updateQuery = "UPDATE \"PRESTADORES\" SET \"NOME\" = ?,"
				+ " \"SERVICOS\" = ?, \"CARTEIRA\" = ?, \"AVALIACAO\" = ?, \"TELEFONE\" = ? " + "WHERE \"CPF\" = ?";
		try
		{
			pStmt = dbConnection.prepareStatement(updateQuery);
			pStmt.setString(1, prestador.getNome());
			pStmt.setString(2, prestador.getServicos());
			pStmt.setString(3, prestador.getCarteira());
			pStmt.setInt(4, prestador.getAvaliacao());
			pStmt.setString(5, prestador.getTelefone());
			pStmt.setString(6, prestador.getCpf());
			pStmt.executeUpdate();

		} catch (SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param cpf The primary key to be deleted in the database.
	 */
	public void deletePrestador(String cpf)
	{
		String deleteQuery = "DELETE FROM \"PRESTADORES\" WHERE \"CPF\" = ?";
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
	 * 
	 * @return The Prestador number into Prestador table in the database.
	 */
	public int getPrestadorCount()
	{
		int count = 0;
		try
		{
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM \"PRESTADORES\"");
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

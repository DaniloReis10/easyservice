package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Eric
 * @version 1.0.0
 */
public class DBUtility {
	private static Connection connection = null;

	/**
	 * 
	 * @return  The connection with the postgres database.
	 */
	public static Connection getConnection() {
		System.out.println("Conexão Inicializada");
		try {
			
			// Busca os paramâtros inicias da Servlet
			String driver = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost/easyService";
			String usuario = "postgres";
			String senha = "admin";
			
			// Registrando o driver utilizado para conexâo
			Class.forName(driver);
			// Abrindo uma conexão
			connection = DriverManager.getConnection(url, usuario, senha);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}
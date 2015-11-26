package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1
 * @author Alysson
 * Classes Responsavel pela conexao com o Banco de Dados
 */
 
public class Conexao {
	 final private String url = "jdbc:postgresql://localhost:5432/ti";  
	    final private String usuario = "postgres";  
	   final private String senha = "admin";  
	   	final private String driver = "org.postgresql.Driver";  
	   	private  Connection con;  
	   
	   	/**
	   	 * @author Lorena
	   	 * @return Objeto do Tipo Connectio, representando a conexao com o banco
	   	 */
	   	public Connection conecta() {  
	     try {  
	       Class.forName(driver);  
	     } catch (ClassNotFoundException cnfe) {  
	       System.out.println("Driver não encontrado!!");  
	       cnfe.printStackTrace();  
	     }  
	     try {  
	       con = DriverManager.getConnection(url, usuario, senha);  
	       //Conseguiu conectar...  
	     } catch (SQLException se) {  
	       System.out.println("Não foi possivel conectar");  
	       se.printStackTrace();  
	     }  
	     return con;  
	   } 
}

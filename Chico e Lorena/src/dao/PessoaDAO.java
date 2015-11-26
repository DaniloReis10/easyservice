package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pessoa;
/**
 * @version Classe para o Objeto pessoa referente a conexao com o banco de dados
 * @author Alysson
 *
 */
public class PessoaDAO {
	private Connection conexao;

	public PessoaDAO() {
		Conexao c = new Conexao();
		conexao = c.conecta();
	}
/**
 * 
 * @param String login
 * @param  String senha
 * @return boolean
 * @author Alysson
 * Verificar se exite um login com o nome que o usuario passado via parametro
 */
	public boolean verificaLogin(String login, String senha) {
		Statement sq_stmt = null;
		boolean existe = false;
		try {
			sq_stmt = conexao.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from pessoa where nome = '" + login +"'";

		ResultSet rs = null;
		try {
			rs = sq_stmt.executeQuery(sql);
			while (rs.next()) {
				existe = true;
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return existe;
	}
/**
 * 
 * @param login
 * @param senha
 * @return boolean
 * verificar se a senha é a do login digitado
 */
	public boolean verificaSenha(String login,String senha){
		Statement sq_stmt = null;
		boolean existe = false;
		String s = "";
		try {
			sq_stmt = conexao.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from pessoa where nome = '" + login +"'";

		ResultSet rs = null;
		try {
			rs = sq_stmt.executeQuery(sql);
			
			while (rs.next()) {
				 s = rs.getString("senha");
				
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(senha.equals(s)){
			existe = true;

		}

		return existe;
	}
	/**
	 * @author Lorena
	 * @param pessoa
	 * salvar um obejto pessoa no banco de dados
	 */
	public void salvar(Pessoa pessoa){
		Statement sq_stmt = null;
		boolean existe = false;
		String s = "";
		try {
			sq_stmt = conexao.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "insert into pessoa(nome,endereco,telefone,email,senha) values ('"+pessoa.getNome() + "','"
	+pessoa.getEndereco() +"','"
	+pessoa.getTelefone() + "','"
	+pessoa.getEmail() +"','"
	+pessoa.getSenha() + "')";
	
	try {
		sq_stmt.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	/**
	 * 
	 * @param email
	 * @return Pessoa
	 * buscar pessoa pelo seu email
	 */
	public Pessoa buscarPorEmail(String email){
		Pessoa pessoa = new Pessoa();
		Statement sq_stmt = null;
		try {
			sq_stmt = conexao.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from pessoa where email = '" + email +"'";

		ResultSet rs = null;
		try {
			rs = sq_stmt.executeQuery(sql);
			while (rs.next()) {
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoa;
	}
	
	/**
	 * 
	 * @param id
	 * @param novaSenha
	 * Atualizar a nova senha do usuario
	 */
	public void atualizaEmailPessoa(Integer id, String novaSenha){
		Statement sq_stmt = null;
		boolean existe = false;
		String s = "";
		try {
			sq_stmt = conexao.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "update pessoa set senha = "+novaSenha +" where id ="+id;
	
	try {
		sq_stmt.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
}

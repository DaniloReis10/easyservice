package model;

/**
 * 
 * @author Eric
 * @version 1.0.0
 */
public class Cliente {

	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private String endereco;
	private String cep;
	private String numero;
	
	public Cliente(String nome, String email, String cpf, String telefone, String endereco, String cep,
			String numero) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.numero = numero;
	}
	
	public Cliente() {
		super();
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}

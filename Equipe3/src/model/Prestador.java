package model;

public class Prestador {

	private String nome;
	private String telefone;
	private String cpf;
	private String servicos;
	private String carteira;
	private int avaliacao;

	public Prestador(String nome, String cpf, String telefone, String servicos, String carteira, int avaliacao)
	{
		super();
		this.nome = nome;
		this.telefone =  telefone;
		this.cpf = cpf;
		this.servicos = servicos;
		this.carteira = carteira;
		this.avaliacao = avaliacao;
	}

	public Prestador() {
		super();
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getServicos()
	{
		return servicos;
	}

	public void setServicos(String servicos)
	{
		this.servicos = servicos;
	}

	public String getCarteira()
	{
		return carteira;
	}

	public void setCarteira(String carteira)
	{
		this.carteira = carteira;
	}

	public int getAvaliacao()
	{
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao)
	{
		this.avaliacao = avaliacao;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

}

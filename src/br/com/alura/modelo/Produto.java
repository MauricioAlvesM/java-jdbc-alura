package br.com.alura.modelo;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}
	
}

package br.com.pearson.passaporte.test.api.dto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String identificadorAplicacao;
	
	public ProdutoDTO(Long id, String nome, String identificadorAplicacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.identificadorAplicacao = identificadorAplicacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdentificadorAplicacao() {
		return identificadorAplicacao;
	}
	public void setIdentificadorAplicacao(String identificadorAplicacao) {
		this.identificadorAplicacao = identificadorAplicacao;
	}
	
	

}

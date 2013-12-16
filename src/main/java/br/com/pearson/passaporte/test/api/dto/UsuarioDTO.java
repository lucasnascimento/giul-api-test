package br.com.pearson.passaporte.test.api.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
	
	private Long id;
	
	private String nome;

	private String login;
	
	private String password;
	
	private List<ClassificacaoDTO> classificacoes = new ArrayList<ClassificacaoDTO>();
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String nome, String login, String password) {
		super();
		this.nome = nome;
		this.login = login;
		this.password = password;
	}
	
	public void addClassificacao(ClassificacaoDTO classificacao) {
		classificacoes.add(classificacao);
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ClassificacaoDTO> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<ClassificacaoDTO> classificacoes) {
		this.classificacoes = classificacoes;
	}	
}
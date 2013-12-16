package br.com.pearson.passaporte.test.api.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

	private Long id;
	
	private String nome;
	
	private String dataNascimento;
	
	private String login;
	
	private String email;
	
	private String password;
	
	private String idExterno;
	
	private String nomeMae;
	
	private String nomePai;
	
	private String cpf;
	
	private String rg;
	
	private String outrosDoc;
	
	private String telefone;
	
	private String celular;
	
	private String observacoes;
	
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdExterno() {
		return idExterno;
	}

	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOutrosDoc() {
		return outrosDoc;
	}

	public void setOutrosDoc(String outrosDoc) {
		this.outrosDoc = outrosDoc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<ClassificacaoDTO> getClassificacoes() {
		return classificacoes;
	}

	public void setClassificacoes(List<ClassificacaoDTO> classificacoes) {
		this.classificacoes = classificacoes;
	}	
	
}

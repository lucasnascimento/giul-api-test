package br.com.pearson.passaporte.test.api.dto;

public class ClassificacaoDTO {

	private Long estrutra;
	private Long perfilEscola;
	private Long escola;
	
	public ClassificacaoDTO(Long estrutra, Long perfilEscola, Long escola) {
		super();
		this.estrutra = estrutra;
		this.perfilEscola = perfilEscola;
		this.escola = escola;
	}
	
	public Long getEstrutra() {
		return estrutra;
	}
	public void setEstrutra(Long estrutra) {
		this.estrutra = estrutra;
	}
	public Long getPerfilEscola() {
		return perfilEscola;
	}
	public void setPerfilEscola(Long perfilEscola) {
		this.perfilEscola = perfilEscola;
	}
	public Long getEscola() {
		return escola;
	}
	public void setEscola(Long escola) {
		this.escola = escola;
	}
	
}

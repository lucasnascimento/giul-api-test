package br.com.pearson.passaporte.test.api.dto;

public class ClassificacaoDTO {

	private ObjectId estrutura;
	private ObjectId perfilEscola;
	private ObjectId escola;
	
	public ClassificacaoDTO(Long estrutra, Long perfilEscola, Long escola) {
		super();
		this.estrutura = new ObjectId(estrutra);
		this.perfilEscola = new ObjectId(perfilEscola);
		this.escola = new ObjectId(escola);
	}

	public ObjectId getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(ObjectId estrutura) {
		this.estrutura = estrutura;
	}

	public ObjectId getPerfilEscola() {
		return perfilEscola;
	}

	public void setPerfilEscola(ObjectId perfilEscola) {
		this.perfilEscola = perfilEscola;
	}

	public ObjectId getEscola() {
		return escola;
	}

	public void setEscola(ObjectId escola) {
		this.escola = escola;
	}

	
}

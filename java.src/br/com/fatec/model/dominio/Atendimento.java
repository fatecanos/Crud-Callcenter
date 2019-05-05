package br.com.fatec.model.dominio;

public class Atendimento {
	
	private GrupoAtendimento grupo;
	private Chamado chamado;
	
	public Atendimento() {}
	
	public Atendimento(GrupoAtendimento grupo, Chamado chamado) {
		this.grupo = grupo;
		this.chamado = chamado;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public GrupoAtendimento getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAtendimento grupo) {
		this.grupo = grupo;
	}
}
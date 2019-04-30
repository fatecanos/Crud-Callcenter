package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Atendimento extends EntidadeDominio{
	private GrupoAtendentes grupo;
	private Chamado chamado;
	
	public Atendimento() {
		super();
	}
	
	public Atendimento(GrupoAtendentes grupo, Chamado chamado) {
		super();
		this.grupo = grupo;
		this.chamado = chamado;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public GrupoAtendentes getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAtendentes grupo) {
		this.grupo = grupo;
	}

	
	
	
}

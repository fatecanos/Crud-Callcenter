package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Conhecimento extends EntidadeDominio {
	
	private String nome;
	private String descricao;
	private String tags[];
	private Chamado chamado;
	private Usuario usuarioResponsavel;
	
	public Conhecimento() {
		super();
	}

	public Conhecimento(String nome, String descricao, String[] tags, Chamado chamado, Usuario usuarioResponsavel) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.tags = tags;
		this.chamado = chamado;
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
	
	
	
	
}
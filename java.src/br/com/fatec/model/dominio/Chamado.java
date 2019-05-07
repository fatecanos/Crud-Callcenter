package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Chamado extends EntidadeDominio {
	
	private String nome;
	private String descricao;
	private String dataInicio;
	private String dataFechamento;
	private DetalhesChamado detalhes = null;
	private GrupoAtendimento grupo;
	private Status status;
	private Categoria categoria;
	
	public GrupoAtendimento getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAtendimento grupo) {
		this.grupo = grupo;
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
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataFechamento() {
		return dataFechamento;
	}
	
	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public DetalhesChamado getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(DetalhesChamado detalhes) {
		this.detalhes = detalhes;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
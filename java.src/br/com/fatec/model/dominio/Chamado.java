package br.com.fatec.model.dominio;

import java.util.Date;

import br.com.fatec.model.EntidadeDominio;

public class Chamado extends EntidadeDominio{
	
	private String 			nome;
	private String 			descricao;
	private Date 			dataInicio;
	private Date 			dataFechamento;
	
	private DetalhesChamado detalhes;
	private Status 			status;
	private Categoria 		categoria;
	
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
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFechamento() {
		return dataFechamento;
	}
	
	public void setDataFechamento(Date dataFechamento) {
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

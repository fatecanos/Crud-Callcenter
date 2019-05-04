package br.com.fatec.model.dominio;

import java.util.List;

import br.com.fatec.model.EntidadeDominio;

public class Conhecimento extends EntidadeDominio{
	private String nome;
	private String descricao;
	private List<String> tags;
	
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
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	
}

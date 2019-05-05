package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class CategoriaInativacao extends EntidadeDominio {
	
	private String nome;
	
	public CategoriaInativacao() {}

	public CategoriaInativacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
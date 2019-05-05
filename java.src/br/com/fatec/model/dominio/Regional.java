package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Regional extends EntidadeDominio {	
	
	private String nome;
	
	public Regional() {}
	
	public Regional(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
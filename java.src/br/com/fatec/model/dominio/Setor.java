package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Setor extends EntidadeDominio {
	
	private String nome;
	private Regional regional;
	
	public Setor() {}
	
	public Setor(String nome, Regional regional) {
		this.nome = nome;
		this.regional = regional;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Regional getRegional() {
		return regional;
	}
	
	public void setRegional(Regional regional) {
		this.regional = regional;
	}
}
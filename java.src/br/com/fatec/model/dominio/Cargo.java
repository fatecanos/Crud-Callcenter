package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Cargo extends EntidadeDominio {
	
	private String nome;
	private Setor setor;
	
	public Cargo() {}
	
	public Cargo(int id, String nome, Setor setor) {
		super(id, true);
		this.nome = nome;
		this.setor = setor;
	}
	
	public Cargo(String nome, Setor setor) {
		this.nome = nome;
		this.setor = setor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
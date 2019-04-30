package br.com.fatec.model.dominio;

public class Cargo {
	private String nome;
	private Setor setor;
	
	public Cargo() {
		super();
	}
	public Cargo(String nome, Setor setor) {
		super();
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

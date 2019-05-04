package br.com.fatec.model;

public class EntidadeDominio {
	private int id;
	private boolean isAtivo;
	
	public EntidadeDominio() {
		
	}
	
	public EntidadeDominio(int id, boolean isAtivo) {
		this.id 		= id;
		this.isAtivo 	= isAtivo;
	}
	
	public int getId() {
		return id;
	}
	public boolean isAtivo() {
		return isAtivo;
	}
	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

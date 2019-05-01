package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Categoria extends EntidadeDominio{
	
	private String nome;
	
	private Subcategoria subCategoria; 
	
	public Categoria() {
		super();
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria(String nome, Subcategoria subCategoria) {
		super();
		this.nome = nome;
		this.subCategoria = subCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Subcategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(Subcategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
	
}

package br.com.fatec.model.dominio;

import java.util.Date;

import br.com.fatec.model.EntidadeDominio;

public class Subcategoria extends EntidadeDominio {
	
	private String nome;
	private Date prazoAtendimento;
<<<<<<< HEAD
	private Categoria categoria;	
	
	public Subcategoria() {
		super();
	}

	public Subcategoria(String nome, Date prazoAtendimento, Categoria categoria) {
		super();
=======
		
	public Subcategoria() {}

	public Subcategoria(String nome, Date prazoAtendimento) {
>>>>>>> f50fd7b3d62a5076f99b85061ef3b8aec4daff21
		this.nome = nome;
		this.prazoAtendimento = prazoAtendimento;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPrazoAtendimento() {
		return prazoAtendimento;
	}

	public void setPrazoAtendimento(Date prazoAtendimento) {
		this.prazoAtendimento = prazoAtendimento;
	}
<<<<<<< HEAD

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
}
=======
}
>>>>>>> f50fd7b3d62a5076f99b85061ef3b8aec4daff21

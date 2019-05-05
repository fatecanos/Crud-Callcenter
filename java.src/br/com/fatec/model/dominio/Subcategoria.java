package br.com.fatec.model.dominio;

import java.util.Date;

import br.com.fatec.model.EntidadeDominio;

public class Subcategoria extends EntidadeDominio {
	
	private String nome;
	private Date prazoAtendimento;
		
	public Subcategoria() {}

	public Subcategoria(String nome, Date prazoAtendimento) {
		this.nome = nome;
		this.prazoAtendimento = prazoAtendimento;
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
}
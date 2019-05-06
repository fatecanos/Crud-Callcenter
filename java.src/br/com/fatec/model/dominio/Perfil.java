package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Perfil extends EntidadeDominio{
	private String nome;
	private PerfilUsuario perfilUsuario;
	
	public Perfil(){}
	
	public Perfil(String nome, PerfilUsuario perfilUsuario) {
		super();
		this.nome = nome;
		this.perfilUsuario = perfilUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
	
}
	
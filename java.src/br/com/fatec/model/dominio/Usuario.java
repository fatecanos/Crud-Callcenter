package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class Usuario extends EntidadeDominio {
	
	private String nome;
	private String senha;
	private PerfilUsuario perfilUsuario;
	
	public Usuario() {}
	
	public Usuario(String nome, String senha, PerfilUsuario perfilUsuario) {
		this.nome = nome;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
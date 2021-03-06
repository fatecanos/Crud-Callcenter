package br.com.fatec.model.dominio;

import java.util.List;

import br.com.fatec.model.EntidadeDominio;

public class Usuario extends EntidadeDominio{
	private String nome;
	private String senha;
	private List<String> perfis;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String senha, List<String> perfis) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.perfis = perfis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<String> perfis) {
		this.perfis = perfis;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

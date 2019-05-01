package br.com.fatec.model.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fatec.model.EntidadeDominio;

@Entity
@Table(name="tbUsuarios")
public class Usuario extends EntidadeDominio{
	@Column(name = "nomeUsuario")
	private String nome;
	@Column(name = "senhaUsuario")
	private String senha;
	@Column(name = "perfisUsuario")
	private List<Perfil> perfis;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String senha, List<Perfil> perfis) {
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

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

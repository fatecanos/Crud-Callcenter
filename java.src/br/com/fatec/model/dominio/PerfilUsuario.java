package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class PerfilUsuario extends EntidadeDominio{
	private Perfil perfil;
	private Usuario usuario;
	
	public PerfilUsuario() {
		super();
	}

	public PerfilUsuario(Perfil perfil, Usuario usuario) {
		super();
		this.perfil = perfil;
		this.usuario = usuario;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}

package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class FuncionarioGrupo extends EntidadeDominio{
	private GrupoAtendimento grupo;
	private Funcionario funcionario;
	
	public FuncionarioGrupo() {
		
	}
	
	public FuncionarioGrupo(GrupoAtendimento grupo, Funcionario funcionario) {
		super();
		this.grupo = grupo;
		this.funcionario = funcionario;
	}

	public GrupoAtendimento getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAtendimento grupo) {
		this.grupo = grupo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}

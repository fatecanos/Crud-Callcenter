package br.com.fatec.model.dominio;

import br.com.fatec.model.EntidadeDominio;

public class GrupoAtendimento extends EntidadeDominio {
	
	private String nome;
	private FuncionarioGrupo funcionarioGrupo;
	
	public GrupoAtendimento() {}
	
	public GrupoAtendimento(String nome, FuncionarioGrupo funcionarioGrupo) {
		this.nome = nome;
		this.funcionarioGrupo = funcionarioGrupo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public FuncionarioGrupo getFuncionarioGrupo() {
		return funcionarioGrupo;
	}

	public void setFuncionarioGrupo(FuncionarioGrupo funcionarioGrupo) {
		this.funcionarioGrupo = funcionarioGrupo;
	}
}
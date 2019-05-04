package br.com.fatec.model.dominio;

import java.util.List;

import br.com.fatec.model.EntidadeDominio;

public class GrupoAtendentes extends EntidadeDominio{
	private String nome;
	private List<Funcionario> funcionarios;
	
	public GrupoAtendentes() {
		super();
	}
	
	public GrupoAtendentes(String nome, List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.setFuncionarios(funcionarios);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}

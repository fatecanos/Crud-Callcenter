package br.com.fatec.model.dominio;

import java.util.Date;

public class Funcionario extends Usuario{
	private Date dataContratacao;
	private Integer matricula;
	private String nome;
	private String cpf;
	private String email;
	
	private Cargo cargo;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Date dataContratacao, Integer matricula, String nome, String cpf, String email, Cargo cargo) {
		super();
		this.dataContratacao = dataContratacao;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}

package br.com.fatec.model.dominio;

import java.util.Date;

import br.com.fatec.model.EntidadeDominio;

public class Funcionario extends EntidadeDominio {
	
	private Date dataContratacao;
	private Integer matricula;
	private String nome;
	private String cpf;
	private String email;
	private FuncionarioGrupo funcionarioGrupo;
	private CategoriaInativacao categoriaInativacao;
	private Usuario responsavelCadastro;
	private Usuario contaDeUsuario;
	private Cargo cargo;
	
	public Funcionario() {}
	
	

	public Funcionario(Date dataContratacao, Integer matricula, String nome, String cpf, String email,
			FuncionarioGrupo funcionarioGrupo, CategoriaInativacao categoriaInativacao, Usuario responsavelCadastro,
			Usuario contaDeUsuario, Cargo cargo) {
		super();
		this.dataContratacao = dataContratacao;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.funcionarioGrupo = funcionarioGrupo;
		this.categoriaInativacao = categoriaInativacao;
		this.responsavelCadastro = responsavelCadastro;
		this.contaDeUsuario = contaDeUsuario;
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

	public FuncionarioGrupo getFuncionarioGrupo() {
		return funcionarioGrupo;
	}

	public void setFuncionarioGrupo(FuncionarioGrupo funcionarioGrupo) {
		this.funcionarioGrupo = funcionarioGrupo;
	}

	public CategoriaInativacao getCategoriaInativacao() {
		return categoriaInativacao;
	}

	public void setCategoriaInativacao(CategoriaInativacao categoriaInativacao) {
		this.categoriaInativacao = categoriaInativacao;
	}

	public Usuario getResponsavelCadastro() {
		return responsavelCadastro;
	}

	public void setResponsavelCadastro(Usuario responsavelCadastro) {
		this.responsavelCadastro = responsavelCadastro;
	}

	public Usuario getContaDeUsuario() {
		return contaDeUsuario;
	}

	public void setContaDeUsuario(Usuario contaDeUsuario) {
		this.contaDeUsuario = contaDeUsuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
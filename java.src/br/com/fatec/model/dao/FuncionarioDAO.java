package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import br.com.fatec.model.dominio.Funcionario;
import br.com.fatec.model.factory.FabricaConexao;

public class FuncionarioDAO {

	private Connection conn = null;
	
	public FuncionarioDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Funcionario funcionario) {
		String sql = "INSERT INTO "
				+ "tbFuncionario(nome, cpf, dataContratacao, matricula, "
				+ "email, idCargo, idFuncionarioGrupo, idCategoriaInativacao, "
				+ "idUsuario, idUsuarioResponsavel, "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			
			Date dateSQL = Date.valueOf(funcionario.getDataContratacao());
			pstm.setDate(3, dateSQL);
			pstm.setInt(4, funcionario.getMatricula());
			pstm.setString(5, funcionario.getEmail());
			pstm.setInt(6, funcionario.getCargo().getId());
			pstm.setInt(7, funcionario.getFuncionarioGrupo().getId());
			pstm.setInt(8, funcionario.getCategoriaInativacao().getId());
			pstm.setInt(9, funcionario.getContaDeUsuario().getId());
			pstm.setInt(10, funcionario.getResponsavelCadastro().getId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
}
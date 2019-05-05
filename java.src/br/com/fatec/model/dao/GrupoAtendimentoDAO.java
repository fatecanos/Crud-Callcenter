package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.GrupoAtendimento;
import br.com.fatec.model.factory.FabricaConexao;

public class GrupoAtendimentoDAO {
	protected Connection conn;
	
	public void salvar(GrupoAtendimento grupo) {
		String sql = "INSERT INTO "
					+ "tbGrupoAtendimento"
					+ "(nome, idFuncionarioGrupo)"
					+ "VALUES (?,?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, grupo.getNome());
			pstm.setInt(2, grupo.getFuncionarioGrupo().getFuncionario().getId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(GrupoAtendimento grupo) {
		String sql = "UPDATE tbGrupoAtendimento SET(nome=?, idFuncionarioGrupo=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, grupo.getNome());
			pstm.setInt(2, grupo.getFuncionarioGrupo().getId());
			pstm.executeQuery();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(GrupoAtendimento grupo) {
		String sql = "DELETE tbGrupoAtendimento WHERE(id=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, grupo.getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<GrupoAtendimento> listar() {
		String sql = "SELECT * FROM tbGrupoAtendimento";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<GrupoAtendimento> grupo = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
			}
		}
	}
}

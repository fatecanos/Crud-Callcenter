package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.Result;

import br.com.fatec.model.dominio.FuncionarioGrupo;
import br.com.fatec.model.factory.FabricaConexao;

public class FuncionarioGrupoDAO {
	protected Connection conn;
	
	public FuncionarioGrupoDAO() {
		this.conn = FabricaConexao.getConexao();
	}

	public void salvar(int idGrupoAtendimento, int idFuncionario) {
		String sql = "INSERT INTO tbFuncionarioGrupo"
					+ "(idFuncionario, idGrupoAtendimento)"
					+ "VALUES(?,?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idFuncionario);
			pstm.setInt(2, idGrupoAtendimento);
			pstm.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void alterar(int idGrupoAtendimento, int idFuncionario) {
		String sql = "UPDATE tbFuncionarioGrupo"
				+ "SET(idGrupoAtendimento=?, idFuncionario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idGrupoAtendimento);
			pstm.setInt(2, idFuncionario);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void alterar(int idFuncionario) {
		String sql = "UPDATE tbFuncionarioGrupo"
				+ "SET(idFuncionario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idFuncionario);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void alterar(Integer idGrupoAtendimento) {
		String sql = "UPDATE tbFuncionarioGrupo"
				+ "SET(idGrupoAtendimento=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idGrupoAtendimento);
			pstm.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(int id) {
		String sql = "DELETE tbFuncionarioGrupo WHERE(idFuncionarioGrupo=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}		

	public FuncionarioGrupo buscarPorId(int id) {
		String sql = "SELECT (idFuncionarioGrupo, idGrupoAtendimento, idFuncionario)"
					+ " WHERE(idFuncionarioGrupo=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			FuncionarioGrupo funcionarioGrupo = new FuncionarioGrupo();
			funcionarioGrupo.setId(rs.getInt("idFuncionario"));
			funcionarioGrupo.setGrupo(
					new GrupoAtendimentoDAO().buscarPorId(rs.getInt("idGrupoAtendimento"))
			);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
}


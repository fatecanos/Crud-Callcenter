package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Regional;
import br.com.fatec.model.factory.FabricaConexao;

public class RegionalDAO{
	
	protected Connection conn;
	
	public RegionalDAO() {
		this.conn = FabricaConexao.getConexao();
	}

	public void salvar(Regional regional) {
		String sql = "INSERT INTO tbRegional(nome)VALUES(?)";
		PreparedStatement pstm = null;
		try{
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, regional.getNome());
			pstm.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	public void atualizar(Regional regional) {
		String sql = "UPDATE tbRegional SET(nome=?) WHERE(idRegional=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, regional.getNome());
			pstm.setInt(2, regional.getId());
			pstm.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	public void excluir(Regional regional) {
		String sql = "DELETE FROM tbRegional WHERE(nome=?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, regional.getNome());
			pstm.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Regional> listar(){
		String sql = "SELECT * FROM tbRegional;";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Regional> regionais = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Regional r = new Regional();
				r.setNome(rs.getString("nome"));
				regionais.add(r);
			}
			return regionais;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public Regional buscarPorId(int id) {
		String sql = "SELECT(idRegional, nome) FROM tbRegional WHERE(idRegional=?);";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			Regional regional = new Regional();
			regional.setId(rs.getInt("id"));
			regional.setNome(rs.getString("nome"));
		
			return regional;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
}

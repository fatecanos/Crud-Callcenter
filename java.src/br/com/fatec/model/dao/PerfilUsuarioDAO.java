package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.PerfilUsuario;
import br.com.fatec.model.factory.FabricaConexao;

public class PerfilUsuarioDAO {
	
	private Connection conn;

	public PerfilUsuarioDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public void salvar(PerfilUsuario perfilUsuario) {
		String sql = "INSERT INTO tbPerfilUsuario "
				   + "(idPerfil, idUsuario) "
				   + "VALUES(?,?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, perfilUsuario.getPerfil().getId());
			pstm.setInt(2, perfilUsuario.getUsuario().getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(PerfilUsuario perfilUsuario) {
		String sql = "UPDATE tbPerfilUsuario "
				   + "SET(idPerfil=?, idUsuario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, perfilUsuario.getPerfil().getId());
			pstm.setInt(2, perfilUsuario.getUsuario().getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(PerfilUsuario perfilUsuario) {
		String sql = "DELETE FROM tbPerfilUsuario "
				   + "WHERE(idPerfilUsuario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, perfilUsuario.getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<PerfilUsuario> listar(){
		String sql = "SELECT * FROM tbPerfilUsuario";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<PerfilUsuario> perfis = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				PerfilUsuario perfilUsuario = new PerfilUsuario();
				perfilUsuario.setId(rs.getInt("idPerfilUsuario"));
				perfilUsuario.setPerfil(
						new PerfilDAO().buscarPorId(rs.getInt("idPerfil"))
				);
				perfilUsuario.setUsuario(
						new UsuarioDAO().buscarPorId(rs.getInt("idUsuario"))
				);		
				perfis.add(perfilUsuario);
			}
			return perfis;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public PerfilUsuario buscarPorId(int id) {
		String sql = "SELECT * FROM tbPerfilUsuario "
				   + "WHERE(idPerfilUsuario=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			PerfilUsuario perfilUsuario = new PerfilUsuario();
			perfilUsuario.setId(rs.getInt("idPerfilUsuario"));
			perfilUsuario.setPerfil(
					new PerfilDAO().buscarPorId(rs.getInt("idPerfil")));
			perfilUsuario.setUsuario(
					new UsuarioDAO().buscarPorId(rs.getInt("idUsuario")));
			
			return perfilUsuario;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}
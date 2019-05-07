package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import br.com.fatec.model.dominio.Perfil;
import br.com.fatec.model.factory.FabricaConexao;

public class PerfilDAO {
	private Connection conn;
	
	public PerfilDAO() {
		this.conn = FabricaConexao.getConexao();
	}

	public void salvar(Perfil perfil) {
		String sql = "INSERT INTO tbPerfil(nome, idPerfilUsuario) VALUES(?,?);";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, perfil.getNome());
			pstm.setInt(2, perfil.getPerfilUsuario().getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Perfil perfil) {
		String sql = "DELETE tbPerfil WHERE(idPerfil=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, perfil.getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Perfil perfil) {
		String sql = "UPDATE tbPerfil SET(nome=?, idPerfilUsuario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, perfil.getNome());
			pstm.setInt(2, perfil.getPerfilUsuario().getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Perfil> listar(){
		String sql = "SELECT(idPerfil, nome, idPerfilUsuario)"
					+ "FROM tbPerfil";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<Perfil> perfis = new LinkedList<>();
			
			while(rs.next()) {
				Perfil p = new Perfil();
				p.setId(rs.getInt("idPerfil"));
				p.setNome(rs.getString("nome"));
				p.setPerfilUsuario(
						new PerfilUsuarioDAO().buscarPorId(rs.getInt("idPerfilUsuario"))
				);
				perfis.add(p);
			}
			return perfis;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public Perfil buscarPorId(int id) {
		String sql = "SELECT(idPerfil, nome, idPerfilUsuario)"
				+ "FROM tbPerfil WHERE(idPerfil=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			Perfil p = new Perfil();
			p.setId(rs.getInt("idPerfil"));
			p.setNome(rs.getString("nome"));
			p.setPerfilUsuario(
					new PerfilUsuarioDAO().buscarPorId(rs.getInt("idPerfilUsuario"))
			);
			
			return p;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}

package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Usuario;
import br.com.fatec.model.factory.FabricaConexao;

public class UsuarioDAO {

	private Connection conn;
	
	public UsuarioDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Usuario usuario) {
		String sql = "INSERT INTO tbUsuario "
				   + "(nome, senha, idPerfilUsuario) "
				   + "VALUES (?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getPerfilUsuario().getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	public List<Usuario> listar() {
		String sql = "SELECT * FROM tbUsuario";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setSenha(rs.getString("senha"));
				u.setPerfilUsuario(
						new PerfilUsuarioDAO().buscarPorId(rs.getInt("idPerfilUsuario")));
				
				usuarios.add(u);
			}
			
			return usuarios;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public void atualizar(Usuario usuario) {
		String sql = "UPDATE tbUsuario"
				   + "SET(nome=?, senha=?)"
				   + "WHERE(idUsuario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Usuario usuario) {
		String sql = "DELETE FROM tbUsuario "
				   + "WHERE(idUsuario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public Usuario buscarPorId(int id) {
		String sql = "SELECT * FROM tbUsuario"
				   + "WHERE(idUsuario=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setPerfilUsuario(
					new PerfilUsuarioDAO().buscarPorId(rs.getInt("idPerfilUsuario")));
		
			return usuario;
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
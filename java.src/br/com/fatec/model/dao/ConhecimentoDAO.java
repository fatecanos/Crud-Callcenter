package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Conhecimento;
import br.com.fatec.model.dominio.Usuario;
import br.com.fatec.model.factory.FabricaConexao;

public class ConhecimentoDAO {
	
	private Connection conn;
	
	public ConhecimentoDAO() {
		conn = FabricaConexao.getConexao();
	}

	public void salvar(Conhecimento conhecimento) {
		String sql = "INSERT INTO tbConhecimento "
				   + "(nome, descricao, tags, idChamado, idUsuarioResponsavel) "
				   + "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, conhecimento.getNome());
			pstm.setString(2, conhecimento.getDescricao());
			pstm.setString(3, String.join(", ", conhecimento.getTags() ) );
			pstm.setInt(4, conhecimento.getChamado().getId());
			pstm.setInt(5, conhecimento.getUsuarioResponsavel().getId());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Conhecimento conhecimento) {
		String sql = "DELETE FROM tbConhecimento "
				   + "WHERE(idConhecimento=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, conhecimento.getId());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Conhecimento conhecimento) {
		String sql = "UPDATE tbConhecimento "
					+ "SET(nome=?, descricao=?, tags=?, "
					+ "idChamado=?, idUsuarioResponsavel=?)"
					+ "WHERE(idConhecimento=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, conhecimento.getNome());
			pstm.setString(2, conhecimento.getDescricao());
			pstm.setString(3, String.join(", ", conhecimento.getTags()) );
			pstm.setInt(4, conhecimento.getChamado().getId());
			pstm.setInt(5, conhecimento.getUsuarioResponsavel().getId());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Conhecimento> listar(){
		String sql = "SELECT * FROM tbConhecimento";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<Conhecimento> conhecimentos = new LinkedList<>();
			
			while(rs.next()) {
				Conhecimento conhecimento = new Conhecimento();
				conhecimento.setId(rs.getInt("idConhecimento"));
				conhecimento.setNome(rs.getString("nome"));
				conhecimento.setDescricao(rs.getString("descricao"));
				
				conhecimento.setTags(
						rs.getString("tags").split(", "));
				
				conhecimento.setChamado(
						new ChamadoDAO().buscarPorId(rs.getInt("idChamado")));
				
				conhecimento.setUsuarioResponsavel(
						new UsuarioDAO().buscarPorId(rs.getInt("idUsuarioResponsavel")));
				
				conhecimentos.add(conhecimento);
			}
			
			return conhecimentos;
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public Conhecimento buscarPorId(int id) {
		String sql = "SELECT * FROM tbConhecimento "
				   + "WHERE(idConhecimento=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			Conhecimento conhecimento = new Conhecimento();
			conhecimento.setId(rs.getInt("idConhecimento"));
			conhecimento.setNome(rs.getString("nome"));
			conhecimento.setDescricao(rs.getString("descricao"));
			
			conhecimento.setTags(
					rs.getString("tags").split(", "));
			
			conhecimento.setChamado(
					new ChamadoDAO().buscarPorId(rs.getInt("idChamado")));
			
			conhecimento.setUsuarioResponsavel(
					new UsuarioDAO().buscarPorId(rs.getInt("idUsuarioResponsavel")));
			
			return conhecimento;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}
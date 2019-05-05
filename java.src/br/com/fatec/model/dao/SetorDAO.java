package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Setor;
import br.com.fatec.model.factory.FabricaConexao;

public class SetorDAO {
	
	private Connection conn;
	
	public SetorDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public SetorDAO() {
		this.conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Setor setor) {
		String sql = "INSERT INTO tbSetor(nome, idRegional) VALUES(?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, setor.getNome());
			pstm.setInt(2, setor.getRegional().getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Setor setor) {
		String sql = "UPDATE tbSetor SET(nome=?, idRegional=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, setor.getNome());
			pstm.setInt(2, setor.getRegional().getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Setor setor) {
		String sql = "DELETE FROM tbSetor WHERE(nome=? AND idRegional=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, setor.getNome());
			pstm.setInt(2, setor.getRegional().getId());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Setor> listar(){
		String sql = "SELECT * FROM tbSetor";
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		List<Setor> setores = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Setor s = new Setor();
				s.setId(rs.getInt("idSetor"));
				s.setNome(rs.getString("nome"));
				s.setRegional(
						new RegionalDAO().buscarPorId(rs.getInt("idRegional")));
				setores.add(s);
			}
			
			return setores;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public Setor buscarPorId(int id) {
		String sql = "SELECT(idSetor, nome, idRegional) FROM tbSetor WHERE(idSetor=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
		
			Setor setor = new Setor();
			setor.setId(rs.getInt("idSetor"));
			setor.setNome(rs.getString("nome"));
			setor.setRegional(
					new RegionalDAO().buscarPorId(rs.getInt("idRegional")));
		
			return setor;
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
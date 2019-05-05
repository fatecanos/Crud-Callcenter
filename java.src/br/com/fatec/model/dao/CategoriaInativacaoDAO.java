package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.CategoriaInativacao;
import br.com.fatec.model.factory.FabricaConexao;

public class CategoriaInativacaoDAO {
	
	private Connection conn;
	
	public CategoriaInativacaoDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public CategoriaInativacaoDAO() {
		this.conn = FabricaConexao.getConexao();
	}
	
	public void salvar(CategoriaInativacao categoriaInativacao) {
		String sql = "INSERT INTO tbCategoriaInativacao(nome) VALUES(?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoriaInativacao.getNome());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void alterar(CategoriaInativacao categoriaInativacao) {
		String sql = "UPDATE tbCategoriaInativacao SET(nome=?) WHERE(idCategoriaInativacao=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoriaInativacao.getNome());
			pstm.setInt(2, categoriaInativacao.getId());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(CategoriaInativacao categoriaInativacao) {
		String sql = "DELETE FROM tbCategoriaInativacao WHERE(idCategoriaInativacao=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categoriaInativacao.getId());
			pstm.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<CategoriaInativacao> listar(){
		String sql = "SELECT (idCategoriaInativacao, nome) FROM tbCategoriaInativacao";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CategoriaInativacao> categoriasInativacao = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				CategoriaInativacao c = new CategoriaInativacao();
				c.setId(rs.getInt("idCategoriaInativacao"));
				c.setNome(rs.getString("nome"));
				categoriasInativacao.add(c);
			}
			
			return categoriasInativacao;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public CategoriaInativacao buscarPorId(int id) {
		String sql = "SELECT (idCategoriaInativacao, nome) FROM tbCategoriaInativacao WHERE(idCategoriaInativacao=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			CategoriaInativacao categoria = new CategoriaInativacao();
			categoria.setId(rs.getInt("idCategoriaInativacao"));
			categoria.setNome(rs.getString("nome"));
			
			return categoria;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}
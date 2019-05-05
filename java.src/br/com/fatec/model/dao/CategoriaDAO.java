package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Categoria;
import br.com.fatec.model.factory.FabricaConexao;

public class CategoriaDAO {
	
	private Connection conn = null;
	
	public CategoriaDAO() {
		conn = FabricaConexao.getConexao();
	}

	public void salvar(Categoria categoria) {
		String sql = "INSERT INTO tbCategoria(nome) VALUES(?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoria.getNome());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Categoria> listar() {
		String sql = "SELECT * FROM tbCategoria";
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		List<Categoria> categorias = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("idCategoria"));
				c.setNome(rs.getString("nome"));
				categorias.add(c);
			}
			
			return categorias;	
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	public void atualizar(Categoria categoria) {	
		String sql = "UPDATE tbCategoria SET(nome=?) WHERE(id=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoria.getNome());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {	
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Categoria categoria) {
		String sql = "DELETE FROM tbCategoria WHERE(nome=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoria.getNome());
			pstm.execute();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
}
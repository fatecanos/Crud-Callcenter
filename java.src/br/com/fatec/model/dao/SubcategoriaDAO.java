package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Subcategoria;
import br.com.fatec.model.factory.FabricaConexao;

public class SubcategoriaDAO {
	private Connection conn;
	
	public void salvar(Subcategoria subcategoria) {
		String sql = "INSERT INTO tbSubcategoria(nome, prazoAtendimento, idCategoria)"
				+ "	VALUES(?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, subcategoria.getNome());
			pstm.setDate(2, (Date) subcategoria.getPrazoAtendimento());
			pstm.setInt(3, subcategoria.getCategoria().getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Subcategoria subcategoria) {
		String sql = "UPDATE tbSubcategoria SET(nome=?, prazoAtendimento=?, idCategoria=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, subcategoria.getNome());
			pstm.setDate(2, (Date)subcategoria.getPrazoAtendimento());
			pstm.setInt(3, subcategoria.getCategoria().getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Subcategoria subcategoria) {
		String sql = "DELETE tbSubcategoria WHERE(id=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, subcategoria.getId());
			pstm.execute();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Subcategoria> listar(){
		String sql = "SELECT (idSubcategoria, nome, prazoAtendimento, idCategoria) "
					+ "FROM tbSubcategoria";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<Subcategoria> subcategorias = new LinkedList<>();
			while(rs.next()) {
				Subcategoria subcat = new Subcategoria();
				subcat.setId(rs.getInt("idSubcategoria"));
				subcat.setNome(rs.getString("nome"));
				subcat.setPrazoAtendimento(rs.getDate("prazoAtendimento"));
				subcat.setCategoria(
						new CategoriaDAO().buscarPorId(rs.getInt("idCategoria"))
				);
				subcategorias.add(subcat);
			}
			return subcategorias;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public Subcategoria buscarPorId(int id) {
		String sql = "SELECT * FROM tbSubcategoria WHERE(idSubcategoria=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Subcategoria subcat = new Subcategoria();
			subcat.setId(rs.getInt("idSubcategoria"));
			subcat.setNome(rs.getString("nome"));
			subcat.setPrazoAtendimento(rs.getDate("prazoAtendimento"));
			subcat.setCategoria(
					new CategoriaDAO().buscarPorId(rs.getInt("idCategoria"))
			);
			return subcat;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}

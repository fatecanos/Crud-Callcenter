	package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Cargo;
import br.com.fatec.model.factory.FabricaConexao;

public class CargoDAO{

	private Connection conn = null;
	
	public CargoDAO() {
		this.conn = FabricaConexao.getConexao();
	}

	public void salvar(Cargo cargo) {
		String sql = "INSERT INTO tbCargo(nome, idSetor) VALUES(?, ?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cargo.getNome());
			pstm.setInt(2,    cargo.getSetor().getId());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	
	public List<Cargo> listar() {
		String sql = "SELECT * FROM tbCargo;";
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		List<Cargo> cargos = new LinkedList<>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Cargo c = new Cargo();
				c.setId(rs.getInt("idCargo"));
				c.setNome(rs.getString("nome"));
				c.setSetor(new SetorDAO().buscarPorId(rs.getInt("idSetor")));
				cargos.add(c);
			}
			return cargos;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	
	public void atualizar(Cargo cargo) {	
		String sql = "UPDATE tbCargo SET(nome=?, idSetor=?)WHERE(id=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cargo.getNome());
			pstm.setInt(2, cargo.getSetor().getId());
			pstm.setInt(3, cargo.getId());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {	
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}

	
	public void excluir(Cargo cargo) {
		String sql = "DELETE FROM tbCargo WHERE(nome=? AND idSetor=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cargo.getNome());
			pstm.setInt(2, cargo.getSetor().getId());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	
	
}

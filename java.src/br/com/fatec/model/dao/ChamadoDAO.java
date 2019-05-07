package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fatec.model.dominio.Chamado;
import br.com.fatec.model.dominio.DetalhesChamado;
import br.com.fatec.model.dominio.GrupoAtendimento;
import br.com.fatec.model.factory.FabricaConexao;

public class ChamadoDAO {
	private Connection conn;
	
	public ChamadoDAO() {
		this.conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Chamado chamado) {
		String sql = "INSERT INTO tbChamado(nome, descricao, dataInicio, dataFechamento"
				+ "idGrupoAtendimento, idCategoria, statusChamado, datalhesChamado)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, chamado.getNome() );
			pstm.setString(2, chamado.getDescricao());
			pstm.setString(3, chamado.getDataInicio());
			pstm.setString(4, chamado.getDataFechamento());
			pstm.setInt(5, chamado.getGrupo().getId());
			pstm.setInt(6, chamado.getCategoria().getId());
			pstm.setString(7, chamado.getStatus().name());
			pstm.setBytes(8, chamado.getDetalhes().getImagem());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Chamado chamado) {
		String sql = "UPDATE tbChamado SET(nome=?, descricao=?, dataInicio=?, dataFechamento=?" 
				+"idGrupoAtendimento=?, idCategoria=?, statusChamado=?, datalhesChamado=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, chamado.getNome() );
			pstm.setString(2, chamado.getDescricao());
			pstm.setString(3, chamado.getDataInicio());
			pstm.setString(4, chamado.getDataFechamento());
			pstm.setInt(5, chamado.getGrupo().getId());
			pstm.setInt(6, chamado.getCategoria().getId());
			pstm.setString(7, chamado.getStatus().name());
			pstm.setBytes(8, chamado.getDetalhes().getImagem());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Chamado chamado) {
		String sql = "DELETE tbChamado where(id=?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, chamado.getId());
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Chamado> listar(Chamado chamado){
		String sql = "SELECT FROM tbChamado(idChamado, nome, descricao, dataInicio, dataFechamento"
				+ ",idGrupoAtendimento, idCategoria, statusChamado, datalhesChamado);";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<Chamado> chamados = new LinkedList<>();
			Chamado chamado;
			while(rs.next()) {
				chamado = new Chamado();
				chamado.setId(rs.getInt("idChamado"));
				chamado.setNome(rs.getString("nome"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setDataInicio(rs.getString("dataInicio"));
				chamado.setDataFechamento(rs.getString("dataFechamento"));
				chamado.setGrupo(new GrupoAtendimentoDAO().buscarPorId(rs.getInt("idGrupoAtendimento")));
				chamado.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("idCategoria")));
				chamado.setStatus(rs.getInt("statusChamado"));
				chamado.setDetalhes(new DetalhesChamado().setImagem(rs.getBytes("detalhesChamado")));
				chamados.add(chamado);
			}
			return chamados;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
		
	public Chamado buscarPorId(int id) {
		String sql = "SELECT * FROM tbChamado WHERE(id=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			Chamado chamado = new Chamado();
			chamado.setId(rs.getInt("idChamado"));
			chamado.setNome(rs.getString("nome"));
			chamado.setDescricao(rs.getString("descricao"));
			chamado.setDataInicio(rs.getString("dataInicio"));
			chamado.setDataFechamento(rs.getString("dataFechamento"));
			chamado.setGrupo(new GrupoAtendimentoDAO().buscarPorId(rs.getInt("idGrupoAtendimento")));
			chamado.setCategoria(new CategoriaDAO().buscarPorId(rs.getInt("idCategoria")));
			chamado.setStatus(rs.getInt("statusChamado"));
			chamado.setDetalhes(new DetalhesChamado().setImagem(rs.getBytes("detalhesChamado")));
			
			return chamado;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}

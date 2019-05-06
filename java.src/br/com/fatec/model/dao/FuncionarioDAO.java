package br.com.fatec.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.sql.Date;

import br.com.fatec.model.dominio.Funcionario;
import br.com.fatec.model.dominio.FuncionarioGrupo;
import br.com.fatec.model.factory.FabricaConexao;

public class FuncionarioDAO {

	private Connection conn = null;
	
	public FuncionarioDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Funcionario funcionario) {
		String sql = "INSERT INTO "
				+ "tbFuncionario(nome, cpf, dataContratacao, matricula, "
				+ "email, idCargo, idFuncionarioGrupo, idCategoriaInativacao, "
				+ "idUsuario, idUsuarioResponsavel)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			
			Date dateSQL = Date.valueOf(funcionario.getDataContratacao());
			pstm.setDate(3, dateSQL);
			pstm.setInt(4, funcionario.getMatricula());
			pstm.setString(5, funcionario.getEmail());
			pstm.setInt(6, funcionario.getCargo().getId());
			pstm.setInt(7, funcionario.getFuncionarioGrupo().getId());
			pstm.setInt(8, funcionario.getCategoriaInativacao().getId());
			pstm.setInt(9, funcionario.getContaDeUsuario().getId());
			pstm.setInt(10, funcionario.getResponsavelCadastro().getId());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Funcionario> listar() {
		String sql = "SELECT * FROM tbFuncionario";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Funcionario> funcionarios = new LinkedList<>();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("idFuncionario"));
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				
				LocalDate date = rs.getDate("dataContratacao").toLocalDate();
				f.setDataContratacao(date);
				f.setMatricula(rs.getInt("matricula"));
				
				f.setFuncionarioGrupo(
						new FuncionarioGrupoDAO().buscarPorId(rs.getInt("idFuncionarioGrupo"))
				);
				
				f.setCategoriaInativacao(
						new CategoriaInativacaoDAO().buscarPorId(rs.getInt("idCategoriaInativacao"))		
				);
				
				f.setContaDeUsuario(
						new UsuarioDAO().buscarPorId(rs.getInt("idUsuario"))
				);
				
				f.setResponsavelCadastro(
						new UsuarioDAO().buscarPorId(rs.getInt("idUsuario"))
				);
				
				f.setCargo(
						new CargoDAO().buscarPorId(rs.getInt("idCargo"))
				);
				
				funcionarios.add(f);
			}
			
			return funcionarios;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public void excluir(Funcionario funcionario) {
		String sql = "DELETE tbFuncionario WHERE(idFuncionario=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, funcionario.getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		String sql = "UPDATE tbFuncionario "
					+ "SET(nome=?, cpf=?, dataContratacao=?, matricula=?," 
					+ "email=?, idCargo=?, idFuncionarioGrupo=?, idCategoriaInativacao=?," 
					+ "idUsuario=?, idUsuarioResponsavel=?);";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getCpf());
			pstm.setString(3, funcionario.getDataContratacao().toString());//string
			pstm.setInt(4, funcionario.getMatricula());
			pstm.setString(5, funcionario.getEmail());
			pstm.setInt(6, funcionario.getCargo().getId());
			pstm.setInt(7, funcionario.getFuncionarioGrupo().getId());
			pstm.setInt(8, funcionario.getCategoriaInativacao().getId());
			pstm.setInt(9, funcionario.getContaDeUsuario().getId());
			pstm.setInt(10, funcionario.getResponsavelCadastro().getId());
		
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public Funcionario buscarPorId(int id) {
		String sql = "SELECT (idFuncionario, nome, cpf, dataContratacao, matricula," 
				+ "email, idCargo, idFuncionarioGrupo, idCategoriaInativacao,"
				+ "idUsuario, idUsuarioResponsavel) "
				+ "FROM tbFuncionario WHERE(idFuncionario=?)";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			Funcionario func = new Funcionario();
			func.setId(rs.getInt("idFuncionario"));
			func.setNome(rs.getString("nome"));
			func.setCpf(rs.getString("cpf"));
			func.setDataContratacao(rs.getString("dataContratacao"));
			func.setMatricula(rs.getInt("matricula"));
			func.setEmail(rs.getString("email"));
			func.setCargo(new CargoDAO().buscarPorId(rs.getInt("cargo")));
			func.setFuncionarioGrupo(
					new FuncionarioGrupoDAO().buscarPorId(rs.getInt("idFuncionarioGrupo"))
			);
			func.setCategoriaInativacao(
					new CategoriaInativacaoDAO().buscarPorId(rs.getInt("idCategoriaInativacao"))
			);
			func.setContaDeUsuario(
					new UsuarioDAO().buscarPorId(rs.getInt("idUsuario"))
			);
			func.setContaDeUsuario(
					new UsuarioDAO().buscarPorId(rs.getInt("idUsuarioResponsavel"))
			);
			return func;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}
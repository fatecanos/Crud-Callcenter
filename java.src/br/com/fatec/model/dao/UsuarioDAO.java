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
		String sql = "INSERT INTO "
				   + "tbUsuario()";
	}
}
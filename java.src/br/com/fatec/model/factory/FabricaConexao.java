/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FabricaConexao {
    
    private static final String DRIVER  = "org.mysql.Driver";
    private static final String URL     = "jdbc:mysql://localhost:5432/callcenter";
    private static final String USER    = "";
    private static final String PASS    = "";
            
    public static Connection getConexao(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro de conexão", e);
        }
    }
    
    public static void fecharConexao(Connection conn){
        if(conn != null){    
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement pstm){
        if(pstm!=null){
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
        fecharConexao(conn);
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement pstm, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex){
                System.err.println("Erro ao fechar conexao"+ex.getMessage());
            }
        }
        fecharConexao(conn, pstm);
    }
}
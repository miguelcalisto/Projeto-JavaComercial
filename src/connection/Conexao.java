/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package connection;

/**
 * princiapl continue aqui
 * @author debian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/exame-trabalho";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
    
    
    
    public static void closeConnection(Connection con){
        
        if (con != null) {
            try{
                con.close();
            
            } catch (SQLException ex){
                System.err.println("Erro: " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        if (stmt != null){
            
            try{
                stmt.close();
            
            }catch(SQLException ex){
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        if (rs != null){
            try{
                rs.close();
            
            }catch(SQLException ex){
                System.err.println("Erro: " + ex);
            }
        }
    }
    
    
}

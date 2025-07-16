/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

/**
 *
 * @author debian
 */
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.getConnection();
            System.out.println("Conexão bem sucedida!");
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}

package model.dao;

import connection.Conexao;
import model.beans.Paciente;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // INSERIR 
    public void inserir(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, telefone, datanascimento, alergia, sexo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getTelefone());
   
            stmt.setDate(4, java.sql.Date.valueOf(paciente.getDataNascimento()));

            stmt.setString(5, paciente.getAlergia());
            stmt.setString(6, paciente.getSexo());
       


            stmt.executeUpdate();
            System.out.println("Paciente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir paciente: " + e.getMessage());
        }
    }

    // LISTAR TODOS 
    public List<Paciente> listarTodos() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt("idpaciente"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setDataNascimento(rs.getString("datanascimento"));
                p.setAlergia(rs.getString("alergia"));
                p.setSexo(rs.getString("sexo"));
                

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pacientes: " + e.getMessage());
        }
        return lista;
    }

    // ATUALIZAR 
    public void alterar(Paciente paciente) {
        String sql = "UPDATE paciente SET nome=?, telefone=?, datanascimento=?, alergia=?, sexo=? WHERE cpf=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getTelefone());
            
            
 // DATA 
 

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate data = LocalDate.parse(paciente.getDataNascimento(), formatter);
stmt.setDate(3, java.sql.Date.valueOf(data));



///
            stmt.setString(4, paciente.getAlergia());
            stmt.setString(5, paciente.getSexo()); 

            stmt.setString(6, paciente.getCpf());

            stmt.executeUpdate();
            System.out.println("Paciente alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar paciente: " + e.getMessage());
        }
    }

    // EXCLUIR 
    public void excluir(String cpf) {
        String sql = "DELETE FROM paciente WHERE cpf = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Paciente excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir paciente: " + e.getMessage());
        }
    }
    
    
    public void alterarPorId(Paciente paciente) {
    String sql = "UPDATE paciente SET nome = ?, cpf = ?, telefone = ?, datanascimento = ?, alergia = ?, sexo = ? WHERE idpaciente = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, paciente.getNome());
        stmt.setString(2, paciente.getCpf());
        stmt.setString(3, paciente.getTelefone());
        
        /// data
        stmt.setDate(4, java.sql.Date.valueOf(paciente.getDataNascimento())); 
        ///

        stmt.setString(5, paciente.getAlergia());
        stmt.setString(6, paciente.getSexo());
        stmt.setInt(7, paciente.getId()); 

        stmt.executeUpdate();

    } catch (SQLException e) {
         System.err.println("erro ao alterar: " + e.getMessage());
    }
}


    
    
    
    public Paciente buscarPorId(int id) {
    Paciente paciente = null;
    String sql = "SELECT * FROM paciente WHERE idpaciente = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            paciente.setId(rs.getInt("idpaciente"));
            paciente.setNome(rs.getString("nome"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setTelefone(rs.getString("telefone"));
            paciente.setDataNascimento(rs.getString("datanascimento"));
            paciente.setAlergia(rs.getString("alergia"));
            paciente.setSexo(rs.getString("sexo"));
        }

    } catch (SQLException e) {
       System.err.println("erro ao busar: " + e.getMessage());
    }

    return paciente;
}

   

    public void excluirPorId(int id) {
    String sql = "DELETE FROM paciente WHERE idpaciente = ?";
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        System.err.println("erro ao excluir: " + e.getMessage());
    }
}


}

package model.dao;

import connection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane;
import model.beans.ProfissionalDeSaude;

public class ProfissionalDeSaudeDAO {

    public void salvar(ProfissionalDeSaude profissional) {
        String sql = "INSERT INTO profissionaldesaude (nome, cpf, registroprofissional) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setInt(3, profissional.getRegistroProfissional());

            stmt.executeUpdate();
            System.out.println("Profissional de saúde salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar profissional de saúde: " + e.getMessage());
        }
    }

    public void alterar(ProfissionalDeSaude profissional) {
        String sql = "UPDATE profissionaldesaude SET nome = ?, cpf = ?, registroprofissional = ? WHERE idprofissionalidesaude = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getCpf());
            stmt.setInt(3, profissional.getRegistroProfissional());
            stmt.setInt(4, profissional.getId());

            stmt.executeUpdate();
            System.out.println("Profissional de saúde alterado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar profissional de saúde: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM profissionaldesaude WHERE idprofissionalidesaude = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Profissional de saúde excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir profissional de saúde: " + e.getMessage());
        }
    }

    public List<ProfissionalDeSaude> consultarTodos() {
        List<ProfissionalDeSaude> lista = new ArrayList<>();
        String sql = "SELECT * FROM profissionaldesaude";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ProfissionalDeSaude profissional = new ProfissionalDeSaude();
                profissional.setId(rs.getInt("idprofissionalidesaude"));
                profissional.setNome(rs.getString("nome"));
                profissional.setCpf(rs.getString("cpf"));
                profissional.setRegistroProfissional(rs.getInt("registroprofissional"));

                lista.add(profissional);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar profissionais de saúde: " + e.getMessage());
        }

        return lista;
    }
  
    public List<ProfissionalDeSaude> listarTodos() {
    List<ProfissionalDeSaude> lista = new ArrayList<>();
    String sql = "SELECT * FROM profissionaldesaude";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProfissionalDeSaude p = new ProfissionalDeSaude();
            p.setId(rs.getInt("idprofissionalidesaude"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setRegistroProfissional(rs.getInt("registroprofissional"));

            lista.add(p);
        }
    } catch (SQLException e) {
        System.err.println("erro ao listar todos: "+e.getMessage());
    }

    return lista;
}
   
    public void excluirPorId(int id) {
    String sql = "DELETE FROM profissionaldesaude WHERE idprofissionalidesaude = ?";
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
    } catch (SQLException e) {
        System.err.println("erro ao ecluir por id: "+e.getMessage());
    }
    
    
}
    
    public void alterarPorId(ProfissionalDeSaude profissional) {
    String sql = "UPDATE profissionaldesaude SET nome = ?, cpf = ?, registroprofissional = ? WHERE idprofissionalidesaude = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, profissional.getNome());
        stmt.setString(2, profissional.getCpf());
        stmt.setInt(3, profissional.getRegistroProfissional());
        stmt.setInt(4, profissional.getId());

        stmt.executeUpdate();

    } catch (SQLException e) {

        System.err.println("erro ao alterar: "+e.getMessage());
    }
    
    
}
    
    public ProfissionalDeSaude buscarPorId(int id) {
    String sql = "SELECT * FROM profissionaldesaude WHERE idprofissionalidesaude = ?";
    ProfissionalDeSaude profissional = null;

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            profissional = new ProfissionalDeSaude();
            profissional.setId(rs.getInt("idprofissionalidesaude"));
            profissional.setNome(rs.getString("nome"));
            profissional.setCpf(rs.getString("cpf"));
            profissional.setRegistroProfissional(rs.getInt("registroprofissional"));
        }

    } catch (SQLException e) {

        System.err.println("erro ao bsucar: "+e.getMessage());
    }

    return profissional;
}


   
}

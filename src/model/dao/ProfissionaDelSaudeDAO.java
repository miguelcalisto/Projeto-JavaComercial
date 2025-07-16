
package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.beans.ProfissionalDeSaude;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.beans.ProfissionalDeSaude;

public class ProfissionaDelSaudeDAO {
    
    private Connection con = null;
    
  public ProfissionaDelSaudeDAO() {
    con = Conexao.getConnection();
}

    
    public boolean create(ProfissionalDeSaude profissionalSaude){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO profissional_saude (registro_profissional, cpf, nome) VALUES (?, ?, ?)");
            stmt.setString(1, profissionalSaude.getRegistroProfissional());
            stmt.setString(2, profissionalSaude.getCpf());
            stmt.setString(3, profissionalSaude.getNome());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.err.println("erro ao salvar: " + ex);
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<ProfissionalDeSaude> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ProfissionalDeSaude> listaProfissionalSaude = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM profissional_saude ORDER by id");
            rs = stmt.executeQuery();
            while(rs.next()){
                ProfissionalDeSaude profissionalsaude = new ProfissionalDeSaude();
                profissionalsaude.setRegistroProfissional(rs.getString("registro_profissional"));
                profissionalsaude.setId(rs.getInt("id"));
                profissionalsaude.setCpf(rs.getString("cpf"));
                profissionalsaude.setNome(rs.getString("nome"));
                listaProfissionalSaude.add(profissionalsaude);
            }
        } catch(SQLException ex){
            System.err.println("Erro ao listar: " + ex);
        } finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaProfissionalSaude;
    }
    
    public ArrayList<ProfissionalDeSaude> getProfissionalNome(String nome) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ProfissionalDeSaude> listaProfissionalSaude = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM profissional_saude WHERE nome ILIKE ? ORDER by id");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProfissionalDeSaude profissionalsaude = new ProfissionalDeSaude();
                profissionalsaude.setRegistroProfissional(rs.getString("registro_profissional"));
                profissionalsaude.setId(rs.getInt("id"));
                profissionalsaude.setCpf(rs.getString("cpf"));
                profissionalsaude.setNome(rs.getString("nome"));
                listaProfissionalSaude.add(profissionalsaude);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao listar os Profissionais por nome: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaProfissionalSaude;
    }

    public ArrayList<ProfissionalDeSaude> getProfissionalCpf(String cpf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ProfissionalDeSaude> listaProfissionalSaude = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM profissional_saude WHERE cpf ILIKE ? ORDER by id");
            stmt.setString(1, "%" + cpf + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProfissionalDeSaude profissionalsaude = new ProfissionalDeSaude();
                profissionalsaude.setRegistroProfissional(rs.getString("registro_profissional"));
                profissionalsaude.setId(rs.getInt("id"));
                profissionalsaude.setCpf(rs.getString("cpf"));
                profissionalsaude.setNome(rs.getString("nome"));
                listaProfissionalSaude.add(profissionalsaude);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os profissionais por cpf: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaProfissionalSaude;
    }

    public ArrayList<ProfissionalDeSaude> getProfissionalRegistro(String registro) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<ProfissionalDeSaude> listaProfissionalSaude = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM profissional_saude WHERE registro_profissional ILIKE ? ORDER by id");
            stmt.setString(1, "%" + registro + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProfissionalDeSaude profissionalsaude = new ProfissionalDeSaude();
                profissionalsaude.setRegistroProfissional(rs.getString("registro_profissional"));
                profissionalsaude.setId(rs.getInt("id"));
                profissionalsaude.setCpf(rs.getString("cpf"));
                profissionalsaude.setNome(rs.getString("nome"));
                listaProfissionalSaude.add(profissionalsaude);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os profissionais: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaProfissionalSaude;
    }
    
    public boolean update(ProfissionalDeSaude profissionalsaude){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE profissional_saude set registro_profissional = ?, cpf = ?, nome = ? WHERE id = ?");
            stmt.setString(1, profissionalsaude.getRegistroProfissional());
            stmt.setString(2, profissionalsaude.getCpf());
            stmt.setString(3, profissionalsaude.getNome());
            stmt.setInt(4, profissionalsaude.getId());
            stmt.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.err.println("Erro ao atualizar: " + ex);
            return false;
        } finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(ProfissionalDeSaude profissionalsaude){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("DELETE from profissional_saude WHERE id = ?");
            stmt.setInt(1, profissionalsaude.getId());
            stmt.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.err.println("Erro ao dleytar: " + ex);
            return false;
        } finally{
            Conexao.closeConnection(con, stmt);
        }
    }
}

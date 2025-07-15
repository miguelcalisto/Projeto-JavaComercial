
package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;  
import model.beans.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.beans.Paciente;

public class PacienteDAO {
    
    private Connection con = null;
    
    public PacienteDAO(){
        con = Conexao.getConnection();
    }
    
    public boolean create(Paciente paciente){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO paciente (telefone, data_nascimento, alergias, sexo, cpf, nome) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, paciente.getTelefone());
            stmt.setString(2, paciente.getDataNascimento());
            stmt.setString(3, paciente.getAlergias());
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, paciente.getCpf());
            stmt.setString(6, paciente.getNome());
            stmt.executeUpdate();
            return true;
            
        } catch(SQLException ex){
            System.err.println("Erro ao salvar: " + ex);
            return false;
        } finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Paciente> read() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM paciente ORDER by id");
            rs = stmt.executeQuery();
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setAlergias(rs.getString("alergias"));
                paciente.setDataNascimento(rs.getString("data_nascimento"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefone(rs.getString("telefone"));
                listaPacientes.add(paciente);
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao ler os Pacientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaPacientes;
    }
    
        public ArrayList<Paciente> getPacientesNome(String nome) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM paciente WHERE nome ILIKE ? ORDER by id");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setAlergias(rs.getString("alergias"));
                paciente.setDataNascimento(rs.getString("data_nascimento"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefone(rs.getString("telefone"));
                listaPacientes.add(paciente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os Pacientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaPacientes;
    }

    public ArrayList<Paciente> getPacientesCpf(String cpf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM paciente WHERE cpf ILIKE ? ORDER by id");
            stmt.setString(1, "%" + cpf + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setAlergias(rs.getString("alergias"));
                paciente.setDataNascimento(rs.getString("data_nascimento"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setTelefone(rs.getString("telefone"));
                listaPacientes.add(paciente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler os Pacientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return listaPacientes;
    }
    
    public boolean update(Paciente paciente){
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE paciente set cpf = ?, alergias = ?, data_nascimento = ?, nome = ?, sexo = ?, telefone = ? WHERE id = ?");
            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getAlergias());
            stmt.setString(3, paciente.getDataNascimento());
            stmt.setString(4, paciente.getNome());
            stmt.setString(5, paciente.getSexo());
            stmt.setString(6, paciente.getTelefone());
            stmt.setInt(7, paciente.getId());
            stmt.executeUpdate();
            return true;
        } catch(SQLException ex){
            System.err.println("Erro ao atualizar: " + ex);
            return false;
        } finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public boolean delete(Paciente paciente) {
    Connection con = Conexao.getConnection(); 
    PreparedStatement stmt = null;

    try {
        stmt = con.prepareStatement("DELETE FROM paciente WHERE id = ?");
        stmt.setInt(1, paciente.getId());
        stmt.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.err.println("Erro ao excluir paciente: " + ex);
        return false;
    } finally {
        Conexao.closeConnection(con, stmt);
    }
    }}
    

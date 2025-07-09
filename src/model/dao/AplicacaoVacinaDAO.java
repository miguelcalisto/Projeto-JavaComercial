package model.dao;

import connection.Conexao;
import model.beans.AplicacaoVacina;
import model.beans.Paciente;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AplicacaoVacinaDAO {

    public void salvar(AplicacaoVacina aplicacao) {
        String sql = "INSERT INTO aplicacaovacina (idpaciente, idprofissionaldesaude, idvacina, dataaplicacao, localaplicacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aplicacao.getPaciente().getId());
            stmt.setInt(2, aplicacao.getProfissional().getId());
            stmt.setInt(3, aplicacao.getVacina().getId());
            stmt.setDate(4, Date.valueOf(aplicacao.getDataAplicacao()));
            stmt.setString(5, aplicacao.getLocalAplicacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados:\n" + e.getMessage());

        }
    }

    public void excluirPorId(int id) {
        String sql = "DELETE FROM aplicacaovacina WHERE idaplicacaovacina = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados:\n" + e.getMessage());

        }
    }

    public List<AplicacaoVacina> listarTodos() {
        List<AplicacaoVacina> lista = new ArrayList<>();
        String sql = """
            SELECT a.idaplicacaovacina, a.dataaplicacao, a.localaplicacao,
                   p.idpaciente, p.nome AS nomepaciente,
                   ps.idprofissionaldesaude, ps.nome AS nomeprofissional,
                   v.idvacina, v.nome AS nomevacina, v.fabricante
            FROM aplicacaovacina a
            JOIN paciente p ON a.idpaciente = p.idpaciente
            JOIN profissionaldesaude ps ON a.idprofissionaldesaude = ps.idprofissionaldesaude
            JOIN vacina v ON a.idvacina = v.idvacina
            """;

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AplicacaoVacina aplicacao = new AplicacaoVacina();
                aplicacao.setId(rs.getInt("idaplicacaovacina"));
                aplicacao.setDataAplicacao(rs.getDate("dataaplicacao").toLocalDate());
                aplicacao.setLocalAplicacao(rs.getString("localaplicacao"));

                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("idpaciente"));
                paciente.setNome(rs.getString("nomepaciente"));
                aplicacao.setPaciente(paciente);

                ProfissionalDeSaude profissional = new ProfissionalDeSaude();
                profissional.setId(rs.getInt("idprofissionaldesaude"));
                profissional.setNome(rs.getString("nomeprofissional"));
                aplicacao.setProfissional(profissional);

                Vacina vacina = new Vacina();
                vacina.setId(rs.getInt("idvacina"));
                vacina.setNome(rs.getString("nomevacina"));
                vacina.setFabricante(rs.getString("fabricante"));
                aplicacao.setVacina(vacina);

                lista.add(aplicacao);
            }

        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados:\n" + e.getMessage());

        }

        return lista;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author debian
 */

import connection.Conexao;
import model.beans.Vacina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {

    public void salvar(Vacina vacina) {
        String sql = "INSERT INTO vacina (nome, fabricante) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getFabricante());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarPorId(Vacina vacina) {
        String sql = "UPDATE vacina SET nome = ?, fabricante = ? WHERE idvacina = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getFabricante());
            stmt.setInt(3, vacina.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPorId(int id) {
        String sql = "DELETE FROM vacina WHERE idvacina = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vacina buscarPorId(int id) {
        String sql = "SELECT * FROM vacina WHERE idvacina = ?";
        Vacina vacina = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                vacina = new Vacina();
                vacina.setId(rs.getInt("idvacina"));
                vacina.setNome(rs.getString("nome"));
                vacina.setFabricante(rs.getString("fabricante"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vacina;
    }

    public List<Vacina> listarTodos() {
        String sql = "SELECT * FROM vacina ORDER BY idvacina";
        List<Vacina> vacinas = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vacina vacina = new Vacina();
                vacina.setId(rs.getInt("idvacina"));
                vacina.setNome(rs.getString("nome"));
                vacina.setFabricante(rs.getString("fabricante"));
                vacinas.add(vacina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vacinas;
    }
}

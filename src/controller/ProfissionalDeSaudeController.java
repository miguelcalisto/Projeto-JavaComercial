/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author debian
 */

import java.util.List;
import model.beans.ProfissionalDeSaude;
import model.dao.ProfissionalDeSaudeDAO;

public class ProfissionalDeSaudeController {
     private ProfissionalDeSaudeDAO dao = new ProfissionalDeSaudeDAO();

    // CADASTRAR
    public String cadastrarProfissional(ProfissionalDeSaude profissional) {
        if (profissional.getNome().isEmpty() || profissional.getCpf().isEmpty()) {
            return "Nome e CPF são obrigatórios.";
        }

        try {
            dao.salvar(profissional);
            return "Profissional cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
    }

    // ALTERAR POR ID
    public String alterarProfissional(ProfissionalDeSaude profissional) {
        if (profissional.getId() <= 0) {
            return "ID inválido.";
        }

        try {
            dao.alterarPorId(profissional);
            return "Profissional alterado com sucesso!";
        } catch (Exception e) {
            return "Erro ao alterar: " + e.getMessage();
        }
    }

    // EXCLUIR POR ID
    public String excluirProfissional(int id) {
        if (id <= 0) {
            return "ID inválido.";
        }

        try {
            dao.excluirPorId(id);
            return "Profissional excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir: " + e.getMessage();
        }
    }

    // BUSCAR POR ID
    public ProfissionalDeSaude buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    // LISTAR TODOS
    public List<ProfissionalDeSaude> listarTodos() {
        return dao.listarTodos();
    }

}

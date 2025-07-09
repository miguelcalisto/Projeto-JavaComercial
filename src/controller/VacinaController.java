package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.beans.Vacina;
import model.dao.VacinaDAO;

public class VacinaController {

    private VacinaDAO vacinaDAO;

    public VacinaController() {
        this.vacinaDAO = new VacinaDAO();
    }

    public void salvarVacina(Vacina vacina) {
        if (validarVacina(vacina)) {
            vacinaDAO.salvar(vacina);
            JOptionPane.showMessageDialog(null, "Vacina salva com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
        }
    }

    public void alterarVacina(Vacina vacina) {
        if (validarVacina(vacina)) {
            vacinaDAO.alterarPorId(vacina);
            JOptionPane.showMessageDialog(null, "Vacina alterada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
        }
    }

    public void excluirVacina(int id) {
        vacinaDAO.excluirPorId(id);
        JOptionPane.showMessageDialog(null, "Vacina excluída com sucesso!");
    }

    public Vacina buscarVacinaPorId(int id) {
        return vacinaDAO.buscarPorId(id);
    }

    public List<Vacina> listarTodasVacinas() {
        return vacinaDAO.listarTodos();
    }

    private boolean validarVacina(Vacina vacina) {
        return vacina.getNome() != null && !vacina.getNome().trim().isEmpty()
            && vacina.getFabricante() != null && !vacina.getFabricante().trim().isEmpty();
    }
}

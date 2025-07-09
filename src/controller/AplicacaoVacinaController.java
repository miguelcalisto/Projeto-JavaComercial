package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.beans.AplicacaoVacina;
import model.beans.Paciente;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;
import model.dao.AplicacaoVacinaDAO;
import model.dao.PacienteDAO;
import model.dao.ProfissionalDeSaudeDAO;
import model.dao.VacinaDAO;

public class AplicacaoVacinaController {

    private final AplicacaoVacinaDAO aplicacaoDAO = new AplicacaoVacinaDAO();
    private final PacienteDAO pacienteDAO = new PacienteDAO();
    private final ProfissionalDeSaudeDAO profissionalDAO = new ProfissionalDeSaudeDAO();
    private final VacinaDAO vacinaDAO = new VacinaDAO();

    private List<Paciente> pacientes = new ArrayList<>();
    private List<ProfissionalDeSaude> profissionais = new ArrayList<>();
    private List<Vacina> vacinas = new ArrayList<>();

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void carregarPacientes(JComboBox<String> combo) {
        pacientes = pacienteDAO.listarTodos();
        combo.removeAllItems();
        for (Paciente p : pacientes) {
            combo.addItem(p.getNome());
        }
    }

    public void carregarProfissionais(JComboBox<String> combo) {
        profissionais = profissionalDAO.listarTodos();
        combo.removeAllItems();
        for (ProfissionalDeSaude p : profissionais) {
            combo.addItem(p.getNome());
        }
    }

    public void carregarVacinas(JComboBox<String> combo) {
        vacinas = vacinaDAO.listarTodos();
        combo.removeAllItems();
        for (Vacina v : vacinas) {
            combo.addItem(v.getNome()); 
        }
    }

    // Getter para listas
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<ProfissionalDeSaude> getProfissionais() {
        return profissionais;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void salvarAplicacao(String data, String local,
                                 Paciente paciente, ProfissionalDeSaude profissional, Vacina vacina) {
        if (data.isEmpty() || local.isEmpty() || paciente == null || profissional == null || vacina == null) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataConvertida = LocalDate.parse(data, formatter);

            AplicacaoVacina aplicacao = new AplicacaoVacina();
            aplicacao.setDataAplicacao(dataConvertida);
            aplicacao.setLocalAplicacao(local);
            aplicacao.setPaciente(paciente);
            aplicacao.setProfissional(profissional);
            aplicacao.setVacina(vacina);

            aplicacaoDAO.salvar(aplicacao);
            JOptionPane.showMessageDialog(null, "Aplicação salva com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar aplicação: " + e.getMessage());
        }
        
        
//        PROBLEMA COM A DATA
//            try {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate data = LocalDate.parse(dataStr, formatter);
//
//        AplicacaoVacina aplicacao = new AplicacaoVacina();
//        aplicacao.setDataAplicacao(java.sql.Date.valueOf(data));
//        aplicacao.setLocalAplicacao(local);
//        aplicacao.setPaciente(paciente);
//        aplicacao.setProfissional(profissional);
//        aplicacao.setVacina(vacina);
//
//        dao.salvar(aplicacao);
//    } catch (DateTimeParseException e) {
//        JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
//    }

    }

    public void excluirAplicacao(int id) {
        aplicacaoDAO.excluirPorId(id);
        JOptionPane.showMessageDialog(null, "Aplicação excluída com sucesso.");
    }

    public List<AplicacaoVacina> listarTodasAplicacoes() {
        return aplicacaoDAO.listarTodos();
    }
}

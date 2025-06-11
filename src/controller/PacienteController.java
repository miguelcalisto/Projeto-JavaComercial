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
import javax.swing.JOptionPane;
import model.beans.Paciente;
import model.dao.PacienteDAO;


public class PacienteController {
    
    private PacienteDAO pacienteDAO;

    public PacienteController() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void cadastrarPaciente(Paciente paciente) {
        if (validarPaciente(paciente)) {
            pacienteDAO.inserir(paciente);
        } else {
            System.out.println("Dados do paciente inválidos!");
        }
    }

    public void atualizarPaciente(Paciente paciente) {
        if (validarPaciente(paciente)) {
            pacienteDAO.alterarPorId(paciente);
        } else {
            System.out.println("Dados do paciente inválidos para atualização!");
        }
    }

    public void excluirPacientePorId(int id) {
        pacienteDAO.excluirPorId(id);
    }

    public Paciente buscarPacientePorId(int id) {
        return pacienteDAO.buscarPorId(id);
    }

    public List<Paciente> listarPacientes() {
        return pacienteDAO.listarTodos();
    }

    private boolean validarPaciente(Paciente paciente) {
//        return paciente.getNome() != null && !paciente.getNome().isEmpty()
//            && paciente.getCpf() != null && paciente.getCpf().isEmpty()
//            && paciente.getTelefone() != null && !paciente.getTelefone().isEmpty()
//            && paciente.getDataNascimento() != null
//            && paciente.getSexo() != null && !paciente.getSexo().isEmpty();
return paciente.getNome() != null && !paciente.getNome().isEmpty()
        && paciente.getCpf() != null && !paciente.getCpf().isEmpty()
        && paciente.getTelefone() != null && !paciente.getTelefone().isEmpty()
        && paciente.getDataNascimento() != null
        && paciente.getSexo() != null && !paciente.getSexo().isEmpty();
    }
}
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

/**
 *
 * @author debian
 */

import model.beans.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PacienteTableModel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "CPF", "Telefone", "Data de Nascimento", "Alergia", "Sexo"};
    private final List<Paciente> pacientes;

    public PacienteTableModel(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Paciente p = pacientes.get(linha);
        return switch (coluna) {
            case 0 -> p.getId();
            case 1 -> p.getNome();
            case 2 -> p.getCpf();
            case 3 -> p.getTelefone();
            case 4 -> p.getDataNascimento();
            case 5 -> p.getAlergia();
            case 6 -> p.getSexo();
            default -> null;
        };
    }

    public Paciente getPaciente(int linha) {
        return pacientes.get(linha);
    }
}

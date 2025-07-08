/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

/**
 *
 * @author debian
 */

import model.beans.ProfissionalDeSaude;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfissionalDeSaudeTableModel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "CPF", "Registro Profissional"};
    private final List<ProfissionalDeSaude> profissionais;

    public ProfissionalDeSaudeTableModel(List<ProfissionalDeSaude> profissionais) {
        this.profissionais = profissionais;
    }

    @Override
    public int getRowCount() {
        return profissionais.size();
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
        ProfissionalDeSaude p = profissionais.get(linha);
        return switch (coluna) {
            case 0 -> p.getId();
            case 1 -> p.getNome();
            case 2 -> p.getCpf();
            case 3 -> p.getRegistroProfissional();
            default -> null;
        };
    }

    public ProfissionalDeSaude getProfissional(int linha) {
        return profissionais.get(linha);
    }
}


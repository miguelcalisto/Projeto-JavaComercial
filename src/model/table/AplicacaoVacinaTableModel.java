package model.table;

import model.beans.AplicacaoVacina;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AplicacaoVacinaTableModel extends AbstractTableModel {

    private final String[] colunas = {
        "ID", "Paciente", "Profissional", "Vacina",
        "Data Aplicação", "Local"
    };

    private List<AplicacaoVacina> aplicacoes;

    public AplicacaoVacinaTableModel(List<AplicacaoVacina> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public int getRowCount() {
        return aplicacoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AplicacaoVacina a = aplicacoes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> a.getId();
            case 1 -> a.getPaciente().getNome();
            case 2 -> a.getProfissional().getNome();
            case 3 -> a.getVacina().getNome();
            case 4 -> a.getDataAplicacao();
            case 5 -> a.getLocalAplicacao();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public AplicacaoVacina getAplicacaoAt(int rowIndex) {
        return aplicacoes.get(rowIndex);
    }

    public void setAplicacoes(List<AplicacaoVacina> aplicacoes) {
        this.aplicacoes = aplicacoes;
        fireTableDataChanged();
    }

    public List<AplicacaoVacina> getAplicacoes() {
    return aplicacoes;
}

}

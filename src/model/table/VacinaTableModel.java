package model.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.beans.Vacina;

public class VacinaTableModel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Fabricante"};
    private List<Vacina> vacinas;

    public VacinaTableModel(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    @Override
    public int getRowCount() {
        return vacinas.size();
    }
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vacina vacina = vacinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vacina.getId();
            case 1:
                return vacina.getNome();
            case 2:
                return vacina.getFabricante();
            default:
                return  null;
    
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Vacina getVacinaAt(int rowIndex) {
        return vacinas.get(rowIndex);
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
        fireTableDataChanged();
    }
}

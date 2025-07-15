package model.table;
/**
 * princiapl continue aqui
 * @author debian
 */
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.beans.ProfissionalDeSaude;
import model.beans.ProfissionalDeSaude;

public class ProfissionalDeSaudeTableModel extends AbstractTableModel {
    
    private java.util.List<ProfissionalDeSaude> listaProfissionaisSaude;
    private String[] colunas = {"Nome", "CPF", "Registro Profissional"};
    
    public ProfissionalDeSaudeTableModel(){   
        listaProfissionaisSaude = new ArrayList<>();
    }
    
    public ProfissionalDeSaudeTableModel(java.util.List<ProfissionalDeSaude> profissionaisSaude){
        this();
        this.listaProfissionaisSaude.addAll(profissionaisSaude);
    }
    
    @Override
    public int getRowCount(){
        return listaProfissionaisSaude.size();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        ProfissionalDeSaude profissionalSaude = listaProfissionaisSaude.get(linha);
        switch(coluna){
            case 0:
                return profissionalSaude.getNome();
            case 1:
                return profissionalSaude.getCpf();
            case 2:
                return profissionalSaude.getRegistroProfissional();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public ProfissionalDeSaude getProfissionalSaude(int linha){
        if (linha >= listaProfissionaisSaude.size()){
            return null;
        }
        return listaProfissionaisSaude.get(linha);
    }
}

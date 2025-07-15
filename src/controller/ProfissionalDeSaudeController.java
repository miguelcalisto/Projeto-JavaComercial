package controller;
/**
 * princiapl continue aqui
 * @author debian
 */
import java.util.ArrayList;
import model.beans.ProfissionalDeSaude;
import model.dao.ProfissionaDelSaudeDAO;

public class ProfissionalDeSaudeController {
    
    public boolean create(String nome, String cpf, String registroProfissional){
        ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
        profissionalDeSaude.setNome(nome);
        profissionalDeSaude.setCpf(cpf);
        profissionalDeSaude.setRegistroProfissional(registroProfissional);
        
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.create(profissionalDeSaude);
    }
    
    public ArrayList<ProfissionalDeSaude> read(){
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.read();
    }
    
    public ArrayList<ProfissionalDeSaude> getProfissionalNome(String nome){
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.getProfissionalNome(nome);
    }
    
    public ArrayList<ProfissionalDeSaude> getProfissionalCpf(String cpf){
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.getProfissionalCpf(cpf);
    }
    
    public ArrayList<ProfissionalDeSaude> getProfissionalRegistro(String registro){
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.getProfissionalRegistro(registro);
    }
    
    public boolean update(int id, String cpf, String registroProfissional, String nome){
        ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
        profissionalDeSaude.setId(id);
        profissionalDeSaude.setCpf(cpf);
        profissionalDeSaude.setRegistroProfissional(registroProfissional);
        profissionalDeSaude.setNome(nome);
        
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.update(profissionalDeSaude);
    }
    
    public boolean delete(int id){
        ProfissionalDeSaude profissionalDeSaude = new ProfissionalDeSaude();
        profissionalDeSaude.setId(id);
        
        ProfissionaDelSaudeDAO profissionalDeSaudeDAO = new ProfissionaDelSaudeDAO();
        return profissionalDeSaudeDAO.delete(profissionalDeSaude);
    }
}

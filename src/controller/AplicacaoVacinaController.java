package controller;

import java.util.ArrayList;
import model.beans.AplicacaoVacina;
import model.beans.Paciente;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;
import model.beans.AplicacaoVacina;
import model.beans.Paciente;
import model.beans.ProfissionalDeSaude;
import model.beans.Vacina;
import model.dao.AplicacaoVacinaDAO;

public class AplicacaoVacinaController {
    
    public boolean create(Paciente paciente, ProfissionalDeSaude profissionalSaude, Vacina vacina, String dataAplicacao, String localAplicacao){
        AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
        aplicacaoVacina.setPaciente(paciente);
        aplicacaoVacina.setResponsavel(profissionalSaude);
        aplicacaoVacina.setVacina(vacina);
        aplicacaoVacina.setDataAplicacao(dataAplicacao);
        aplicacaoVacina.setLocalAplicacao(localAplicacao);
        
        AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
        return aplicacaoVacinaDAO.create(aplicacaoVacina);
    }
    
    public ArrayList<AplicacaoVacina> getAplicacaoVacina(int pacienteId){
        AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
        return aplicacaoVacinaDAO.getAplicacaoVacina(pacienteId);
    }
    
    public boolean update(Paciente paciente, ProfissionalDeSaude profissionalSaude, Vacina vacina, String dataAplicacao, String localAplicacao){
        AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
        aplicacaoVacina.setPaciente(paciente);
        aplicacaoVacina.setResponsavel(profissionalSaude);
        aplicacaoVacina.setVacina(vacina);
        aplicacaoVacina.setDataAplicacao(dataAplicacao);
        aplicacaoVacina.setLocalAplicacao(localAplicacao);
        
        AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
        return aplicacaoVacinaDAO.update(aplicacaoVacina);
    }
    
//    public boolean delete(int idvacina, int idprofissional, int idpaciente){
//        AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
//        
//        Paciente paciente = new Paciente();
//        paciente.setId(idpaciente);
//        
//        ProfissionalDeSaude profissionalSaude = new ProfissionalDeSaude();
//        profissionalSaude.setId(idprofissional);
//        
//        Vacina vacina = new Vacina();
//        vacina.setId(idvacina);
//        
//        aplicacaoVacina.setPaciente(paciente);
//        aplicacaoVacina.setResponsavel(profissionalSaude);
//        aplicacaoVacina.setVacina(vacina);
//        
//        AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
//        return aplicacaoVacinaDAO.delete(aplicacaoVacina);
//}
//}
    
public boolean delete(int idAplicacaoVacina) {
    AplicacaoVacinaDAO aplicacaoVacinaDAO = new AplicacaoVacinaDAO();
    return aplicacaoVacinaDAO.delete(idAplicacaoVacina);
}}
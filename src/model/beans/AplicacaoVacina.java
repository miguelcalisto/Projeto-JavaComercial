package model.beans;

import java.time.LocalDate;

public class AplicacaoVacina {

    private int id;
    private Paciente paciente;
    private ProfissionalDeSaude profissional;
    private Vacina vacina;
    private LocalDate dataAplicacao;
    private String localAplicacao;

    public AplicacaoVacina() {
    }

    public AplicacaoVacina(int id, Paciente paciente, ProfissionalDeSaude profissional, Vacina vacina, LocalDate dataAplicacao, String localAplicacao) {
        this.id = id;
        this.paciente = paciente;
        this.profissional = profissional;
        this.vacina = vacina;
        this.dataAplicacao = dataAplicacao;
        this.localAplicacao = localAplicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalDeSaude getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalDeSaude profissional) {
        this.profissional = profissional;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getLocalAplicacao() {
        return localAplicacao;
    }

    public void setLocalAplicacao(String localAplicacao) {
        this.localAplicacao = localAplicacao;
    }
}

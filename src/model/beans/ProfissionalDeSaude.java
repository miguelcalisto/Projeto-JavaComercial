package model.beans;

public class ProfissionalDeSaude {
    private int id;
    private String nome;
    private String cpf;
    private int registroProfissional;

    public ProfissionalDeSaude() {
    }

    public ProfissionalDeSaude(int id, String nome, String cpf, int registroProfissional) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.registroProfissional = registroProfissional;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(int registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
}

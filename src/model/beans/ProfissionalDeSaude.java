package model.beans;

public class ProfissionalDeSaude {
    int id;
    String registroProfissional;
    String cpf;
    String nome;
    
    public ProfissionalDeSaude(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ProfissionalDeSaude outro = (ProfissionalDeSaude) obj;
    return id == outro.id;
}

@Override
public int hashCode() {
    return Integer.hashCode(id);
}

    @Override
    public String toString(){
        return nome;
    }
    
}

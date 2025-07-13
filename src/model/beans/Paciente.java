
package model.beans;

public class Paciente {
    int id;
    String telefone;
    String dataNascimento;
    String alergias;
    String sexo;
    String cpf;
    String nome;
    
    public Paciente(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    
    
//    @Override
//public boolean equals(Object obj) {
//    if (this == obj) return true;
//    if (obj == null || getClass() != obj.getClass()) return false;
//    Paciente other = (Paciente) obj;
//    return this.id == other.id;
//}
//@Override
//public int hashCode() {
//    return Integer.hashCode(id);
//}
//
//    
//    @Override
//public String toString() {
//    return nome; // ou getNome(), se preferir
//}
    
    
    
@Override
public String toString() {
    return nome; // usado no JComboBox
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Paciente paciente = (Paciente) o;
    return id == paciente.id;
}

@Override
public int hashCode() {
    return Integer.hashCode(id);
}


}

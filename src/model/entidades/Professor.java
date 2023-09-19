package model.entidades;

import java.io.Serializable;

public class Professor implements Serializable{
    private String nome;
    private String matricula;
    private String email;
    private int cargaHorariaSemanal;
    private String titulacao;

    
    public Professor() {
    }
    
    public Professor(String nome, String matricula, String titulacao, String email, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cargaHorariaSemanal = 0;
        this.titulacao = titulacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal += cargaHorariaSemanal;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
}

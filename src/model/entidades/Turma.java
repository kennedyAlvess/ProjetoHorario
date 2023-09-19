package model.entidades;

import java.io.Serializable;

public class Turma  implements Serializable{
    private String nome;
    private int vagas;
    private String horarios;
    private int turma;
    private String codTurma;
    private String docente;
    private int semestre;
    private int cargahoraria;


    public Turma(int cargahoraria,int semestre,String docente,String nome, int vagas, String horarios, int turma, String codTurma) {
        this.docente = docente;
        this.nome = nome;
        this.vagas = vagas;
        this.horarios = horarios;
        this.turma = turma;
        this.codTurma = codTurma;
        this.semestre = semestre;
        this.cargahoraria = cargahoraria;
    }

    public Turma() {

    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }
    
    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}

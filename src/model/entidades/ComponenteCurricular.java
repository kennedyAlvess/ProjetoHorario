package model.entidades;

import java.io.Serializable;

public class ComponenteCurricular implements Serializable {
    private String nome;
    private int cargaHoraria;
    private String codigo;
    private int semestre;
    private String obrigatoriedade;


    public ComponenteCurricular() {
    }

    public ComponenteCurricular(String nome,String codigo,int cargaHoraria,int semestre,String obrigatoriedade) {
        this.semestre = semestre;
        this.obrigatoriedade = obrigatoriedade;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getObrigatoriedade() {
        return obrigatoriedade;
    }

    public void setObrigatoriedade(String obrigatoriedade) {
        this.obrigatoriedade = obrigatoriedade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}

package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Turma  implements Serializable{
    private String nome;
    private int vagas;
    private String horarios;
    private int turma;
    private String periodo;
    private String codTurma;
    private List<String> docentes;



    public Turma(String[] docente,String nome, int vagas, String horarios, int turma, String periodo, String codTurma) {
        this.docentes = new LinkedList<>();
        this.nome = nome;
        this.vagas = vagas;
        this.horarios = horarios;
        this.turma = turma;
        this.periodo = periodo;
        this.codTurma = codTurma;
        for (int i = 0; i < docente.length; i++) {
            adicionarDocente(docente[i]);
        }
    }

    public Turma() {
        this.docentes = new ArrayList<>();
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<String> getDocentes() {
        return docentes;
    }

    public void removerDocente(String docente){
        Iterator<String> iteratorDocente = docentes.iterator();
        while(iteratorDocente.hasNext()){
            if(iteratorDocente.next() == docente ){
                iteratorDocente.remove();
                break;
            }
        }
    }

    public void adicionarDocente(String docente){
        this.docentes.add(docente);
    }

}

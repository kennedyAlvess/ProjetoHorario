package model.entidades;

import java.util.Iterator;
import java.util.LinkedList;

public class Turma  {
    private String nome;
    private short vagas;
    private String horarios;
    private short turma;
    private String periodo;
    private LinkedList<Professor> docentes;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getVagas() {
        return vagas;
    }

    public void setVagas(short vagas) {
        this.vagas = vagas;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public short getTurma() {
        return turma;
    }

    public void setTurma(short turma) {
        this.turma = turma;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public LinkedList<Professor> getDocentes() {
        return docentes;
    }

    public void remover(String nomeDisciplina){
        Iterator<Professor> interatorDocente = docentes.iterator();
        while(interatorDocente.hasNext()){
            if(nomeDisciplina == interatorDocente.next().getNome()){
                interatorDocente.remove();
            }
        }
    }

    public void adicionar(Professor docente){
        docentes.add(docente);
    }

}

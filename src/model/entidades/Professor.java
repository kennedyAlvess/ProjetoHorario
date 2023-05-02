package model.entidades;

import java.util.Iterator;
import java.util.LinkedList;

public class Professor {
    private String nome;
    private int matricula;
    private String email;
    private short cargaHorariaSemanal;
    private String titulacao;
    private LinkedList<Turma> turmas;
    private String telefone;



    public Professor(String nome, int matricula, String email, String titulacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.titulacao = titulacao;
    }

    public Professor(String nome, int matricula, String email, String titulacao, String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.titulacao = titulacao;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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

    public void setCargaHorariaSemanal(short cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    public LinkedList<Turma> getturmas() {
        return turmas;
    }
    
    public void removerDisciplina(String nomeDisciplina){
        Iterator<Turma> interatorDisciplina = turmas.iterator();
        while(interatorDisciplina.hasNext()){
            if(nomeDisciplina == interatorDisciplina.next().getNome()){
                interatorDisciplina.remove();
            }
        }
    }
    
    public void addDisciplina(Turma disciplina){
        turmas.add(disciplina);
    }
}

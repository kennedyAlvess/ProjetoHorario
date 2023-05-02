package model.entidades;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Professor implements Serializable{
    private String nome;
    private int matricula;
    private String email;
    private short cargaHorariaSemanal;
    private String titulacao;
    private LinkedList<String> turmas;
    private String telefone;



    

    public Professor() {
    }

    
    public Professor(String nome, int matricula, String email, short cargaHorariaSemanal, String titulacao,
            String telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.titulacao = titulacao;
        this.telefone = telefone;
    }


    public Professor(String[] turma,String nome, int matricula, String email, String titulacao, String telefone) {
        this.turmas = new LinkedList<>();
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.titulacao = titulacao;
        this.telefone = telefone;
        for (int i = 0; i < turma.length; i++) {
            addTurma(turma[i]);
        }
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
    
    public LinkedList<String> getturmas() {
        return turmas;
    }
    
    public void removerTurma(String nomeDisciplina){
        Iterator<String> interatorDisciplina = turmas.iterator();
        while(interatorDisciplina.hasNext()){
            if(nomeDisciplina == interatorDisciplina.next()){
                interatorDisciplina.remove();
                break;
            }
        }
    }
    
    public void addTurma(String turma){
        turmas.add(turma);
    }
}

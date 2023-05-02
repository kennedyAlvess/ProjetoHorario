package model.entidades;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;



public class ComponenteCurricular implements Serializable {
    private String nome;
    private short cargaHoraria;
    private String codigo;
    private String preRequisito;
    private String modalidade;
    private LinkedList<String> equivalentes;
 

    public ComponenteCurricular() {
    }

    public ComponenteCurricular(String nome, short cargaHoraria, String codigo, String modalidade) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.modalidade = modalidade;
    }

    public ComponenteCurricular(String nome, short cargaHoraria, String codigo, String modalidade,
            LinkedList<String> equivalentes) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.modalidade = modalidade;
        this.equivalentes = equivalentes;
    }

    public ComponenteCurricular(String nome,String codigo, short cargaHoraria, String preRequisito, String modalidade) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.preRequisito = preRequisito;
        this.modalidade = modalidade;
    }
    public ComponenteCurricular(String nome, short cargaHoraria, String codigo, String preRequisito, String modalidade, String[] equivalentes) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.preRequisito = preRequisito;
        this.modalidade = modalidade;
        this.equivalentes = new LinkedList<>();
        for (int i = 0; i < equivalentes.length; i++) {
            addEquivalente(equivalentes[i]);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(short cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public String getmodalidade() {
        return modalidade;
    }

    public void setmodalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public LinkedList<String> getEquivalentes() {
        return equivalentes;
    }

    public void addEquivalente(String equivalente){
        this.equivalentes.add(equivalente);
    }

    public void removerEquivalente(String equivalente){
        Iterator<String> iteratorEquivalentes = equivalentes.iterator();
        while(iteratorEquivalentes.hasNext()){
            if(iteratorEquivalentes.next() == equivalente ){
                iteratorEquivalentes.remove();
                break;
            }
        }
    }

}

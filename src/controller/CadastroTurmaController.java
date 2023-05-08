package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.entidades.Turma;

public class CadastroTurmaController implements Initializable{

    @FXML
    private TextField TextFieldTurmaCodigo;
    @FXML
    private TextField TextFieldTurmaDocente;
    @FXML
    private TextField TextFieldTurmaNome;
    @FXML
    private TextField TextFieldTurmaHorario;
    @FXML
    private TextField TextFieldTurmaTurma;
    @FXML
    private TextField TextFieldTurmaVagas;
    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoConfirmar;
    @FXML
    private Label labelTituloTurma;
    @FXML
    private TextField TextFieldTurmaHora;
    @FXML
    private TextField TextFieldTurmaSemestre;

    private Stage interacao;
    private boolean botaoConfirmarClicado;
    private Turma turma;
    private boolean alterar;
    private List<Turma> listaDeTurmas;
    private List<String> listaDeProfessores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }

    @FXML
    public void handleBotaoConfirmar(){
        if (validarEntradaDeDados()) {
            turma.setCodTurma(TextFieldTurmaCodigo.getText());
            turma.setNome(TextFieldTurmaNome.getText());
            turma.setDocente(TextFieldTurmaDocente.getText());
            turma.setHorarios(TextFieldTurmaHorario.getText());
            turma.setVagas(Integer.parseInt(TextFieldTurmaVagas.getText()));
            turma.setTurma(Integer.parseInt(TextFieldTurmaTurma.getText()));
            turma.setCargahoraria(Integer.parseInt(TextFieldTurmaHora.getText()));
            turma.setSemestre(Integer.parseInt(TextFieldTurmaSemestre.getText()));
            botaoConfirmarClicado = true;
            interacao.close();
        }
    }
    @FXML
    public void handleBotaoCancelar(){
        interacao.close();
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
        this.TextFieldTurmaNome.setText(turma.getNome());
        this.TextFieldTurmaCodigo.setText(turma.getCodTurma());
        this.TextFieldTurmaDocente.setText(turma.getDocente());
        this.TextFieldTurmaHorario.setText(turma.getHorarios());
        this.TextFieldTurmaTurma.setText(String.valueOf(turma.getTurma()));
        this.TextFieldTurmaVagas.setText(String.valueOf(turma.getVagas()));
        this.TextFieldTurmaHora.setText(String.valueOf(turma.getCargahoraria()));
        this.TextFieldTurmaSemestre.setText(String.valueOf(turma.getCargahoraria()));
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if(alterar == false){
            if (TextFieldTurmaNome.getText() == null || TextFieldTurmaNome.getText().length() == 0) {
                errorMessage += "Nome inválido!\n";
            }
            if (  TextFieldTurmaCodigo.getText() == null || TextFieldTurmaCodigo.getText().length() < 0 ) {
                errorMessage += "Código inválido! *\n";  
            }
            if (TextFieldTurmaDocente.getText() == null || TextFieldTurmaDocente.getText().length() == 0) {
                errorMessage += "Docente inválido!\n";
            }
            if (TextFieldTurmaTurma.getText() == null || TextFieldTurmaTurma.getText().length() == 0){
                errorMessage += "Turma invalida";
            }
            if (TextFieldTurmaVagas.getText() == null || TextFieldTurmaVagas.getText().length() == 0){
                errorMessage += "Vagas inválidas";
            }
            if (TextFieldTurmaSemestre.getText() == null || TextFieldTurmaSemestre.getText().length() == 0){
                errorMessage += "Semestre inválido";
            }
            if (TextFieldTurmaHorario.getText() == null || TextFieldTurmaHorario.getText().length() == 0){
                errorMessage += "Horário inválido";
            }
            if (TextFieldTurmaHora.getText() == null || TextFieldTurmaHora.getText().length() == 0){
                errorMessage += "Carga horária inválida";
            }
            for (Turma turma : listaDeTurmas) {
                String horarioText="",horarioTurma ="";
                if((TextFieldTurmaSemestre.getText() == String.valueOf(turma.getSemestre()) && TextFieldTurmaTurma.getText() == String.valueOf(turma.getTurma())) || TextFieldTurmaDocente.getText() == turma.getDocente()){
                    if(TextFieldTurmaHorario.getText().length() == 5 || turma.getHorarios().length() == 5){
                        if(TextFieldTurmaHorario.getText().length() == 5){
                            horarioText = TextFieldTurmaHorario.getText().substring(0, 1)+TextFieldTurmaHorario.getText().substring(2, 5)+" "+TextFieldTurmaHorario.getText().substring(1, 5);
                        }if(turma.getHorarios().length() == 5){
                            horarioTurma = turma.getHorarios().substring(0, 1)+turma.getHorarios().substring(2, 5)+" "+turma.getHorarios().substring(1, 5);
                        }else if(TextFieldTurmaHorario.getText().length() == 5 || turma.getHorarios().length() == 5){
                            if(TextFieldTurmaHorario.getText().length() == 6){
                                horarioText = TextFieldTurmaHorario.getText().substring(0, 1)+TextFieldTurmaHorario.getText().substring(4, 6)+" "+TextFieldTurmaHorario.getText().substring(0, 4);
        
                            }if(turma.getHorarios().length() == 6){
                                horarioTurma = turma.getHorarios().substring(0, 1)+turma.getHorarios().substring(4, 6)+" "+turma.getHorarios().substring(0, 0);
                            }    
                        }
                        if(horarioTurma.contains(horarioText.substring(0, 4)) || horarioTurma.contains(horarioText.substring(5, 9))){
                            errorMessage += "Horário inválido! Turma com mesmo horário e semestre ja existente ou professor com horário ja preenchido\n";
                        }
                    }
                }
            } 
            if(listaDeProfessores.contains(TextFieldTurmaNome.getText())){
                errorMessage += "Professor com carga horária semanal lotada!\n";
            }
        }else{
            if (TextFieldTurmaNome.getText() == null || TextFieldTurmaNome.getText().length() == 0) {
                errorMessage += "Nome inválido!\n";
            }
            if (  TextFieldTurmaCodigo.getText() == null || TextFieldTurmaCodigo.getText().length() < 0 ) {
                errorMessage += "Código inválido! *\n";  
            }
            if (TextFieldTurmaDocente.getText() == null || TextFieldTurmaDocente.getText().length() == 0) {
                errorMessage += "Docente inválido!\n";
            }
            if (TextFieldTurmaTurma.getText() == null || TextFieldTurmaTurma.getText().length() == 0){
                errorMessage += "Turma inválida";
            }
            if (TextFieldTurmaVagas.getText() == null || TextFieldTurmaVagas.getText().length() == 0){
                errorMessage += "Vagas inválidas";
            }
            if (TextFieldTurmaSemestre.getText() == null || TextFieldTurmaSemestre.getText().length() == 0){
                errorMessage += "Semestre inválido";
            }
            if (TextFieldTurmaHorario.getText() == null || TextFieldTurmaHorario.getText().length() == 0){
                errorMessage += "Horário inválido";
            }
            if (TextFieldTurmaHora.getText() == null || TextFieldTurmaHora.getText().length() == 0){
                errorMessage += "Carga horária inválida";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    public void setLabelTituloTurma(String titulo) {
        this.labelTituloTurma.setText(titulo);
    }
    public Stage getInteracao() {
        return interacao;
    }
    public void setInteracao(Stage interacao) {
        this.interacao = interacao;
    }
    public boolean isBotaoClicado() {
        return botaoConfirmarClicado;
    }
    public void setBotaoClicado(boolean botaoClicado) {
        this.botaoConfirmarClicado = botaoClicado;
    }
    public Turma getTurma() {
        return turma;
    }
    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }
    public void setListaDeTurmas(List<Turma> listaDeTurmas) {
        this.listaDeTurmas = listaDeTurmas;
    }
    public void setListaDeProfessores(List<String> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }
}


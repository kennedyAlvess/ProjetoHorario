package controller;

import java.net.URL;
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
    private TextField TextFieldTurmaPeriodo;

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


    private Stage interacao;
    private boolean botaoConfirmarClicado;
    private Turma turma;
    
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
            turma.setPeriodo(TextFieldTurmaPeriodo.getText());
            turma.setVagas(Integer.parseInt(TextFieldTurmaVagas.getText()));
            turma.setTurma(Integer.parseInt(TextFieldTurmaTurma.getText()));
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
        this.TextFieldTurmaPeriodo.setText(turma.getPeriodo());
        
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if (TextFieldTurmaNome.getText() == null || TextFieldTurmaNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (  TextFieldTurmaCodigo.getText() == null || TextFieldTurmaCodigo.getText().length() < 0 ) {
            errorMessage += "Código inválido! *\n";  
        }
        if (TextFieldTurmaDocente.getText() == null || TextFieldTurmaDocente.getText().length() == 0) {
            errorMessage += "Docente inválido!\n";
        }
        if (TextFieldTurmaPeriodo.getText() == null || TextFieldTurmaPeriodo.getText().length() == 0){
            errorMessage += "Périodo inválido";
        }
        if (TextFieldTurmaTurma.getText() == null || TextFieldTurmaTurma.getText().length() == 0){
            errorMessage += "Turma invalida";
        }
        if (TextFieldTurmaVagas.getText() == null || TextFieldTurmaVagas.getText().length() == 0){
            errorMessage += "Vagas invalidas";
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



}


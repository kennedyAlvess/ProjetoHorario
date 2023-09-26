package controller;

import model.entidades.Professor;

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

public class CadastroProfessorController implements Initializable {

    @FXML
    private TextField TextFieldProfessorEmail;
    @FXML
    private TextField TextFieldProfessorMat;
    @FXML
    private TextField TextFieldProfessorNome;
    @FXML
    private TextField TextFieldProfessorTitulo;
    @FXML
    private Button botaoCancelar;
    @FXML
    private Button botaoConfirmar;
    @FXML
    private Label labelTituloProfessor;
    @FXML
    private Label labelProfessorEmail;
    @FXML
    private Label labelProfessorMat;
    @FXML
    private Label labelProfessorNome;
    @FXML
    private Label labelProfessorTitulo;
    
    private Stage interacao;
    private boolean botaoConfirmarClicado;
    private Professor professor;
    private List<String> validarProfessor;
    private boolean alterar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleBotaoConfirmar(){
        if (validarEntradaDeDados()) {
            professor.setNome(TextFieldProfessorNome.getText());
            professor.setMatricula(TextFieldProfessorMat.getText());
            professor.setTitulacao(TextFieldProfessorTitulo.getText());
            professor.setEmail(TextFieldProfessorEmail.getText());
            botaoConfirmarClicado = true;
            interacao.close();
        }
    }

    @FXML
    public void handleBotaoCancelar(){
        interacao.close();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
        this.TextFieldProfessorNome.setText(professor.getNome());
        this.TextFieldProfessorMat.setText(professor.getMatricula());
        this.TextFieldProfessorTitulo.setText(professor.getTitulacao());
        this.TextFieldProfessorEmail.setText(professor.getEmail());
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if(alterar){
            if (TextFieldProfessorMat.getText() == null || TextFieldProfessorMat.getText().length() != 10 || !TextFieldProfessorMat.getText().matches("[0-9]*")) {
                errorMessage += "Matrícula inválida!*\n";  
            }
        }else{
            if (validarProfessor.contains(TextFieldProfessorMat.getText()) || TextFieldProfessorMat.getText() == null || TextFieldProfessorMat.getText().length() != 10 || !TextFieldProfessorMat.getText().matches("[0-9]*")) {
                errorMessage += "Matrícula inválida!*\n";  
            }
        }
        if (TextFieldProfessorNome.getText() == null || TextFieldProfessorNome.getText().length() == 0) {
            errorMessage += "Nome inválido!*\n";
        }
        
        if (TextFieldProfessorTitulo.getText() == null || TextFieldProfessorTitulo.getText().length() == 0) {
            errorMessage += "Titulação inválida!*\n";
        }
        if (TextFieldProfessorEmail.getText() == null || TextFieldProfessorEmail.getText().length() == 0){
            errorMessage += "E-mail inválido*\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    public void setLabelTituloProfessor(String titulo) {
        this.labelTituloProfessor.setText(titulo);
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
    public Professor getProfessor() {
        return professor;
    }
    public void setValidarProfessor(List<String> validarProfessor) {
        this.validarProfessor = validarProfessor;
    }
    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

}

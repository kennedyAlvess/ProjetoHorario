package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private Label labelProfessorEmail;

    @FXML
    private Label labelProfessorMat;

    @FXML
    private Label labelProfessorNome;

    @FXML
    private Label labelProfessorTitulo;

    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }



}

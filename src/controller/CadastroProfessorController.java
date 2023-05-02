package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entidades.Professor;

public class CadastroProfessorController implements Initializable{

    /*Incluido todos os componentes criados na Interface Grafica como atributos na classe */
    @FXML
    private TableView<Professor> tableProfessores;
    @FXML
    private TableColumn<Professor, String> tableNomeProfessores;
    @FXML
    private Button botaoAlterar;
    @FXML
    private Button botaoRemover;
    @FXML
    private Label labelProfessorNome;
    @FXML
    private Label labelProfessorMatricula;
    @FXML
    private Label labelProfessorTitulacao;
    @FXML
    private Label labelProfessorEmail;
    @FXML
    private Label labelProfessorTelefone;

    private List<Professor> listProfessores; 
    private ObservableList<Professor> observableListProfessores;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}

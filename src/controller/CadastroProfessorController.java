package controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import model.dao.ProfessorDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.Professor;

public class CadastroProfessorController implements Initializable{

    /*Incluido todos os componentes criados na Interface Grafica como atributos na classe */
    @FXML
    private TableView<Professor> tableViewProfessores;
    @FXML
    private TableColumn<Professor,String> colunaNomeProfessores;
    @FXML
    private TableColumn<Professor,String> colunaMatProfessores;
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

    private List<Professor> listProfessores; 
    private ObservableList<Professor> observableListProfessores;

    //Manipulando banco de dados
    private final Database database = new DatabasePostgreSQL();
    private final Connection connection = database.conectar();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        professorDAO.setConnection(connection);
        carregarTableViewProfessor();
    }

    public void carregarTableViewProfessor(){
        colunaNomeProfessores.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaMatProfessores.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        listProfessores = professorDAO.listar();

        observableListProfessores = FXCollections.observableArrayList(listProfessores);
        tableViewProfessores.setItems(observableListProfessores);
    }
    
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.dao.ProfessorDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.Professor;

public class ProfessorMenuController implements Initializable{

    /*Incluido todos os componentes criados na Interface Grafica como atributos na classe */
    @FXML
    private TableView<Professor> tableViewProfessor;
    @FXML
    private TableColumn<Professor,String> colunaNomeProfessor;
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
        tableViewProfessor.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue
        ) -> selecionarItemTableViewProfessor(newValue));
    }
    public void carregarTableViewProfessor(){
        colunaNomeProfessor.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listProfessores = professorDAO.listar();
        observableListProfessores = FXCollections.observableArrayList(listProfessores);
        tableViewProfessor.setItems(observableListProfessores);
    }
    
    public void selecionarItemTableViewProfessor(Professor professor){
        if (professor != null) {
            labelProfessorNome.setText(professor.getNome());
            labelProfessorMatricula.setText(String.valueOf(professor.getMatricula()));
            labelProfessorTitulacao.setText(professor.getTitulacao());
            labelProfessorEmail.setText(professor.getEmail());          
        } else {
            labelProfessorNome.setText("");
            labelProfessorMatricula.setText("");
            labelProfessorTitulacao.setText("");
            labelProfessorEmail.setText("");
        }

    }

    @FXML
    public void handleBotaoCadastrar() throws IOException {
        Professor professor = new Professor();
        boolean botaoConfirmarClicado = showCadastroProfessor(professor);
        if (botaoConfirmarClicado) {
            professorDAO.inserir(professor);
            carregarTableViewProfessor();
        }
    }

    @FXML
    public void handleBotaoAlterar() throws IOException {
        Professor professor = tableViewProfessor.getSelectionModel().getSelectedItem();
        if (professor != null) {
            boolean buttonConfirmarClicked = showCadastroProfessor(professor);
            if (buttonConfirmarClicked) {
                professorDAO.alterar(professor);
                carregarTableViewProfessor();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um professor na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Professor professor = tableViewProfessor.getSelectionModel().getSelectedItem();
        if (professor != null) {
            professorDAO.remover(professor);
            carregarTableViewProfessor();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um professor na Tabela!");
            alert.show();
        }
    }
    
    public boolean showCadastroProfessor(Professor professor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroProfessorController.class.getResource("/view/CadastroProfessor.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de professor");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        CadastroProfessorController controller = loader.getController();
        controller.setInteracao(dialogStage);
        controller.setProfessor(professor);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isBotaoClicado();
    }


}

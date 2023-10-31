package controller;

import model.dao.ProfessorDAO;
import model.entidades.Professor;

import java.io.IOException;
import java.net.URL;
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


public class ProfessorMenuController implements Initializable{

    @FXML
    private TableView<Professor> tableViewProfessor;
    @FXML
    private TableColumn<Professor,String> colunaNomeProfessor;
    @FXML
    private Button botaoAlterar;
    @FXML
    private Button botaoRemover;
    @FXML
    private Button botaoCadastrar;
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
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        carregarTableViewProfessor();
        tableViewProfessor.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue
        ) -> selecionarItemTableViewProfessor(newValue));
    }

    public void carregarTableViewProfessor(){
        colunaNomeProfessor.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listProfessores = ProfessorDAO.listar();
        observableListProfessores = FXCollections.observableArrayList(listProfessores);
        tableViewProfessor.setItems(observableListProfessores);
    }
    
    public void selecionarItemTableViewProfessor(Professor professor){
        if (professor != null) {
            labelProfessorNome.setText(professor.getNome());
            labelProfessorMatricula.setText(professor.getMatricula());
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
        final String nome = "CADASTRAR PROFESSOR";
        Professor professor = new Professor();
        boolean botaoConfirmarClicado = showCadastroProfessor(professor,nome);
        if (botaoConfirmarClicado) {
            ProfessorDAO.inserir(professor);
            carregarTableViewProfessor();
        }
    }

    @FXML
    public void handleBotaoAlterar() throws IOException {
        final String nome = "ALTERAR PROFESSOR";
        Professor professor = tableViewProfessor.getSelectionModel().getSelectedItem();
        if (professor != null) {
            boolean botaoConfirmarClicado = showCadastroProfessor(professor,nome);
            if (botaoConfirmarClicado) {
                ProfessorDAO.alterar(professor);
                carregarTableViewProfessor();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um professor na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBotaoRemover() throws IOException {
        Professor professor = tableViewProfessor.getSelectionModel().getSelectedItem();
        if (professor != null) {
            ProfessorDAO.remover(professor);
            carregarTableViewProfessor();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(professor.getNome()+" REMOVIDO COM SUCESSO!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um professor na Tabela!");
            alert.show();
        }
    }
   
    public boolean showCadastroProfessor(Professor professor,String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroProfessorController.class.getResource("/view/CadastroProfessor.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle(nome);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        
        CadastroProfessorController controller = loader.getController();
        if(nome.equals("ALTERAR PROFESSOR")){
            controller.setAlterar(true);
        }else{
            controller.setAlterar(false);
        }
        controller.setInteracao(dialogStage);
        controller.setProfessor(professor);
        controller.setLabelTituloProfessor(nome);
        controller.setValidarProfessor(ProfessorDAO.validarProfessorMat());
        dialogStage.showAndWait();

        return controller.isBotaoClicado();
    }
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import model.dao.ComponenteCurricularDAO;
import model.dao.ProfessorDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.ComponenteCurricular;
import model.entidades.Professor;

public class CCmenuController implements Initializable{

  
    @FXML
    private Button botaoAlterarCC;

    @FXML
    private Button botaoCadastrarCC;

    @FXML
    private Button botaoRemoverCC;

    @FXML
    private TableColumn<ComponenteCurricular, String> colunaNomeCC;

    @FXML
    private Label labelCCcargahoraria;

    @FXML
    private Label labelCCnome;

    @FXML
    private Label labelCCobrigatoriedade;

    @FXML
    private Label labelCCsemestre;

    @FXML
    private TableView<ComponenteCurricular> tableViewCC;

    private List<ComponenteCurricular> listComponenteCurricular; 
    private ObservableList<ComponenteCurricular> observableListComponenteCurricular;

    //Manipulando banco de dados
    private final Database database = new DatabasePostgreSQL();
    private final Connection connection = database.conectar();
    private final ComponenteCurricularDAO componenteCurricularDAO = new ComponenteCurricularDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        componenteCurricularDAO.setConnection(connection);
        carregarTableViewCC();
        tableViewCC.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue
        ) -> selecionarItemTableViewCC(newValue));
    }
    public void carregarTableViewCC(){
        colunaNomeCC.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listComponenteCurricular = componenteCurricularDAO.listar();
        observableListComponenteCurricular = FXCollections.observableArrayList(listComponenteCurricular);
        tableViewCC.setItems(observableListComponenteCurricular);
    }
    
    public void selecionarItemTableViewCC(ComponenteCurricular componenteCurricular){
        if (componenteCurricular != null) {
            labelCCnome.setText(componenteCurricular.getNome());
            labelCCcargahoraria.setText(String.valueOf(componenteCurricular.getCargaHoraria()));
            labelCCsemestre.setText(String.valueOf(componenteCurricular.getSemestre()));
            labelCCobrigatoriedade.setText(componenteCurricular.getObrigatoriedade());          
        } else {
            labelCCnome.setText("");
            labelCCcargahoraria.setText("");
            labelCCsemestre.setText("");
            labelCCobrigatoriedade.setText("");
        }

    }

    // @FXML
    // public void handleBotaoCadastrar() throws IOException {
    //     ComponenteCurricular componenteCurricular = new ComponenteCurricular();
    //     boolean botaoConfirmarClicado = showCadastroCC(componenteCurricular);
    //     if (botaoConfirmarClicado) {
    //         componenteCurricularDAO.inserir(componenteCurricular);
    //         carregarTableViewCC();
    //     }
    // }

    // @FXML
    // public void handleBotaoAlterar() throws IOException {
    //     ComponenteCurricular componenteCurricular = tableViewCC.getSelectionModel().getSelectedItem();
    //     if (componenteCurricular != null) {
    //         boolean botaoConfirmarClicado = showCadastroProfessor(componenteCurricular);
    //         if (botaoConfirmarClicado) {
    //             componenteCurricularDAO.alterar(componenteCurricular);
    //             carregarTableViewCC();
    //         }
    //     } else {
    //         Alert alert = new Alert(Alert.AlertType.ERROR);
    //         alert.setContentText("Por favor, escolha um Componente Curricular na Tabela!");
    //         alert.show();
    //     }
    // }

    // @FXML
    // public void handleButtonRemover() throws IOException {
    //     ComponenteCurricular componenteCurricular = tableViewCC.getSelectionModel().getSelectedItem();
    //     if (componenteCurricular != null) {
    //         componenteCurricularDAO.remover(componenteCurricular);
    //         carregarTableViewCC();
    //         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    //         alert.setContentText(componenteCurricular.getNome()+" REMOVIDO COM SUCESSO!");
    //         alert.show();
    //     } else {
    //         Alert alert = new Alert(Alert.AlertType.ERROR);
    //         alert.setContentText("Por favor, escolha um Componente Curricular na Tabela!");
    //         alert.show();
    //     }
    // }
    
    // public boolean showCadastroCC(ComponenteCurricular componenteCurricular) throws IOException {
    //     FXMLLoader loader = new FXMLLoader();
    //     loader.setLocation(CadastroProfessorController.class.getResource("/view/CadastroProfessor.fxml"));
    //     AnchorPane page = (AnchorPane) loader.load();

    //     // Criando um Estágio de Diálogo (Stage Dialog)
    //     Stage dialogStage = new Stage();
    //     dialogStage.setTitle("Cadastro de professor");
    //     Scene scene = new Scene(page);
    //     dialogStage.setScene(scene);

    //     // Setando o cliente no Controller.
    //     CadastroProfessorController controller = loader.getController();
    //     controller.setInteracao(dialogStage);
    //     controller.set(componenteCurricular);

    //     // Mostra o Dialog e espera até que o usuário o feche
    //     dialogStage.showAndWait();

    //     return controller.isBotaoClicado();
    // }

}


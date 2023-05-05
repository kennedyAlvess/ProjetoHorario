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

import model.dao.ComponenteCurricularDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.ComponenteCurricular;


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

    //Listas para poder armazenar dados do banco de dados
    private List<ComponenteCurricular> listComponenteCurricular; 
    private ObservableList<ComponenteCurricular> observableListComponenteCurricular;

    //Manipulando banco de dados, iniciando conexão
    private final Database database = new DatabasePostgreSQL();
    private final Connection connection = database.conectar();
    private final ComponenteCurricularDAO componenteCurricularDAO = new ComponenteCurricularDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        componenteCurricularDAO.setConnection(connection);//passando a conexão atual
        carregarTableViewCC();
        tableViewCC.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue
        ) -> selecionarItemTableViewCC(newValue)); //Manipulando os dados na tela conforme é escolhido na lista
    }

    //Setando os nomes dos componentes curriculares na coluna nome da interface grafica
    public void carregarTableViewCC(){
        colunaNomeCC.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listComponenteCurricular = componenteCurricularDAO.listar();
        observableListComponenteCurricular = FXCollections.observableArrayList(listComponenteCurricular);
        tableViewCC.setItems(observableListComponenteCurricular);
    }
    
    //Armazenando os dados do componente curricular escolhido para poder mostrar na tela
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

    //Implementação das ações dos botões
    @FXML
    public void handleBotaoCadastrarCC() throws IOException {
        final String nome2 = "CADASTRAR COMPONENTE CURRICULAR";
        ComponenteCurricular componenteCurricular = new ComponenteCurricular();
        boolean botaoConfirmarClicado = showCadastroCC(componenteCurricular,nome2);
        if (botaoConfirmarClicado) {
            componenteCurricularDAO.inserir(componenteCurricular);
            carregarTableViewCC();
        }
    }

    @FXML
    public void handleBotaoAlterarCC() throws IOException {
        ComponenteCurricular componenteCurricular = tableViewCC.getSelectionModel().getSelectedItem();
        final String nome1 = "ALTERAR COMPONENTE CURRICULAR";
        if (componenteCurricular != null) {
            boolean botaoConfirmarClicado = showCadastroCC(componenteCurricular,nome1);
            if (botaoConfirmarClicado) {
                componenteCurricularDAO.alterar(componenteCurricular);
                carregarTableViewCC();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Componente Curricular na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleBotaoRemoverCC() throws IOException {
        ComponenteCurricular componenteCurricular = tableViewCC.getSelectionModel().getSelectedItem();
        if (componenteCurricular != null) {
            componenteCurricularDAO.remover(componenteCurricular);
            carregarTableViewCC();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(componenteCurricular.getNome()+" REMOVIDO COM SUCESSO!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Componente Curricular na Tabela!");
            alert.show();
        }
    }
    
    //Carregando a interface de cadastro
    public boolean showCadastroCC(ComponenteCurricular componenteCurricular,String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroCCcontroller.class.getResource("/view/CadastroCC.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();

        dialogStage.setTitle(nome);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        CadastroCCcontroller controller = loader.getController();
        controller.setInteracaoCC(dialogStage);
        controller.setCC(componenteCurricular);
        controller.setLabelTituloCC(nome);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isBotaoClicadoCC();
    }

}


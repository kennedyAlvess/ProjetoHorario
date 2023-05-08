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
    @FXML
    private Button botaoHome;
    @FXML
    private AnchorPane anchorPaneCC;

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

    /**
     * Metodos para chamar a tela de cadastro
     * {@link #handleBotaoCadastrarCC()}
     * {@link #handleBotaoAlterarCC()}
     * @see #showCadastroCC(ComponenteCurricular, String)
     * @throws IOException
     */
    @FXML
    public void handleBotaoCadastrarCC() throws IOException {
        final String nome = "CADASTRAR COMPONENTE CURRICULAR";
        ComponenteCurricular componenteCurricular = new ComponenteCurricular();
        boolean botaoConfirmarClicado = showCadastroCC(componenteCurricular,nome);
        if (botaoConfirmarClicado) {
            componenteCurricularDAO.inserir(componenteCurricular);
            carregarTableViewCC();
        }
    }
    @FXML
    public void handleBotaoAlterarCC() throws IOException {
        ComponenteCurricular componenteCurricular = tableViewCC.getSelectionModel().getSelectedItem();
        final String nome = "ALTERAR COMPONENTE CURRICULAR";
        if (componenteCurricular != null) {
            boolean botaoConfirmarClicado = showCadastroCC(componenteCurricular,nome);
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
    /**
     * Metodo para remover
     * @throws IOException
     */
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

    /**
     * Carregando a interface de cadastro
     * @param componenteCurricular
     * @param nome Usado para mudar o titulo da tela
     * @return A confirmação do botão confirmar ou cancelar
     * @throws IOException
     */
    public boolean showCadastroCC(ComponenteCurricular componenteCurricular,String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroCCcontroller.class.getResource("/view/CadastroCC.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();

        dialogStage.setTitle(nome);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        // Setando o cliente no Controller.
        CadastroCCcontroller controller = loader.getController();
        controller.setInteracaoCC(dialogStage);
        controller.setCC(componenteCurricular);
        controller.setLabelTituloCC(nome);
        controller.setValidarCC(componenteCurricularDAO.validarCodigoCC());
        if(nome == "ALTERAR COMPONENTE CURRICULAR"){
            controller.setAlterar(true);
        }
        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();
        return controller.isBotaoClicadoCC();
    }

}


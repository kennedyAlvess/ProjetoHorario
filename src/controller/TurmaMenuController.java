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
import model.dao.TurmasDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.Turma;

public class TurmaMenuController implements Initializable{
    @FXML
    private Button botaoAlterarCC;

    @FXML
    private Button botaoCadastrarCC;

    @FXML
    private Button botaoRemoverCC;

    @FXML
    private TableColumn<Turma, String> colunaNomeTurma;

    @FXML
    private Label labelCodTurma;

    @FXML
    private Label labelTurmaDocente;

    @FXML
    private Label labelTurmaPeriodo;

    @FXML
    private Label labelTurmaTurma;

    @FXML
    private Label labelTurmaVagas;

    @FXML
    private TableView<Turma> tableViewTurma;

    @FXML
    private Label labelTurmaNome;


   //Listas para poder armazenar dados do banco de dados
   private List<Turma> listTurma; 
   private ObservableList<Turma> observableListTurma;

   //Manipulando banco de dados, iniciando conexão
   private final Database database = new DatabasePostgreSQL();
   private final Connection connection = database.conectar();
   private final TurmasDAO turmaDAO = new TurmasDAO();
   
   @Override
   public void initialize(URL url, ResourceBundle resources) {
       turmaDAO.setConnection(connection);//passando a conexão atual
       carregarTableViewTurma();
       tableViewTurma.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue
       ) -> selecionarItemTableViewTurma(newValue)); //Manipulando os dados na tela conforme é escolhido na lista
   }

   //Setando os nomes dos componentes curriculares na coluna nome da interface grafica
   public void carregarTableViewTurma(){
       colunaNomeTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
       listTurma = turmaDAO.listar();
       observableListTurma = FXCollections.observableArrayList(listTurma);
       tableViewTurma.setItems(observableListTurma);
   }
   
   //Armazenando os dados do componente curricular escolhido para poder mostrar na tela
   public void selecionarItemTableViewTurma(Turma Turma){
       if (Turma != null) {
           labelTurmaNome.setText(Turma.getNome());
           labelCodTurma.setText(Turma.getCodTurma());
           labelTurmaDocente.setText(Turma.getDocente());
           labelTurmaVagas.setText(String.valueOf(Turma.getVagas()));       
           labelTurmaTurma.setText(String.valueOf(Turma.getTurma()));  
           labelTurmaPeriodo.setText(Turma.getPeriodo());   
       } else {
        labelTurmaNome.setText("");
        labelCodTurma.setText("");
        labelTurmaDocente.setText("");
        labelTurmaVagas.setText("");       
        labelTurmaTurma.setText("");  
        labelTurmaPeriodo.setText("");   
       }
   }

       //Implementação das ações dos botões
       @FXML
       public void handleBotaoCadastrarCC() throws IOException {
           final String nome = "CADASTRAR TURMA";
           Turma turma = new Turma();
           boolean botaoConfirmarClicado = showCadastroTurma(turma,nome);
           if (botaoConfirmarClicado) {
               turmaDAO.inserir(turma);
               carregarTableViewTurma();
           }
       }
   
       @FXML
       public void handleBotaoAlterarCC() throws IOException {
           Turma turma = tableViewTurma.getSelectionModel().getSelectedItem();
           final String nome1 = "ALTERAR TURMA";
           if (turma != null) {
               boolean botaoConfirmarClicado = showCadastroTurma(turma,nome1);
               if (botaoConfirmarClicado) {
                   turmaDAO.alterar(turma);
                   carregarTableViewTurma();
               }
           } else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Por favor, escolha um Componente Curricular na Tabela!");
               alert.show();
           }
       }
   
       @FXML
       public void handleBotaoRemoverTurma() throws IOException {
           Turma turma = tableViewTurma.getSelectionModel().getSelectedItem();
           if (turma != null) {
               turmaDAO.remover(turma);
               carregarTableViewTurma();
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setContentText("TURMA "+turma.getNome()+" REMOVIDA COM SUCESSO!");
               alert.show();
           } else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("Por favor, escolha uma turma na Tabela!");
               alert.show();
           }
       }

       public boolean showCadastroTurma(Turma professor,String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroTurmaController.class.getResource("/view/CadastroTurma.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle(nome);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);
        // Setando o cliente no Controller.
        CadastroTurmaController controller = loader.getController();
        controller.setInteracao(dialogStage);
        controller.setTurma(professor);
        controller.setLabelTituloTurma(nome);
        
        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isBotaoClicado();
    }
    
}

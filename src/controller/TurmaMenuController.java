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
           labelCodTurma.setText(String.valueOf(Turma.getCodTurma()));
           //labelTurmaDocente.setText(String.valueOf(Turma.getDocentes()));
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
    
}

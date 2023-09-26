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
import model.database.DatabasePostgreSQL;
import model.entidades.Turma;

public class TurmaMenuController implements Initializable {

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
    private Label labelTurmaTurma;
    @FXML
    private Label labelTurmaVagas;
    @FXML
    private TableView<Turma> tableViewTurma;
    @FXML
    private Label labelTurmaNome;
    @FXML
    private Label labelTurmaHorario;
    @FXML
    private Button botaoBuscar;
    @FXML
    private Label labelCHturma;
    @FXML
    private Label labelTurmaSemestre;

    private List<Turma> listTurma;
    private ObservableList<Turma> observableListTurma;

    private final DatabasePostgreSQL database = new DatabasePostgreSQL();
    private final Connection connection = database.conectar();
    private final TurmasDAO turmaDAO = new TurmasDAO();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        turmaDAO.setConnection(connection);
        carregarTableViewTurma();
        tableViewTurma.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> selecionarItemTableViewTurma(newValue)); // Manipulando na lista
    }

    public void carregarTableViewTurma() {
        colunaNomeTurma.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listTurma = turmaDAO.listar();
        observableListTurma = FXCollections.observableArrayList(listTurma);
        tableViewTurma.setItems(observableListTurma);
    }

    public void selecionarItemTableViewTurma(Turma Turma) {
        if (Turma != null) {
            labelTurmaNome.setText(Turma.getNome());
            labelCodTurma.setText(Turma.getCodTurma());
            labelTurmaDocente.setText(Turma.getDocente());
            labelTurmaVagas.setText(String.valueOf(Turma.getVagas()));
            labelTurmaTurma.setText(String.valueOf(Turma.getTurma()));
            labelTurmaHorario.setText(Turma.getHorarios());
            labelCHturma.setText(String.valueOf(Turma.getCargahoraria()));
            labelTurmaSemestre.setText(String.valueOf(Turma.getSemestre()));
        } else {
            labelTurmaNome.setText("");
            labelCodTurma.setText("");
            labelTurmaDocente.setText("");
            labelTurmaVagas.setText("");
            labelTurmaTurma.setText("");
            labelTurmaHorario.setText("");
            labelCHturma.setText("");
        }
    }

    @FXML
    public void handleBotaoCadastrarTurma() throws IOException {
        String nome = "CADASTRAR TURMA";
        Turma turma = new Turma();
        boolean botaoConfirmarClicado = showCadastroTurma(turma, nome);
        if (botaoConfirmarClicado) {
            turmaDAO.inserir(turma);
            turmaDAO.cadastrarCargaHoraria(turma);
            carregarTableViewTurma();
        }
    }

    @FXML
    public void handleBotaoAlterarTurma() throws IOException {
        Turma turma = tableViewTurma.getSelectionModel().getSelectedItem();
        String nome = "ALTERAR TURMA";
        if (turma != null) {
            boolean botaoConfirmarClicado = showCadastroTurma(turma, nome);
            if (botaoConfirmarClicado) {
                turmaDAO.alterar(turma);
                carregarTableViewTurma();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uam turma na Tabela!");
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
            alert.setContentText("TURMA " + turma.getNome() + " REMOVIDA COM SUCESSO!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma turma na Tabela!");
            alert.show();
        }
    }

    public void handleBotaoBuscar() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroCCcontroller.class.getResource("/view/BuscarTurma.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        Scene scene = new Scene(page);

        dialogStage.setTitle("Buscar Turma");
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);

        BuscarTurmaController controller = loader.getController();
        controller.setInteracao(dialogStage);
    
        dialogStage.showAndWait();

    }

    public boolean showCadastroTurma(Turma turma, String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CadastroTurmaController.class.getResource("/view/CadastroTurma.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle(nome);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        dialogStage.setResizable(false);

        CadastroTurmaController controller = loader.getController();
        if(nome.equals("ALTERAR TURMA")){
            controller.setAlterar(true);
        }else{
            controller.setAlterar(false);
        }
        controller.setInteracao(dialogStage);
        controller.setTurma(turma);
        controller.setLabelTituloTurma(nome);
        controller.setListaDeProfessores(turmaDAO.cargaHrProfessor());
        controller.setListaDeTurmas(turmaDAO.validarTurma());
        
        dialogStage.showAndWait();

        return controller.isBotaoClicado();
    }
}

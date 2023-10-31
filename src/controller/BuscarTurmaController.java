package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import model.dao.TurmasDAO;
import model.entidades.Turma;

public class BuscarTurmaController implements Initializable {
    @FXML
    private GridPane GridLabel;
    @FXML
    private ChoiceBox<String> choiceBoxBuscar;
    @FXML
    private TextField TextFieldBuscar;

    private Stage interacao;


    private final ObservableList<String> choiceBoxBuscarList = FXCollections.observableArrayList("Semestre", "1", "2", "3", "4",
            "5", "6");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxBuscar.setItems(choiceBoxBuscarList);
        choiceBoxBuscar.setValue("Semestre");
    }

    public void handleBotaoPesquisar() {
        limparTelaHorario();
        List<Turma> listHorarios;
        if (!choiceBoxBuscar.getValue().equals("Semestre") && TextFieldBuscar.getText().isEmpty()){
            listHorarios = TurmasDAO.horariosSemestre(Integer.parseInt(choiceBoxBuscar.getValue()));

            for(Turma turma : listHorarios){
                showHorario(turma.getHorarios(),turma.getCodTurma());
            }
        }else if(!TextFieldBuscar.getText().isEmpty() && choiceBoxBuscar.getValue().equals("Semestre")){
            listHorarios = TurmasDAO.horariosDocente(TextFieldBuscar.getText().toUpperCase());

            for(Turma turma : listHorarios){
                showHorario(turma.getHorarios(),turma.getCodTurma());
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO NO PREENCHIMENTO DOS CAMPOMS! *");
            alert.setHeaderText("ERRO AO REALIZAR BUSCA.");
            alert.setContentText("SELECIONE BUSCAR POR PROFESSOR OU SEMESTRE! *");
            alert.show();
        }
    }

    private void showHorario(String horario,String codTurma){
        String horarioformatado;

        if(horario.length() == 4){
            preencherHorario(horario.substring(0,4), codTurma);
        }else{
            horarioformatado = formatarHorario(horario);
            preencherHorario(horarioformatado.substring(0,4), codTurma);
            preencherHorario(horarioformatado.substring(5,9), codTurma);
        }
    }
    private String formatarHorario(String horario){
        if(horario.length() == 6){
            return  horario.substring(0,2)+horario.substring(2,4)+" "+horario.substring(0,2)+horario.substring(4,6);
        }else if(horario.length() == 5){
            return horario.charAt(0)+horario.substring(2,5)+" "+horario.charAt(1)+horario.substring(2,5);
        }else{
            return horario;
        }
    }

    private void preencherHorario(String horario, String codTurma) {
        String horarioLabel = "label"+horario;
        for (Node node : GridLabel.getChildren()) {
            if (horarioLabel.substring(0, 8).equals(node.getId()) || (horarioLabel.substring(0, 7) + horarioLabel.charAt(8)).equals(node.getId())) {
                ((Label) node).setText(codTurma);
            }
        }
    }

    @FXML
    public void handleBotaoVoltar() {
        interacao.close();
    }

    public void setInteracao(Stage interacao) {
        this.interacao = interacao;
    }

    public void limparTelaHorario() {
        for(Node node : GridLabel.getChildren()){
            if(node.getId() != null && !node.getId().isEmpty()){
                ((Label) node).setText("");
            }
        }
    }

}

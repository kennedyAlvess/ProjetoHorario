package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import model.entidades.ComponenteCurricular;

public class CadastroCCcontroller implements Initializable{
    

    @FXML
    private ChoiceBox<String> choiceBoxCC;
    @FXML
    private ChoiceBox<Integer> choiceBoxSemestre;
    @FXML
    private TextField TextFieldCCcargahoraria;
    @FXML
    private TextField TextFieldCCcodigo;
    @FXML
    private TextField TextFieldCCnome;
    @FXML
    private TextField TextFieldCCsemestre;
    @FXML
    private Button botaoCCcancelar;
    @FXML
    private Button botaoCCconfirmar;
    @FXML
    private Label labelCCcargahoraria;
    @FXML
    private Label labelCCcodigo;
    @FXML
    private Label labelCCnome;
    @FXML
    private Label labelTituloCC;

    private Stage interacao;
    private boolean botaoConfirmarClicadoCC;
    private ComponenteCurricular componenteCurricular;
    private List<String> validarCC;
    private boolean alterar;

    private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Obrigatoria","Optativa");
    private ObservableList<Integer> choiceBoxSemestreList = FXCollections.observableArrayList(1,2,3,4,5,6);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxSemestre.setItems(choiceBoxSemestreList);
        choiceBoxCC.setItems(choiceBoxList);
    }

    @FXML
    public void handleBotaoConfirmarCC(){ 
        if (validarEntradaDeDadosCC()) {
            componenteCurricular.setNome(TextFieldCCnome.getText());
            componenteCurricular.setCargaHoraria(Integer.parseInt(TextFieldCCcargahoraria.getText()));
            componenteCurricular.setCodigo(TextFieldCCcodigo.getText());
            componenteCurricular.setSemestre(choiceBoxSemestre.getValue());
            componenteCurricular.setObrigatoriedade(choiceBoxCC.getValue());
            botaoConfirmarClicadoCC = true;
            interacao.close();
        }
    }
    @FXML
    public void handleBotaoCancelarCC(){
        interacao.close();
    }

    public void setCC(ComponenteCurricular componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
        this.TextFieldCCnome.setText(componenteCurricular.getNome());
        this.TextFieldCCcargahoraria.setText(String.valueOf(componenteCurricular.getCargaHoraria()));
        this.TextFieldCCcodigo.setText(componenteCurricular.getCodigo());
        this.choiceBoxSemestre.setValue(componenteCurricular.getSemestre());
        this.choiceBoxCC.setValue(componenteCurricular.getObrigatoriedade());
    }

    //Validando o preenchimento dos dados
    private boolean validarEntradaDeDadosCC() {
        String errorMessage = "";
        if(alterar){
            if ( TextFieldCCcodigo.getText() == null || TextFieldCCcodigo.getText().length() != 7) {
            errorMessage += "Código inválido!*\n";
        }
        }else{
            if ( validarCC.contains(TextFieldCCcodigo.getText()) || TextFieldCCcodigo.getText() == null || 
        TextFieldCCcodigo.getText().length() != 7) {
            errorMessage += "Código inválido!*\n";
        }
        }
        if (TextFieldCCnome.getText() == null || TextFieldCCnome.getText().length() == 0) {
            errorMessage += "Nome inválido!*\n";
        }
        if (TextFieldCCcargahoraria.getText() == null || TextFieldCCcargahoraria.getText().length() == 0 || Integer.parseInt(TextFieldCCcargahoraria.getText()) <= 0) {
            errorMessage += "Carga horária inválida!*\n";  
        }
       
        if(choiceBoxCC.getValue() == null){
            errorMessage += "Valor inválido! Selecione Obrigatorio/Optativa\n";
        }
        if(choiceBoxSemestre.getValue() == null || choiceBoxSemestre.getValue() == 0){
            errorMessage += "Semestre inválido!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no preenchimento dos dados");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    /**
     * Gets e Setts utilizados para manipulação dos dados em outra classe
     * @see CCmenuController#showCadastroCC(ComponenteCurricular componenteCurricular,String nome) */

    public void setLabelTituloCC(String titulo) {
        this.labelTituloCC.setText(titulo);
    }
    public void setInteracaoCC(Stage interacao) {
        this.interacao = interacao;
    }
    public boolean isBotaoClicadoCC() {
        return botaoConfirmarClicadoCC;
    }
    public void setValidarCC(List<String> validarCC) {
        this.validarCC = validarCC;
    }
    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

}

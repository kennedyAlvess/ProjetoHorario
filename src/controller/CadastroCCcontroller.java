package controller;

import java.net.URL;
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

/**
 * Classe utilizada para controlar a busca de turmas por professor ou semestre.
 * 
 */

public class CadastroCCcontroller implements Initializable{
    
    //Incluido todos os componentes criados na Interface Grafica como atributos na classe 
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

    //Preenchendo os ChoiceBox da interface gráfica
    private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Obrigatoria","Optativa");
    private ObservableList<Integer> choiceBoxSemestreList = FXCollections.observableArrayList(1,2,3,4,5,6);

    //Metodo chamado na inicialização da janela referente a essa classe na interface gráfica
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBoxSemestre.setItems(choiceBoxSemestreList);
        choiceBoxCC.setItems(choiceBoxList);
    }

    /**
     * Metodos para confirmar uma ação de cadastro ou alteração 
     *{@link #handleBotaoConfirmarCC()}}
     */
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

    /**
     *Metodo usado para repassar o componente curricular a interação atual,
     para que possa ser atualizado caso confirme a ação.
     @see CCmenuController#showCadastroCC(ComponenteCurricular componenteCurricular,String nome)
       */ 
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
        if (TextFieldCCnome.getText() == null || TextFieldCCnome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (TextFieldCCcargahoraria.getText() == null || Integer.parseInt(TextFieldCCcargahoraria.getText()) <= 0) {
            errorMessage += "Carga horaria invalida!*\n";  
        }
        if (TextFieldCCcodigo.getText() == null || TextFieldCCcodigo.getText().length() == 0) {
            errorMessage += "Código inválida!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
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
}

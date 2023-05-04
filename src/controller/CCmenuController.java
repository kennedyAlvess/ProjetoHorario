package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entidades.ComponenteCurricular;

public class CCmenuController {

    @FXML
    private Button botaoAlterar;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoRemover;

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
    private TableView<?> tableViewCC;

    @FXML
    void handleBotaoAlterar(ActionEvent event) {

    }

    @FXML
    void handleBotaoCadastrar(ActionEvent event) {

    }

    @FXML
    void handleButtonRemover(ActionEvent event) {

    }

}

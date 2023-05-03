package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

    private MenuItem menuCadastrarProfessores;

    private MenuItem menuListaProfessores;

    private MenuItem menuCadastrarCC;

    private MenuItem menuVisualizarCC;

    private MenuItem menuCriarTurmas;

    private MenuItem menuConsultarTurmas;

    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void handleMenuCadastroProfessor() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("view/CadastroProfessorMenu.fxml"));
        anchorPane.getChildren().setAll(a);
    }
}

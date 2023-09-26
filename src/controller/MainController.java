package controller;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


public class MainController implements Initializable {
    @FXML
    private Menu menuHome;
    @FXML
    private MenuItem menuListaProfessores;
    @FXML
    private MenuItem menuCadastrarCC;
    @FXML
    private MenuItem menuVisualizarCC;
    @FXML
    private MenuItem menuCriarTurmas;
    @FXML
    private MenuItem menuConsultarTurmas;
    @FXML
    private AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void handleMenuCadastroProfessor() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/ProfessorMenu.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuCC() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/CCmenu.fxml"));
        anchorPane.getChildren().setAll(a);  
    }
    
    public void handleMenuTurma() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/TurmaMenu.fxml"));
        anchorPane.getChildren().setAll(a);  
    }

}

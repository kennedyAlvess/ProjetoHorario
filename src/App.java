
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view/VboxMenu.fxml"));
        Scene tela = new Scene(root);
        Stage.setScene(tela);
        Stage.setTitle("Home");
        Stage.setResizable(false);
        Stage.show();
    }
}
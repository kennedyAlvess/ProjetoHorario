
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public  void start(Stage Stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/VboxMenu.fxml")));
        Scene home = new Scene(root);
        Stage.setScene(home);
        Stage.setTitle("Melhor que o SIGAA");
        Stage.setResizable(false);
        Stage.show();
    }

}

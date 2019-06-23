package OOP5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaunchAppl extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // hier umbauen, da kein fxml loader
        Parent root = new BorderPane();
        primaryStage.setTitle("Pythagoras Baum");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }
}

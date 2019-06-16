package OOP5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PythagorasBäume extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Pythagoras Bäume");

        InputPane inputPane = new InputPane();
        Scene inputScene = new Scene(inputPane);

        primaryStage.setScene(inputScene);
        primaryStage.show();
    }
}

package OOP5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class PythagorasBäume extends Application {

    private Scene currentScene;
    private Stage currentStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        currentStage = primaryStage;
        currentStage.setTitle("Pythagoras Bäume");

        setScene(new InputScene(this));

        currentStage.show();
    }

    public void setScene(Scene scene){
        currentScene = scene;
        currentStage.setScene(currentScene);
    }
    public void draw(DrawArguments args)
    {
        setScene(new DrawScene(args));
    }
}

package OOP5;

import javafx.scene.layout.GridPane;

import javax.swing.*;

public class DrawPane extends GridPane {

    public DrawPane(DrawArguments args){
        this.getChildren().add(new DrawCanvas(args));
    }
}

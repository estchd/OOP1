package OOP5;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class DrawScene extends Scene {

    public DrawScene(DrawArguments args, PythagorasBäume parent){
        super(new DrawPane(args, parent));
        this.setFill(Color.WHITE);
    }
}

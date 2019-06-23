package OOP5;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class DrawScene extends Scene {

    public DrawScene(DrawArguments args){
        super(new DrawPane(args));
    }
}

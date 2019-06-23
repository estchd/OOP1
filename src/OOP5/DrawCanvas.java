package OOP5;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class DrawCanvas extends Canvas {

    public DrawCanvas(DrawArguments args)
    {
        this.getGraphicsContext2D().setFill(Color.WHITE);
        this.getGraphicsContext2D().fill();

        //Logik für das Zeichnen des Pythagoras Baums hier hinzufügen
    }
}

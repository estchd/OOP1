package OOP5;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * DrawCanvas used with DrawPane.
 * @author Josi and Erik
 */
public class DrawCanvas extends Canvas {


    /**
     * Constructor.
     * @param args - DrawArguments used for calculating tree on DrawPane.
     */
    public DrawCanvas(DrawArguments args)
    {
        this.getGraphicsContext2D().setFill(Color.WHITE);
        this.getGraphicsContext2D().fill();

        //Logik für das Zeichnen des Pythagoras Baums hier hinzufügen
    }
}

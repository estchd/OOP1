package OOP5;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * DrawScene used with DrawPane.
 * @author Erik
 */
public class DrawScene extends Scene {

    /**
     * Constructor used for creating a new DrawPane with white fill,
     * and PythagorasBäume as parent.
     *
     * @author Erik
     * @param args
     * @param parent
     */
    public DrawScene(DrawArguments args, PythagorasBäume parent){
        super(new DrawPane(args, parent));
        this.setFill(Color.WHITE);
    }
}

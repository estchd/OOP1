package OOP5;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * InputScene used with InputPane.
 * @author Erik
 */
public class InputScene extends Scene {

    /**
     * Construktor which sets PythagorasBäume as Parent.
     *
     * @author Erik
     * @param parent - PythagorasBäume used as parent.
     */
    public InputScene(PythagorasBäume parent) {
        super(new InputPane(parent));
    }
}

package OOP5;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class InputScene extends Scene {
    public InputScene(PythagorasBäume parent) {
        super(new InputPane(parent));
    }
}

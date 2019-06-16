package OOP5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InputPane extends GridPane {

    public InputPane(){
        super();

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25));

        Text title = new Text("Pythagoras Trees");
        title.setTextAlignment(TextAlignment.CENTER);
        add(title,0,0,2,1);

        Label sides = new Label("Sides:");
        add(sides,0,1);

        TextField side1TextField = new TextField();
        add(side1TextField,1,1);

        TextField side2TextField = new TextField();
        add(side2TextField,2,1);

        Label minSize = new Label("Minimal Square Size:");
        add(minSize, 0,2);

        TextField minSizeTextField = new TextField();
        add(minSizeTextField,1,2,2,1);

        Label treeOrder = new Label("Square Size Order:");
        add(treeOrder,0,3);

        ToggleGroup treeOrderToggleGroup = new ToggleGroup();

        RadioButton treeOrderConsistent = new RadioButton("Consistent");
        treeOrderConsistent.fire();
        treeOrderConsistent.setToggleGroup(treeOrderToggleGroup);
        add(treeOrderConsistent,1,3);

        RadioButton treeOrderSwitching = new RadioButton("Switching");
        treeOrderSwitching.setToggleGroup(treeOrderToggleGroup);
        add(treeOrderSwitching,2,3);

    }
}

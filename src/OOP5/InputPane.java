package OOP5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;

public class InputPane extends GridPane {

    private NumberTextField side1TextField;
    private NumberTextField side2TextField;
    private NumberTextField minSizeTextField;
    private RadioButton treeOrderConsistent;
    private RadioButton treeOrderSwitching;
    private RadioButton treeColorSchemeBranch;
    private RadioButton treeColorSchemeDepth;
    private Label color1Label;
    private ColorPicker color1;
    private Label color2Label;
    private ColorPicker color2;
    private Label color3Label;
    private ColorPicker color3;
    private Label errorLabel;

    private PythagorasBäume parent;

    public InputPane(PythagorasBäume parent){
        super();

        this.parent = parent;
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25));

        Text title = new Text("Pythagoras Trees");
        title.setTextAlignment(TextAlignment.CENTER);
        add(title,0,0,2,1);

        Label sides = new Label("Sides:");
        add(sides,0,1);

        side1TextField = new NumberTextField();
        add(side1TextField,1,1);

        side2TextField = new NumberTextField();
        add(side2TextField,2,1);

        Label minSize = new Label("Minimal Square Size:");
        add(minSize, 0,2);

        minSizeTextField = new NumberTextField();
        add(minSizeTextField,1,2,2,1);

        Label treeOrder = new Label("Square Size Order:");
        add(treeOrder,0,3);

        ToggleGroup treeOrderToggleGroup = new ToggleGroup();

        treeOrderConsistent = new RadioButton("Consistent");
        treeOrderConsistent.fire();
        treeOrderConsistent.setToggleGroup(treeOrderToggleGroup);
        add(treeOrderConsistent,1,3);

        treeOrderSwitching = new RadioButton("Switching");
        treeOrderSwitching.setToggleGroup(treeOrderToggleGroup);
        add(treeOrderSwitching,2,3);

        Label treeColorScheme = new Label("Color Scheme:");
        add(treeColorScheme,0,4);

        ToggleGroup treeColorSchemeToggleGroup = new ToggleGroup();

        treeColorSchemeBranch = new RadioButton("Branch Direction");
        treeColorSchemeBranch.fire();
        treeColorSchemeBranch.setToggleGroup(treeColorSchemeToggleGroup);
        add(treeColorSchemeBranch, 1, 4);

        treeColorSchemeDepth = new RadioButton("Branch Depth");
        treeColorSchemeDepth.setToggleGroup(treeColorSchemeToggleGroup);
        add(treeColorSchemeDepth,2,4);

        Label colors = new Label("Colors:");
        add(colors,0,5);

        color1Label = new Label("Left Color:");
        add(color1Label, 1, 5);

        color1 = new ColorPicker();
        add(color1,2,5);

        color2Label = new Label("Right Color:");
        add(color2Label,3,5);

        color2 = new ColorPicker();
        add(color2,4,5);

        color3Label = new Label("Base Color:");
        add(color3Label, 5, 5);
        color3 = new ColorPicker();
        add(color3,6,5);

        errorLabel = new Label("");
        errorLabel.setTextFill(Color.RED);
        add(errorLabel,0,6);

        Button drawButton = new Button("Draw");
        drawButton.setOnAction(this::drawbutton_onClick);
        add(drawButton,3,6,2,1);
    }

    private void drawbutton_onClick(ActionEvent event){
        int side1,side2,minSize;
        try
        {
            side1 = Integer.parseInt(side1TextField.getText());
        }
        catch(NumberFormatException ex)
        {
            errorLabel.setText("Side 1 is not a number!");
            return;
        }

        try
        {
            side2 = Integer.parseInt(side2TextField.getText());
        }
        catch(NumberFormatException ex)
        {
            errorLabel.setText("Side 2 is not a number!");
            return;
        }

        try
        {
            minSize = Integer.parseInt(minSizeTextField.getText());
        }
        catch(NumberFormatException ex)
        {
            errorLabel.setText("Min Size is not a number!");
            return;
        }

        if(side1 <= 0)
        {
            errorLabel.setText("Side 1 must be greater than 0");
            return;
        }
        if(side2 <= 0)
        {
            errorLabel.setText("Side 2 must be greater than 0");
            return;
        }
        if(minSize <= 0)
        {
            errorLabel.setText("Min Size must be greater than 0");
            return;
        }

        boolean isTreeOrderConsistent = treeOrderConsistent.isSelected();
        boolean isTreeColorSchemeBranch = treeColorSchemeBranch.isSelected();

         parent.drawTree( new DrawArguments(side1,side2,minSize,isTreeOrderConsistent,isTreeColorSchemeBranch,color1.getValue(),color2.getValue(),color3.getValue()));
    }
}

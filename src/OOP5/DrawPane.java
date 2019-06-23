package OOP5;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.beans.EventHandler;

public class DrawPane extends GridPane
{

    private DrawCanvas drawCanvas;
    private PythagorasBäume parent;

    public DrawPane(DrawArguments args, PythagorasBäume parent)
    {
        this.parent = parent;

        MenuBar drawMenu = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        MenuItem export = new MenuItem("Export");

        exit.setOnAction(this::OnExit);
        export.setOnAction(this::OnExport);

        fileMenu.getItems().addAll(export, new SeparatorMenuItem(), exit);
        drawMenu.getMenus().addAll(fileMenu);

        getChildren().add(drawMenu);
        setAlignment(Pos.CENTER);
        drawCanvas = new DrawCanvas(args);
        add(drawCanvas,0,0);

    }

    private void OnExit(ActionEvent e){
        parent.exit();
    }

    /***
     * Event Handler für das Export MenüElement Action Event
     * Logik für das Exportieren des Graphic Context zu jpg hier hinzufügen
     * @param e
     */
    private void OnExport(ActionEvent e){

    }
}

package OOP5;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * DrawPane used for drawing and showing the PythagorasTree
 * as well as having a Menu bar, used to exit the program or export the image.
 *
 * @author Josi and Erik
 */
public class DrawPane extends GridPane
{

    private DrawCanvas drawCanvas;
    private PythagorasBäume parent;

    /**
     * Construktor used with DrawArguments and PythagorasBäume.
     *
     * @author Erik
     * @param args - DrawArguments used as parameters for the
     *             calculation of the Tree.
     * @param parent - PythagorasBäume used as parent.
     */
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
        drawCanvas.setHeight(640);
        drawCanvas.setWidth(640);
        add(drawCanvas,0,1);

        parent.setDrawCanvas(drawCanvas);
    }

    private void OnExit(ActionEvent e){
        parent.exit();
    }


    /***
     * The Event Handler for when "export" in the menu bar is selected.
     * It will call open an FileChooser used to name and direct where the
     * file should be saved as well as the extension (.png or .gif) and
     * give out an error if saving the file wasn't possible.
     *
     * @author Josi
     * @param e - ActionEvent used when "export" selected in menu.
     */
    private void OnExport(ActionEvent e){
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PNG image file", "*.png"),
                    new FileChooser.ExtensionFilter("GIF image file", "*.gif")
            );
            Path currentDir = Paths.get("").toAbsolutePath();
            fileChooser.setInitialDirectory(currentDir.toFile());

            //Show save file dialog
            File file = fileChooser.showSaveDialog(this.getScene().getWindow());

            if (file != null) {
                try {

                    String ext = file.getName();
                    ext = ext.substring(ext.lastIndexOf(".") + 1);

                    WritableImage writableImage = new WritableImage((int) drawCanvas.getWidth(), (int) drawCanvas.getHeight());
                    drawCanvas.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, ext, file);

                    //miniWindow mit okay
                    //statusLabel.setText("Successfully saved image to file: " + file.getName());

                } catch (IOException ex) {

                    ex.printStackTrace();

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error saving image file");
                    alert.setContentText("File cannot be written.");

                    alert.showAndWait();

                    //statusLabel.setText("Image could not be rendered.");
                }
            }

    }


}

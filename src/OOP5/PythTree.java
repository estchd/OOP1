package OOP5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * code-sammlung josi, verwendbar, umschreibbar, sollte dann passen
 */
public class PythTree implements ChangeListener {

    private BorderPane borderPane;
    private Canvas canvas;
    private Label statusLabel;
    private Slider startXSlider; //+ so weiter
    private TextField iteratTextField;

    protected void closeApplication() {

        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

    }
    public void initialize() {

        startXSlider.valueProperty().addListener(this);
       // startYSlider.valueProperty().addListener(this);
       // scaleXSlider.valueProperty().addListener(this);
       // scaleYSlider.valueProperty().addListener(this);

        //Iterations can only be numbers
       // iterationTextField.textProperty().addListener((observable, oldValue, newValue) -> {

         //   if (!newValue.matches("\\d*")) {
         //       iterationTextField.setText(newValue.replaceAll("[^\\d]", ""));
          //  }
      //  });

        /**
         * zum weiteren aufbau:
         *          in borderpane: ...
         *                <AnchorPane fx:id="rightSidePane" minHeight="0.0" minWidth="0.0" prefHeight="160.0" prefWidth="100.0">
         *                     <children>
         *                         <Canvas fx:id="canvas" height="${rightSidePane.height}" width="${rightSidePane.width}">
         *                             <cursor>
         *                                 <Cursor fx:constant="DEFAULT"/>
         *                             </cursor>
         *                         </Canvas>
         *                     </children>
         *                 </AnchorPane>
         *             </items>
         *         </SplitPane>
         */

    }


    //aus gitlab Fern, noch anzupassen
    /**
     * draws a number of points on a given canvas depending an a scale and starting point
     *
     * @param canvas     the canvas to draw to
     * @param iterations the number of points to draw
     * @param startX     the x point from which to start, can be from [-100, 100] proportional to the canvas (but not necessarily)
     * @param startY     the y point from which to start, can be from [-100, 100] proportional to the canvas (but not necessarily)
     * @param scaleX     the factor of x stretching, can be from [-1000, 1000] (but not necessarily)
     * @param scaleY     the factor of y stretching, can be from [-1000, 1000] (but not necessarily)
     */
    public void draw(Canvas canvas, int iterations, int startX, int startY, int scaleX, int scaleY) {

        //clear previous image
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //compute center of canvas
        int middleX = (int) (canvas.getWidth() / 2 + (startX * canvas.getWidth() / 200));
        int middleY = (int) (canvas.getHeight() / 2 + (startY * canvas.getHeight() / 200));

        //start of the drawing with 0;0 in graph
        //Point point = new Point(0, 0);
        PixelWriter writer = canvas.getGraphicsContext2D().getPixelWriter();

        for (int i = 0; i < iterations; i++) {

            //get random coefficientSet
            //int setIndex = getRandomSetIndex();
            //CoefficientSet coefficientSet = coefficientSets.get(setIndex);
            //point = getNewPoint(coefficientSet, point);

            //set color depending on chosen set
            //Color color = coefficientSet.getColor();

            //scale pixel to the given scale
         //   writer.setColor(middleX + (int) (point.x * scaleX), middleY + (int) (point.y * scaleY), color);
        }
    }

    //PythTree aus anderem Git
    private static final int MAX_BRANCH = 14;

    private double angle = 0.5F;

    /**
     * Draws Pythagoras tree to the specified GraphicsContext.
     *
     * @param width - width of the container or canvas.
     * @param height - height of the container or canvas.
     * @param gc - GraphicsContext to use to draw with.
     */
    public void drawTree(int width, int height, double angle, GraphicsContext gc) {
        this.angle = angle;
        genTree(gc, (width/2)-50, height, ((width/2)-50)+100, height, 0);
    }

    /**
     * Recursive method to generate the Pythagorean tree.
     * This method draws a rectangle using the specified x and y values.
     * Then continues by recursively call itself two times to create two new rectangles.
     *
     * @param gc - GraphicsContext to use to draw with.
     * @param x1 - Start x value.
     * @param y1 - Start y value.
     * @param x2 - End x value.
     * @param y2 - End y value.
     * @param branch - The current branch that is being generated.
     */
    private void genTree(GraphicsContext gc, double x1, double y1, double x2, double y2, int branch) {

        if(branch >= MAX_BRANCH) {
            return;
        }

        double dx = x2 - x1;
        double dy = y1 - y2;
        double x3 = x2 - dy;
        double y3 = y2 - dx;
        double x4 = x1 - dy;
        double y4 = y1 - dx;
        double x5 = x4 + angle * (dx - dy);
        double y5 = y4 - angle * (dx + dy);


        //Hilfe zu canvas https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html#rect-double-double-double-double-
        //Draw square
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLACK);
        //vermutlich mehr gc.strokeRect(double x,
        //                       double y, - upper left corner
        //                       double w, - width
        //                       double h); - height
        // und danach gc.fillRect(x, y, w h);
        gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x4, y4);
        gc.strokeLine(x4, y4, x1, y1);

        //Draw triangle
        //gc.strokePolygon(double[] x, double[] y, int nPoints); - Points mit Koordinaten als Array, number of Points
        gc.strokeLine(x4, y4, x5, y5);
        gc.strokeLine(x5, y5, x3, y3);


        genTree(gc, x4, y4, x5, y5, branch+1);
        genTree(gc, x5, y5, x3, y3, branch+1);
    }


    protected void saveImage() {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG image file", "*.png"),
                new FileChooser.ExtensionFilter("GIF image file", "*.gif")
        );
        Path currentDir = Paths.get("").toAbsolutePath();
        fileChooser.setInitialDirectory(currentDir.toFile());

        //Show save file dialog
        File file = fileChooser.showSaveDialog(borderPane.getScene().getWindow());

        if (file != null) {
            try {

                String ext = file.getName();
                ext = ext.substring(ext.lastIndexOf(".") + 1);

                WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, ext, file);

                statusLabel.setText("Successfully saved image to file: " + file.getName());

            } catch (IOException ex) {

                ex.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error saving image file");
                alert.setContentText("File cannot be written.");

                alert.showAndWait();

                statusLabel.setText("Image could not be rendered.");
            }
        }

    }


    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        //TODO irgendeine methode aufrufen --> neu berechnen/ butonpressed etc.
    }
}

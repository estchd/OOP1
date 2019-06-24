package OOP5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class PythagorasBäume extends Application {

    private Stage currentStage;

    public DrawCanvas getDrawCanvas() {
        return drawCanvas;
    }

    public void setDrawCanvas(DrawCanvas drawCanvas) {
        this.drawCanvas = drawCanvas;
    }

    private DrawCanvas drawCanvas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        currentStage = primaryStage;
        currentStage.setTitle("Pythagoras Bäume");

        setScene(new InputScene(this));

        currentStage.show();
    }

    public void setScene(Scene scene){
        currentStage.hide();
        currentStage.setScene(scene);
        currentStage.show();
    }

    //PythTree aus anderem Git

    private double angle = 0.5F;

    /**
     * Draws Pythagoras tree to the specified GraphicsContext.
     *
     * @param width - width of the container or canvas.
     * @param height - height of the container or canvas.
     */
    public void drawTree(DrawArguments args, int width, int height, double angle) {
        setScene(new DrawScene(args, this));
        //compute center of canvas
        //int middleX = (int) (drawCanvas.getWidth() / 2 );
        //int startY = 0;
        this.angle = angle;
        draw(drawCanvas.getGraphicsContext2D(), (width/2)-50, height, ((width/2)-50)+100, height, args);
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
    }
    public int branch;
    public void draw(GraphicsContext gc, double x1, double y1, double x2, double y2, DrawArguments args)
    {
        gc.setStroke(Color.BLACK);


        double dx = x2 - x1;
        double dy = y1 - y2;
        double x3 = x2 - dy;
        double y3 = y2 - dx;
        double x4 = x1 - dy;
        double y4 = y1 - dx;
        double x5 = x4 + angle * (dx - dy);
        double y5 = y4 - angle * (dx + dy);


        //squareKleiner
        if(branch > 3 /*< args.getMinSize()*/) {
            return;
        }

        //Hilfe zu canvas https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html#rect-double-double-double-double-
        //Draw square
        gc.setFill(javafx.scene.paint.Color.BLUE);

        gc.strokeRect(x3, y3, args.getSide1(), args.getSide2());
        //vermutlich mehr gc.strokeRect(double x,
        //                       double y, - upper left corner
        //                       double w, - width
        //                       double h); - height
        // und danach gc.fillRect(x, y, w h);
       /* gc.strokeLine(x1, y1, x2, y2);
        gc.strokeLine(x2, y2, x3, y3);
        gc.strokeLine(x3, y3, x4, y4);
        gc.strokeLine(x4, y4, x1, y1);*/

        //Draw triangle
        double[] xs = {x3, x4, x5};
        double[] ys = {y3, y4, y5};
        gc.strokePolygon(xs, ys, 3);
        //gc.strokePolygon(double[] x, double[] y, int nPoints); - Points mit Koordinaten als Array, number of Points
       /* gc.strokeLine(x4, y4, x5, y5);
        gc.strokeLine(x5, y5, x3, y3); */

        branch++;
        draw(gc, x4, y4, x5, y5, args);
        draw(gc, x5, y5, x3, y3, args);

    }

    public void exit()
    {
        this.currentStage.close();
    }
}

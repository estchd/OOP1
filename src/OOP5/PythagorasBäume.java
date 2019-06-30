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
     * Draws Pythagoras tree to the specified GraphicsContext
     */
    public void drawTree(DrawArguments args) {
        DrawScene drawi = new DrawScene(args, this);
        //drawi.hei
        setScene(drawi);
        double s1 = args.getSide1();
        double s2 = args.getSide2();
        double sidehyp = Math.sqrt( s1 * s1 + s2 * s2);

        //seite 1 nur wenn größte seite

        //compute center of canvas
        double x =  (drawCanvas.getWidth() / 2 );
       // double startY =  (drawCanvas.getHeight() / 2 );
        double startY =  drawCanvas.getHeight() - 5 ;
        double x1 = x - ( sidehyp / 2);
        double y1 = startY ;
        double x2 = x + ( sidehyp /2);
        double y2 = startY ;

        //angle = Math.atan(s1/s2);
        angle = Math.atan(s2/s1);

       GraphicsContext gc = drawCanvas.getGraphicsContext2D();
       /* double[] xs = {x1, x2, x2, x1};
        double[] ys = {y1, y1, y2, y2};
        gc.strokePolygon(xs, ys, 4); */

        //triangle
        //side 2 einbringen
        //int triEcke =
      /*  double[] trix = {x1, x2};
          double[] triy = {y1, y1}; */

        Color col;
        //TODO
        if (args.isTreeColorSchemeBranch()) {
            col = args.getColor3();
        } else {
            col = Color.WHITE;
        }
        // Color col;
        //draw(gc, xtri1, ytri1, xtri2, ytri2, args , col , 0);
        draw(gc, x1, y1, x2, y2, args, col, 0);
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
   // private void genTree(GraphicsContext gc, double x1, double y1, double x2, double y2, int branch) {
  //  }
    private void draw(GraphicsContext gc, double x1, double y1, double x2, double y2, DrawArguments args, Color color, int branch)
    {
        gc.setStroke(Color.BLACK);

        if (args.getSide1() < args.getMinSize() || args.getSide2() < args.getMinSize()) {
            return;
        }
        //rect
        double dx = x2 - x1;
        double dy = y1 - y2;
        double x3 = x2 - dy;
        double y3 = y2 - dx;
        double x4 = x1 - dy;
        double y4 = y1 - dx;

        double x5;
        double y5;
        double c;
        double a;
        //
       /* if (true ) {
            if(args.getSide2() > args.getSide1()) {
                c = args.getSide2(); //(vemutlih problematish da eine seite bereits in quadrat )
                //a =  Math.sqrt(args.getSide1()*args.getSide1() - c*c);
                a = args.getSide1();
            } else  {
                c = args.getSide1();
                a = args.getSide2();
            }
            angle = Math.acos(a / Math.sqrt( a * a + c * c)); //klein durc h groß da sin <1
            //besser, hat aber noch nicht ganz hin, falsche zwei seiten, vermutlich
        }*/
        //if (false/*args.isTreeOrderConsistent() == symmetrisch */ ) {
           /* x5 = x4 + angle * (dx - dy); //angle = Verhältnis seite zu hyp c
            y5 = y4 - angle * (dx + dy);
        } else {
            if ( /*args.isTreeOrderConsistent()*//* true) {
                //oder mit angle
                double hyp = Math.sqrt(dx * dx + dy * dy);
                a = hyp * Math.cos(angle);
                //TODO überarbeitenb
                x5 = x4 + Math.cos(angle) * a;
                y5 = y4 - Math.sin(angle) * a;

            }
        }*/
        /** versuch hinweis zu verwenden ....
        double hyp = Math.sqrt(dx * dx + dy * dy);
        a = hyp * Math.cos(angle);
        x5 = Math.cos(angle) * a + x4;
        y5 = Math.sin(angle) * a - y4; */

        /*double x51;
        double y51;
        double x52;
        double y52;

        double p = Math.tan( angle + Math.atan(dy/dx)); //tan(alpha + epsilon)
        c = Math.sqrt( dx*dx + dy*dy); //hypotenuse des Dreiecks
        x51 = -( p/2) - Math.sqrt( (p/2)*(p/2) - Math.cos(angle)*Math.cos(angle) * c); //erste Lösung der quadr. Gleichung
        x52 = -( p/2) + Math.sqrt( (p/2)*(p/2) - Math.cos(angle)*Math.cos(angle) * c); //zweite Lösung der quadr. Gleichung

        y51 = p*x51;
        y52 = p*x52;

        double x5_1 = x4 - x51;
        double x5_2 = x4 - x52;
        double y5_1 = y4 + y51;
        double y5_2 = y4 + y52;*/

        Vector vc = new Vector(x4, y4, x3, y3);
        c = vc.length();
        vc.drehen(angle);
        a = ( c / Math.sin(Math.PI / 2)) * Math.sin(angle);
        x5 = x4 - (vc.a / vc.length()) * a;
        y5 = y4 + (vc.b / vc.length()) * a;


        //TODO löschen
        if(branch > 3 /*< args.getMinSize()*/) {
            return;
        }

        //Hilfe zu canvas https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html#rect-double-double-double-double-
        //Draw square
        gc.setFill(color);
        double[] xrec = {x1, x2, x3, x4};
        double[] yrec = {y1, y2, y3, y4};
        gc.strokePolygon(xrec, yrec, 4);
        gc.fill();
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
        gc.fill();
        /*gc.setStroke(Color.BLUE);
        double[] xs = {x3, x4, x5_1};
        double[] ys = {y3, y4, y5_1};
        gc.strokePolygon(xs, ys, 3);

        gc.setStroke(Color.GREEN);
        double[] xs1 = {x3, x4, x5_2};
        double[] ys1 = {y3, y4, y5_2};
        gc.strokePolygon(xs1, ys1, 3);*/

        //gc.strokePolygon(double[] x, double[] y, int nPoints); - Points mit Koordinaten als Array, number of Points
       /* gc.strokeLine(x4, y4, x5, y5);
        gc.strokeLine(x5, y5, x3, y3); */
        Color col1 = args.getColor1();
        Color col2 = args.getColor2();
      /*  if (args.isTreeColorSchemeBranch()) {
            col1 = args.getColor1();
            col2 = args.getColor2();
        } else {
            if (branch < 5) {
                col1 = args.getColor1();
            } else if (branch >= 5 && branch <10){
                col1 = args.getColor2();
            } else {
                col1 = args.getColor3();
            }
            col2 = col1;
        }*/

       draw(gc, x4, y4, x5, y5, args, col1, branch + 1);
        draw(gc, x5, y5, x3, y3, args, col2, branch + 1);

    }

    public void exit()
    {
        this.currentStage.close();
    }
}

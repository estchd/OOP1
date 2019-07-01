package OOP5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class responsible for calulating and drawing the respective shapes that make the tree.
 *
 * @author Josi
 */
public class PythagorasBäume extends Application {

    private Stage currentStage;

    /**
     * Getter.
     * @author Josi
     * @return DrawCanvas that is currently used
     */
    public DrawCanvas getDrawCanvas() {
        return drawCanvas;
    }

    /**
     * Setter.
     * @author Josi
     * @param drawCanvas - DrawCanvas to set.
     */
    public void setDrawCanvas(DrawCanvas drawCanvas) {
        this.drawCanvas = drawCanvas;
    }

    private DrawCanvas drawCanvas;

    /**
     * Start and launch application.
     *
     * @author Josi
     * @param primaryStage - Stage used.
     */
    @Override
    public void start(Stage primaryStage) {

        currentStage = primaryStage;
        currentStage.setTitle("Pythagoras Bäume");

        setScene(new InputScene(this));

        currentStage.show();
    }

    /**
     * Setter for the scene object.
     * @author Josi
     * @param scene
     */
    public void setScene(Scene scene){
        currentStage.hide();
        currentStage.setScene(scene);
        currentStage.show();
    }


    /**
     * Prepares the initial Vectors and colors, and calls the method for drawing the tree.
     *
     * @author Josi
     * @param args - DrawArguments used to identify color, length and drawing schemes.
     */
    public void drawTree(DrawArguments args) {
        DrawScene drawi = new DrawScene(args, this);
        //drawi.hei
        setScene(drawi);
        double s1 = args.getSide1();
        double s2 = args.getSide2();
        double sideLength = Math.sqrt( Math.pow(s1, 2) + Math.pow(s2, 2));

        //compute center of canvas
        double x =  (drawCanvas.getWidth() / 2 );
       // double startY =  (drawCanvas.getHeight() / 2 );
        double startY =  drawCanvas.getHeight() - drawCanvas.getHeight() / 3 ;

        double x1 = x - ( sideLength / 2);
        double y1 = startY ;
        double x2 = x + ( sideLength /2);
        double y2 = startY ;

        Vector2 p1 = new Vector2(x1,startY + sideLength);
        Vector2 p2 = new Vector2(x2, startY + sideLength);


       GraphicsContext gc = drawCanvas.getGraphicsContext2D();

        Color col;
        //Färbung
        if (args.isTreeColorSchemeBranch()) {
            //Wurzelfarbe
            col = args.getColor3();
        } else {
            //Asttiefe = 1
           col = args.getColor1();
        }

        draw(gc, p1, p2, args, col, 1);
    }

    /**
     * Recursive method to generate the Pythagorean tree.
     * This method draws a rectangle using the specified x and y values and creates a
     * triangle with the specified parameters in the DrawArguments, as well as colors
     * the rectangle (and triangle) in the specified color.
     * Then continues by recursively call itself two times to create two new rectangles
     * and triangles.
     *
     * @author Josi
     *
     * @param gc - GraphicsContext to use to draw with.
     * @param p1 - Start Point 1 as Vector2.
     * @param p2 - Start Point 2 as Vector2.
     * @param args - DrawArguments to draw with the specified colors and schemes, as
     *             well as get side lengths and ratios.
     * @param color - Color used to fill created rectangle (and triangle) with.
     * @param branch - The current branch that is being generated.
     */
    private void draw(GraphicsContext gc, Vector2 p1, Vector2 p2, DrawArguments args, Color color, int branch)
    {
        gc.setStroke(Color.BLACK);

        //Rectangle
        Vector2 directionVector = new Vector2(p1,p2);

        Vector2 perpendicularVector = directionVector.GetPerpendicularCounterClockwise();

        Vector2 rectUpLeft = p1.Add(perpendicularVector);
        Vector2 rectUpRight = p2.Add(perpendicularVector);

        //Triangle
        double originalLength = Math.sqrt(Math.pow(args.getSide1(), 2) + Math.pow(args.getSide2(), 2));
        double currentLength =  new Vector2(rectUpLeft , rectUpRight).length();

        double lengthRatio = currentLength / originalLength;

        double side1Length;
        double side2Length;

        //ab hier nun wechsel einbauen
        if(!args.isTreeOrderConsistent() && (branch % 2 == 0)){
            side2Length = args.getSide1() * lengthRatio;
            side1Length = args.getSide2() * lengthRatio;
        } else {
            side1Length = args.getSide1() * lengthRatio;
            side2Length = args.getSide2() * lengthRatio;
        }
        double triTopX = (Math.pow(side1Length , 2) + Math.pow(directionVector.length() , 2) - Math.pow(side2Length , 2)) / (2 * directionVector.length());

        double triTopY = Math.sqrt(Math.pow(side1Length , 2) - Math.pow(triTopX , 2));

        Vector2 directionUnitVector = directionVector.UnitVector();

        Vector2 xVector = directionUnitVector.Mul(triTopX).Mul(-1);
        Vector2 yVector = directionVector.UnitVector().GetPerpendicularCounterClockwise().Mul(triTopY);

        Vector2 triTop = rectUpLeft.Add(xVector).Add(yVector);

        //Draw Rectangle
        StrokeLine(gc,p1,p2);
        StrokeLine(gc,p1,rectUpLeft);
        StrokeLine(gc,p2,rectUpRight);
        StrokeLine(gc,rectUpLeft,rectUpRight);

        //fill rect
        gc.setFill(color);
        double[] xrec = {p1.x, rectUpLeft.x, rectUpRight.x, p2.x};
        double[] yrec = {p1.y, rectUpLeft.y, rectUpRight.y, p2.y};
        gc.fillPolygon(xrec, yrec, 4);

        if(directionVector.length() < args.getMinSize()){
            return;
        }

        //Draw Triangle
        StrokeLine(gc,rectUpLeft,triTop);
        StrokeLine(gc,rectUpRight,triTop);

        //fill triangle
        //gc.fillPolygon(new double[]{rectUpLeft.x, triTop.x, rectUpRight.x}, new double[]{rectUpLeft.y, triTop.y, rectUpRight.y}, 3);

        System.out.println("");

        //Färbung
        Color col1;
        Color col2;
        if (args.isTreeColorSchemeBranch()) {
            if (side1Length < side2Length) {
                col1 = args.getColor1();
                col2 = args.getColor2();
            } else {
                col2 = args.getColor1();
                col1 = args.getColor2();
            }
        } else {
            if (branch < 5) {
                col1 = args.getColor1();
            } else if (branch <10){
                col1 = args.getColor2();
            } else {
                col1 = args.getColor3();
            }
            col2 = col1;
        }

        //Left Branch
        draw(gc,rectUpLeft,triTop,args,col1,branch + 1);

        //Right Branch
        draw(gc,triTop,rectUpRight,args,col2,branch + 1);


        /** versuch hinweis zu verwenden ....
        double hyp = Math.sqrt(dx * dx + dy * dy);
        a = hyp * Math.cos(angle);
        x5 = Math.cos(angle) * a + x4;
        y5 = Math.sin(angle) * a - y4; */

    }

    /**
     * Small Method to stroke line between two Vector2.
     *
     * @author Josi
     * @param gc - GraphicsContext to use to draw with.
     * @param p1 - Start Point 1 as Vector2.
     * @param p2 -  End Point 2 as Vector2.
     */
    private void StrokeLine(GraphicsContext gc, Vector2 p1, Vector2 p2){
        gc.strokeLine(p1.x,p1.y,p2.x,p2.y);
    }

    /**
     * Close Applicatiom
     * @author Josi
     */
    public void exit()
    {
        this.currentStage.close();
    }
}

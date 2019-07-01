package OOP5;

import javafx.scene.paint.Color;

/**
 * DrawArguments provides the paramters used for
 * specifying the drawn tree.
 *
 * @author Josi and Erik
 */
public class DrawArguments {

    private int side1;
    private int side2;
    private int minSize;
    private boolean isTreeOrderConsistent;
    private boolean isTreeColorSchemeBranch;
    private Color color1;
    private Color color2;

    /**
     * Getter for side1.
     * @return side1 as int.
     */
    public int getSide1() {
        return side1;
    }

    /**
     * Setter for side1.
     * @param side1 - int used to set side1 to.
     */
    public void setSide1(int side1) {
        this.side1 = side1;
    }

    /**
     * Getter for side2.
     * @return side2 as int.
     */
    public int getSide2() {
        return side2;
    }

    /**
     * Setter for side2.
     * @param side2 - int used to set side2 to.
     */
    public void setSide2(int side2) {
        this.side2 = side2;
    }

    /**
     * Getter for minSize.
     * @return int minSize.
     */
    public int getMinSize() {
        return minSize;
    }

    /**
     * Setter for minSize, which does
     * not allow minSize to be below 1.
     * @param minSize - int which minSize should be set to.
     */
    public void setMinSize(int minSize) {
        if (minSize > 1) {
            this.minSize = minSize;
        } else {
            this.minSize = 1;
        }
    }

    /**
     * Getter for isTreeOrderConsistent.
     * @return boolean isTreeOrderConsistent.
     */
    public boolean isTreeOrderConsistent() {
        return isTreeOrderConsistent;
    }

    /**
     * Setter for isTreeOrderConsistent.
     * @param treeOrderConsistent - boolean isTreeOrderConsistent should be set to.
     */
    public void setTreeOrderConsistent(boolean treeOrderConsistent) {
        isTreeOrderConsistent = treeOrderConsistent;
    }

    /**
     * Getter for isTreeColorSchemeBranch.
     * @return boolean isTreeColorSchemeBranch
     */
    public boolean isTreeColorSchemeBranch() {
        return isTreeColorSchemeBranch;
    }

    /**
     * Setter for isTreeColorSchemeBranch.
     * @param treeColorSchemeBranch - boolean isTreeColorSchemeBranch should be set to.
     */
    public void setTreeColorSchemeBranch(boolean treeColorSchemeBranch) {
        isTreeColorSchemeBranch = treeColorSchemeBranch;
    }

    /**
     * Getter for color1.
     * @return color1 as Color.
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * Setter for color1.
     * @param color1 - Color color1 should be set to.
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * Getter for color2.
     * @return color2 as Color.
     */
    public Color getColor2() {
        return color2;
    }

    /**
     * Setter for color2.
     * @param color2 - Color color2 should be set to.
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    /**
     * Getter for color3.
     * @return color3 as Color.
     */
    public Color getColor3() {
        return color3;
    }

    /**
     * Setter for color3.
     * @param color3 - Color color3 should be set to.
     */
    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    private Color color3;

    /**
     * Constructor which initalizes all arguments.
     * @param side1 - int side1 of the triangle.
     * @param side2 - int side2 of the triangle.
     * @param minSize - int minSize of the rectangle.
     * @param isTreeOrderConsistent - boolean to switch between consistent and inconsistent tree order.
     * @param isTreeColorSchemeBranch - boolean to switch between the two color schemes
     *                                true for coloring the bigger sides differently, false for depth coloring.
     * @param color1 - Color color1, either root color, or branch depth <= 5
     * @param color2 - Color color2, either color for bigger sides of triangle, or branch depth between 5 and 10
     * @param color3 - Color color3, either color for smaller sides of triangle, or branch depth > 10
     */
    public DrawArguments(int side1, int side2, int minSize, boolean isTreeOrderConsistent, boolean isTreeColorSchemeBranch, Color color1, Color color2, Color color3){
            this.side1 = side1;
            this.side2 = side2;
            setMinSize(minSize);
            this.isTreeOrderConsistent = isTreeOrderConsistent;
            this.isTreeColorSchemeBranch = isTreeColorSchemeBranch;
            this.color1 = color1;
            this.color2 = color2;
            this.color3 = color3;
    }
}

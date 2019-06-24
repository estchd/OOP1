package OOP5;

import javafx.scene.paint.Color;

public class DrawArguments {

    private int side1;
    private int side2;
    private int minSize;
    private boolean isTreeOrderConsistent;
    private boolean isTreeColorSchemeBranch;
    private Color color1;
    private Color color2;

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public boolean isTreeOrderConsistent() {
        return isTreeOrderConsistent;
    }

    public void setTreeOrderConsistent(boolean treeOrderConsistent) {
        isTreeOrderConsistent = treeOrderConsistent;
    }

    public boolean isTreeColorSchemeBranch() {
        return isTreeColorSchemeBranch;
    }

    public void setTreeColorSchemeBranch(boolean treeColorSchemeBranch) {
        isTreeColorSchemeBranch = treeColorSchemeBranch;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    private Color color3;

    public DrawArguments(int side1, int side2, int minSize, boolean isTreeOrderConsistent, boolean isTreeColorSchemeBranch, Color color1, Color color2, Color color3){
            this.side1 = side1;
            this.side2 = side2;
            this.minSize = minSize;
            this.isTreeOrderConsistent = isTreeOrderConsistent;
            this.isTreeColorSchemeBranch = isTreeColorSchemeBranch;
            this.color1 = color1;
            this.color2 = color2;
            this.color3 = color3;
    }
}

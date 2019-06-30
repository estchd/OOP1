package OOP5;

/**
 * Vector Helpclass for PythagorasBäume.
 *
 * @author Josi & Erik
 */
public class Vector2 {

    public double x;
    public double y;

    /**
     * Construktor with coordinates.
     *
     * @param x - double used as x-coordinate.
     * @param y - double used as y-coordinate.
     */
    public Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Construktor with two vectors.
     * @param p1 - Vector2 used as starting point.
     * @param p2 - Vector2 used as ending point.
     */
    public Vector2(Vector2 p1, Vector2 p2)
    {
        this.x = p1.x - p2.x;
        this.y = p1.y - p2.y;
    }

    /**Getter.
     * @return normalized Clockwise Vector2
     */
    public Vector2 GetPerpendicularClockwise(){
        return new Vector2(this.y,-this.x);
    }

    /**Getter.
     * @return normalized Counterclockwise Vector2
     */
    public Vector2 GetPerpendicularCounterClockwise(){
        return new Vector2(-this.y,this.x);
    }

    /**
     * The sum of the coordinates of two Vector2.
     * @param vector - Vector 2 with the coordinates to add.
     * @return Vector2 with sum of the coordinates.
     */
    public Vector2 Add(Vector2 vector)
    {
        return new Vector2(x + vector.x, y + vector.y);
    }

    /**
     * Mulitply Vector2.
     * @param a - double used to multiply.
     * @return V>ector2 with multiplied coordiantes.
     */
    public Vector2 Mul(double a)
    {
        return new Vector2(x * a, y * a);
    }

    /**
     * Create unitvector.
     * @return Vector2 as unitvector.
     */
    public Vector2 UnitVector()
    {
        double length = this.length();
        return new Vector2(this.x / length, this.y / length);
    }

    /**
     * Calculate length of this Vector.
     * @return length as Double.
     */
    public double length(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
    }

}

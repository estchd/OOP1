package OOP5;

public class Vector2 {

    public double x;
    public double y;


    public Vector2(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 p1, Vector2 p2)
    {
        this.x = p1.x - p2.x;
        this.y = p1.y - p2.y;
    }


    public Vector2 GetPerpendicularClockwise(){
        return new Vector2(this.y,-this.x);
    }

    public Vector2 GetPerpendicularCounterClockwise(){
        return new Vector2(-this.y,this.x);
    }

    public Vector2 Add(Vector2 vector)
    {
        return new Vector2(x + vector.x, y + vector.y);
    }

    public Vector2 Mul(double a)
    {
        return new Vector2(x * a, y * a);
    }

    public Vector2 UnitVector()
    {
        double length = this.length();
        return new Vector2(this.x / length, this.y / length);
    }

    public double length(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
    }

    public void drehen(double phi){
        this.x = x*Math.cos(phi) + y*(-Math.sin(phi));
        this.y = x*Math.sin(phi) + y*Math.cos(phi);

    }
}

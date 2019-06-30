package OOP5;

public class Vector {

    public double a;
    public double b;

    public Vector(double x1, double y1, double x2, double y2){
        this.a = x1 - x2;
        this.b = y1 - y2;
    }

    public void drehen(double phi){
        this.a = a*Math.cos(phi) + b*(-Math.sin(phi));
        this.b = a*Math.sin(phi) + b*Math.cos(phi);

    }

    public double length(){
        double laenge = Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
        return laenge;
    }
}

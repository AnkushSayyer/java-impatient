package com.hashmap.excercise.chapter2;

/**
 * Implement an immutable class Point that describes a point in the plane. Provide a constructor
 * to set it to a specific point, a no-arg constructor to set it to the origin, and methods getX,
 * getY, translate, and scale. The translate method moves the point by a given
 * amount in x- and y-direction. The scale method scales both coordinates by a given factor.
 * Implement these methods so that they return new points with the results.
 */

final class Point {

    private final MyDouble x;
    private final MyDouble y;

    Point(){
        x = new MyDouble();
        y = new MyDouble();
    }

    Point(double x, double y){
        this.x = new MyDouble(x);
        this.y = new MyDouble(y);
    }

    public double getX(){
        return this.x.getValue();
    }

    public double getY(){
        return this.y.getValue();
    }

    public void translate(double x, double y){
        this.x.setValue(this.x.getValue() + x);
        this.y.setValue(this.y.getValue() + y);
    }

    public void scale(double scale){
        this.x.setValue(this.x.getValue()*scale);
        this.y.setValue(this.y.getValue()*scale);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}

class MyDouble{
    private double value;

    public MyDouble(){
        this.value = 0;
    }

    public MyDouble(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double x) {
        this.value = x;
    }

}

public class Q5{
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5);
        System.out.println(p);
    }
}

package com.hashmap.excercise.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implement a class Car that models a car traveling along the x-axis, consuming gas as it moves.
 * Provide methods to drive by a given number of miles, to add a given number of gallons to the
 * gas tank, and to get the current distance from the origin and fuel level. Specify the fuel
 * efficiency (in miles/gallons) in the constructor. Should this be an immutable class? Why or why
 * not?
 */

class Car{
    private final double efficiency;
    private final double initialPos;
    private double fuel;
    private double curPos;

    {
        initialPos = 0.0;
    }

    public Car(int e) {
        efficiency = e;
    }

    public boolean drive(float drive){

        if(!checkFuel(drive))
            return false;

        curPos = curPos + drive;
        return true;
    }

    private boolean checkFuel(float drive) {
        if(fuel==0) {
            System.out.println("\nFuel tank EMPTY!!!!!!");
            return false;
        }
        else if(drive>fuel*efficiency){
            System.out.println("\nNot enough fuel!!");
            return false;
        }

        return true;
    }

    public double getDistanceFromOrigin(){
        return curPos - initialPos;
    }

    public void addFuel(double fuel){
        this.fuel = this.fuel + fuel;
    }

    public double getFuel(){
        return fuel;
    }
}

public class Q9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter efficiency for car = ");
        Car c = new Car(Integer.parseInt(br.readLine()));

        System.out.print("Add fuel to car = ");
        c.addFuel(Integer.parseInt(br.readLine()));

        System.out.print("Enter distance to drive = ");

        if(c.drive(Integer.parseInt(br.readLine()))) {

            System.out.println("After driving.................");

            System.out.println("Current distance from origin = " + c.getDistanceFromOrigin());

            System.out.println("Current fuel level = " + c.getFuel());
        }
    }
}

package com.car;
// It should have a few fields that would be appropriate for a generic car class.
// engine, cylinders, wheels, etc.
// Constructor should initialize cylinders (number of) and name, and set wheels to 4
// and engine to true. Cylinders and names would be passed parameters.

// Create appropriate getters
// Create some methods like startEngine, accelerate, and brake
// show a message for each in the base class

public class Car {
    private String name;
    private boolean isEngineOn;
    private int cylinders;
    private int wheels;
    private int speed;

    public Car(String n, int c){
        this.wheels = 4;
        this.name = n;
        this.isEngineOn = false;
        this.cylinders = c;
    }

    public void startEngine(){
        System.out.println("Starting engine!");
        this.isEngineOn = true;
    }

    public void accelerate(int accelBy){
        if(!isEngineOn) {
            System.out.println("Can't accelerate without starting engine.\n");
            this.startEngine();
        }
        System.out.println("Accelerate():\nCurrent speed: " + this.speed);
        this.speed += accelBy;
        System.out.println("Increasing speed to " + this.speed);
    }

    public void brake(){
        System.out.println("Brake():\nCurrent speed: " + this.speed
                                            + "\nApplying brakes!");
        this.speed = 0;
        System.out.println("Speed: " + this.speed);
    }

    public void turnOffEngine(){
        System.out.println("Turning off car!");
        this.isEngineOn = false;
    }

    @Override
    public String toString() {
        return "Car info:\nName: " + this.name + "\nCylinders: "
                            + this.cylinders + "\nRunning? " + this.isEngineOn;
    }

}

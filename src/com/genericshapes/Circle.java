package com.genericshapes;

public class Circle extends Shape {

    private Double radius, area;
    private static final String name = "Circle";

    public Circle(Double r) {
        radius = r;
        area = Math.PI*radius*radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println(name + " with a radius of " + radius + " and an area of " + area);
    }
}

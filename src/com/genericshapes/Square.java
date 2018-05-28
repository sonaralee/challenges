package com.genericshapes;

public class Square extends Shape {
    private Double side, area;
    private static final String name = "Square";


    public Square(Double s) {
        side = s;
        area = side*side;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println(name + " with a side length of " + side + " and and area of " + area);
    }
}

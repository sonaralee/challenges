package com.genericshapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Circle> cList = new ArrayList<>();
        cList.add(new Circle(5.0));
        cList.add(new Circle(11.0));
        cList.add(new Circle(2.0));

        List<Square> sList = new ArrayList<>();
        sList.add(new Square(5.0));
        sList.add(new Square(11.0));
        sList.add(new Square(2.0));

        System.out.println("Describing circles...");
        describeAll(cList);
        System.out.println("\nDescribing squares...");
        describeAll(sList);
    }

    public static void describeAll(List<? extends Shape> shapes) {
        for(Shape s : shapes) {
            s.describe();
        }
    }
}

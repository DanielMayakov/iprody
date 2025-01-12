package org.example.geometry;

import java.util.List;

public class AreaCalculator {

    public static double calculateTotalArea(List<Figure> figures) {
        double totalArea = 0;

        for (Figure figure : figures) {
            totalArea += figure.calculateArea();
        }

        return totalArea;
    }

    public static void main(String[] args) {
        List<Figure> figures = List.of(
                new Circle(5),
                new Triangle(10, 8),
                new Square(4)
        );

        double totalArea = calculateTotalArea(figures);
        System.out.println("Суммарная площадь всех фигур: " + totalArea);
    }
}

package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

public class Circle extends Ellipse{

    public Circle(String id, String color, double x, double y, double radius) {
        super(id, color, x, y, radius, radius);
        super.setType("circle");
    }
}

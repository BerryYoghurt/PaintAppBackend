package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

public class Ellipse extends Shape{

    public Ellipse(String id, String color, double x, double y, double height, double width) {
        super(id, color, x, y, width, height);
    }

    @Override
    public boolean hasPoint(double x, double y) {
        return false;
    }
}

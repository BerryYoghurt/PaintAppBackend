package eg.edu.alexu.csd.oop.draw.cs.shapes.model;


public class Line extends Shape {

    public Line(String id, String color, double x, double y){
        super(id, color, x, y, 0, 0);
    }
    @Override
    public boolean hasPoint(double x, double y) {
        return false;
    }
}

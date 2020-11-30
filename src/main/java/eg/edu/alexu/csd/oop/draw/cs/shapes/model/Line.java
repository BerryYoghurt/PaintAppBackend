package eg.edu.alexu.csd.oop.draw.cs.shapes.model;


public class Line extends Shape {

    public Line(String id, String color, double x, double y, double width, double height){
        super(id, color, x, y, width, height);
        super.setType("line");
    }
    @Override
    public boolean hasPoint(double x, double y) {
        return false;
    }
}

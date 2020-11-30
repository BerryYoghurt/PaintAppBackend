package eg.edu.alexu.csd.oop.draw.cs.shapes.control;

import eg.edu.alexu.csd.oop.draw.cs.shapes.model.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {
    public static Shape classifyShape(String type, Shape shape){
        type = type.toLowerCase();
        return switch (type) {
            case "line" -> createLine(shape);
            case "triangle" -> createTriangle(shape);
            case "circle" -> createCircle(shape);
            case "ellipse" -> createEllipse(shape);
            case "rectangle" -> createRectangle(shape);
            default -> null;
        };
    }

    private static Shape createRectangle(Shape shape) {
        Rectangle r = new Rectangle(shape.getId(), shape.getColor(), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        //no need to define lines since they can be calculated from x, y, width and height
        return r;
    }

    private static Shape createEllipse(Shape shape) {
        Ellipse e = new Ellipse(shape.getId(), shape.getColor(), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        return e;
    }

    private static Shape createCircle(Shape shape) {
        Circle c = new Circle(shape.getId(), shape.getColor(), shape.getX(), shape.getY(), shape.getWidth());
        return c;
    }

    private static Shape createTriangle(Shape shape) {
        double x = shape.getX();
        double y = shape.getY();
        List<Line> lines = new ArrayList<>();
        //lines.add(new Line(null, ))
        Triangle t = new Triangle(shape.getId(), shape.getColor(), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());//for now
        return t;
        //TODO
    }

    private static Shape createLine(Shape shape) {
        Line l = new Line(shape.getId(), shape.getColor(), shape.getX(), shape.getY(),shape.getWidth(), shape.getHeight());
        return l;
    }
}

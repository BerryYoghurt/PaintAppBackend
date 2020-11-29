package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

import java.util.List;

public abstract class Polygon extends Shape{
    private List<Line> lines;

    public Polygon(String id, String color, double x, double y, double width, double height) {
        super( id,color, x, y,width, height);
    }
    //TODO must have a mechanism to set maximum lines

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}

package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

import java.util.List;

public abstract class Polygon extends Shape{
    private List<Line> lines;
    //TODO must have a mechanism to set maximum lines

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}

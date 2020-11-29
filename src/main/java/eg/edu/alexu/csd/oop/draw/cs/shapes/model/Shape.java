package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public abstract class Shape implements Cloneable{
    private String id; //unchangeable
    private String color;
    private double x;
    private double y;
    private double width;
    private double height;


    public abstract boolean hasPoint(double x, double y);
    public abstract Shape clone();
    public void move(double x, double y){

    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

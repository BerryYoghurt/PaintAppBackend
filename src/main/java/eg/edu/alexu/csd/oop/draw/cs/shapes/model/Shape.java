package eg.edu.alexu.csd.oop.draw.cs.shapes.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Shape implements Cloneable{
    private String id;
    private String color;
    private double x;
    private double y;
    private double width;
    private double height;
    private boolean deleted;

    public Shape(){

    }
    public Shape(String id, String color, double x, double y, double width, double height){
        this.id = id;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        deleted = false;
    }

    public boolean hasPoint(double x, double y){return false;};
    //public Shape clone(){}
    public void move(Double[] coordinates){
        if(coordinates.length != 2){
            throw new IllegalArgumentException("coordinates has to have exactly 2 elements");
        }
        this.x = coordinates[0];
        this.y = coordinates[1];
    }
    public void resize(Double[] newSize){
        if(newSize.length != 2){
            throw new IllegalArgumentException("newSize has to have exactly 2 elements");
        }
        this.width = newSize[0];
        this.height = newSize[1];
    }
    public void color(String[] color){
        if(color.length != 1){
            throw new IllegalArgumentException("color has to have exactly 1 element");
        }
        this.color = color[0];
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

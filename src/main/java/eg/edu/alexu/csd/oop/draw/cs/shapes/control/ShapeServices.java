package eg.edu.alexu.csd.oop.draw.cs.shapes.control;

import eg.edu.alexu.csd.oop.draw.cs.actions.Action;
import eg.edu.alexu.csd.oop.draw.cs.shapes.model.Shape;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class ShapeServices {
    private List<Shape> shapes = new ArrayList<>();
    /**
     * stores recent changes, should be popped when undoing is required*/
    private Stack<Action<?>> undo = new Stack<>();
    /**
     * stored recent undid changes, should be popped when redoing is required*/
    private Stack<Action<?>> redo = new Stack<>();

    public void add(Shape newShape) {
        this.shapes.add(newShape);
        this.undo.push(new Action<>(newShape.getId(),null,null, new Shape[]{newShape}));
    }

    public void undo() {
        Action<?> action = undo.pop();
        Shape s = getShapeByID(action.getShapeID());

        if(action.getOldParams() == null){//shape was created
            s.setDeleted(true);
        }else if(action.getNewParams() == null){//shape was deleted
            s.setDeleted(false);
        }else{//shape was modified
            action.undo();
        }

        redo.push(action);
    }

    public void redo() {
        Action<?> action = redo.pop();
        String id = action.getShapeID();
        Shape s = getShapeByID(id);
        if(action.getOldParams() == null){ //shape was created
            s.setDeleted(true);
        }else if(action.getNewParams() == null) {//shape was deleted
            s.setDeleted(false);
        }else{
            action.redo();
        }
        undo.push(action);
    }

    public void delete(String shapeID) {
        Shape s = getShapeByID(shapeID);
        Action<Shape> action = new Action<>(shapeID,null,new Shape[]{s},null);//TODO
        undo.add(action);
        s.setDeleted(true);
    }

    public void move(String shapeID, double x, double y) {
        Shape s = getShapeByID(shapeID);
        Double[] destination = new Double[]{x,y};
        Action<Double> action = new Action<>(
                shapeID,
                s::move,
                new Double[]{s.getX(),s.getY()},
                destination);
        s.move(destination);
        undo.push(action);
    }

    public void resize(String shapeID, double width, double height) {
        Shape s = getShapeByID(shapeID);
        Double[] newSize = new Double[]{width, height};
        Action<Double> action = new Action<>(
                shapeID,
                s::resize,
                new Double[]{s.getWidth(),s.getHeight()},
                newSize);
        s.resize(newSize);
        undo.push(action);
    }

    public void color(String shapeID, String color) {
        Shape s = getShapeByID(shapeID);
        String[] c = new String[]{color};
        Action<String> action = new Action<>(
                shapeID,
                s::color,
                new String[]{s.getColor()},
                c);
        s.color(c);
        undo.push(action);
    }

    private Shape getShapeByID(String shapeID){
        Shape s = shapes.stream().filter(shape -> shape.getId().equals(shapeID)).findAny().get();
        return s;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}

package eg.edu.alexu.csd.oop.draw.cs.shapes.control;

import eg.edu.alexu.csd.oop.draw.cs.actions.Action;
import eg.edu.alexu.csd.oop.draw.cs.shapes.model.Shape;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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
        this.undo.push(new Action<Shape>(newShape.getId(),null,null, new Shape[]{newShape}));
    }

    public void undo() {
        Action<?> action = undo.pop();

        if(action.getOldParams() == null){//shape was created

        }else if(action.getNewParams() == null){//shape was deleted

        }else{//shape was modified

        }
        String id = action.getShapeID();
        Shape s = shapes.stream().filter(x -> {return x.getId().equals(id);}).findAny().get();

        try {
            if(!action.undo(s)){//last action done was creation
                shapes.remove(s);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        redo.push(action);
    }

    public void redo() {
        Action<?> action = redo.pop();
        if(action.getOldParams() == null){//instantiate shape
            shapes.add(((Action<Shape>)action).getNewParams()[0]);
        }else{
            String id = action.getShapeID();
            Shape s = shapes.stream().filter(x->{return x.getId().equals(id);}).findAny().get();
            try {
                action.redo(s);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        undo.push(action);

    }

    public void delete(String shapeID) {
        Shape s = shapes.stream().filter(x -> {return x.getId().equals(shapeID);}).findAny().get();
        Action<Shape> action = new Action<>(shapeID,null,new Shape[]{s},null);//TODO
        undo.add(action);
        shapes.remove(s);
    }

    public void move(String shapeID, double x, double y) {

        Action<Double> action = new Action<Double>(shapeID, Shape.class.getMethod("move"), new Double[]{},new Double[]{});
    }

    public void resize(String shapeID) {
    }

    public void color(String shapeID) {
    }
}

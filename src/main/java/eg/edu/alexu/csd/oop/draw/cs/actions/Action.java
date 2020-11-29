package eg.edu.alexu.csd.oop.draw.cs.actions;


//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.util.function.Consumer;
/**
 * responsible for storing, undoing and redoing user's actions, NOT for doing them first time
 * if method is null, nothing will be done*/
public class Action<T> {
    private final String shapeID;
    private final Consumer<T[]> method;
    private final T[] oldParams;
    private final T[] newParams;
    public Action(String shapeID, Consumer<T[]> method, T[] oldParams, T[] newParams){
        this.method = method;
        this.shapeID = shapeID;
        this.oldParams = oldParams;
        this.newParams = newParams;
    }
    public boolean undo(){
        if(method == null || oldParams == null)//instantiation
        {
            return false;
        }
        else{
            method.accept(oldParams);
            return true;
        }
    }

    public boolean redo() {
        if(method == null || newParams == null){//deletion
            return false;
        }else{
            method.accept(newParams);
            return true;
        }
    }

    public String getShapeID() {
        return shapeID;
    }

    public T[] getOldParams() {
        return oldParams;
    }

    public T[] getNewParams() {
        return newParams;
    }
}

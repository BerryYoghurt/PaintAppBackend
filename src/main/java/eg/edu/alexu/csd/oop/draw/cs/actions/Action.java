package eg.edu.alexu.csd.oop.draw.cs.actions;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Action<T> {
    private String shapeID;
    private Method method;
    private T[] oldParams;
    private T[] newParams;
    public Action(String shapeID, Method method, T[] oldParams,T[] newParams){
        this.method = method;
        this.shapeID = shapeID;
        this.oldParams = oldParams;
        this.newParams = newParams;
    }
    public boolean undo(Object s) throws InvocationTargetException, IllegalAccessException {
        if(method == null)//creation
        {
            return false;
        }
        else{
            method.invoke(s,oldParams);
            return true;
        }
    }

    public boolean redo(Object s) throws InvocationTargetException, IllegalAccessException {
        if(method == null){
            return false;
        }else{
            method.invoke(s,newParams);
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

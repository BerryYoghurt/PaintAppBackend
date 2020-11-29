package eg.edu.alexu.csd.oop.draw.cs.shapes.control;

import eg.edu.alexu.csd.oop.draw.cs.shapes.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShapeController {
    @Autowired
    private ShapeServices services;

    @PostMapping(value = "/shapes/{type}")
    public void addShape(@PathVariable String type, @RequestBody Shape shape){
        Shape newShape = ShapeFactory.classifyShape(type,shape);
        services.add(newShape);
    }

    @GetMapping("/undo")
    public void undo(){
        services.undo();
    }

    @GetMapping("/redo")
    public void redo(){
        services.redo();
    }

    @PutMapping("/delete/{id}")
    public void deleteShape(@PathVariable String shapeID){
        services.delete(shapeID);
    }

    @PutMapping("/move/{id}")
    public void moveShape(@PathVariable String shapeID, @RequestParam("x") double x, @RequestParam("y") double y){
        services.move(shapeID, x, y);
    }

    public void resizeShape(String shapeID){
        services.resize(shapeID);
    }

    public void recolorShape(String shapeID){
        services.color(shapeID);
    }

    public void save(){

    }

    public void load(){

    }

}

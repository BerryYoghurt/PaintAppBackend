package eg.edu.alexu.csd.oop.draw.cs.shapes.control;

import eg.edu.alexu.csd.oop.draw.cs.shapes.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void deleteShape(@PathVariable("id") String shapeID){
        services.delete(shapeID);
    }

    @PutMapping("/move/{id}")
    public void moveShape(@PathVariable("id") String shapeID, @RequestParam(value = "x") double x, @RequestParam(value = "y") double y){
        services.move(shapeID, x, y);
    }

    @PutMapping("/resize/{id}")
    public void resizeShape(@PathVariable("id") String shapeID, @RequestParam(value = "width") double width, @RequestParam(value = "height") double height){
        services.resize(shapeID, width, height);
    }

    @PutMapping("/recolor/{id}")
    public void recolorShape(@PathVariable("id") String shapeID, @RequestParam(value = "color") String color){
        services.color(shapeID,color);
    }

    @GetMapping(value = "/save", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Shape> save(){
        return services.getShapes().stream().filter(x->!x.isDeleted()).allMatch(); //TODO pick only not deleted
    }

    @PostMapping(value = "load", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Shape> load(@RequestBody List<Shape> shapes){
        //TODO
        return services.getShapes();
    }

}

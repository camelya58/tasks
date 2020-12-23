package paterns.structural.decorator.shapedecorator.shapes;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a shape: CIRCLE!");
    }
}

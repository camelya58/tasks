package paterns.structural.decorator.shapedecorator.decorators;


import paterns.structural.decorator.shapedecorator.shapes.Shape;

/**
 * Class RedShapeDecorator
 *
 * @author Kamila Meshcheryakova
 * created by 03.11.2020
 */
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        super.draw();
    }

    private void setBorderColor(Shape shape) {
        System.out.printf("Setting the border color for %s to red.", shape.getClass().getSimpleName());
        System.out.println();
    }
}

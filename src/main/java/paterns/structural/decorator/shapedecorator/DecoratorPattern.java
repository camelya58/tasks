package paterns.structural.decorator.shapedecorator;

import paterns.structural.decorator.shapedecorator.decorators.RedShapeDecorator;
import paterns.structural.decorator.shapedecorator.shapes.Circle;
import paterns.structural.decorator.shapedecorator.shapes.Rectangle;
import paterns.structural.decorator.shapedecorator.shapes.Shape;

/**
 * Class DecoratorPattern demonstrates the work of decorator pattern, which
 * adds new functionality to an existing object without binding its structure.
 *
 * @author Kamila Meshcheryakova
 * created by 24.08.2020
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}

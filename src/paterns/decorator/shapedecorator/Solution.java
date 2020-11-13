package paterns.decorator.shapedecorator;


/* 
Decorator
*/

import paterns.decorator.shapedecorator.decorators.RedShapeDecorator;
import paterns.decorator.shapedecorator.shapes.Circle;
import paterns.decorator.shapedecorator.shapes.Rectangle;
import paterns.decorator.shapedecorator.shapes.Shape;

public class Solution {
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

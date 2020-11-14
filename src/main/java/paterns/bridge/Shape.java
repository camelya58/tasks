package paterns.bridge;

/**
 * Abstract class Shape consists of one method.
 *
 * @author Kamila Meshcheryakova
 * created 06.11.2020
 */
public abstract class Shape {

    // the field color is a bridge which connects 2 different hierarchies of the classes (Shape and Color)
    protected Color color;

    public Shape(Color color) {
        this.color = color;
        System.out.println("Create a " + this.getClass().getSimpleName());
        color.fillColor();
    }

    public abstract void draw();
}

class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}

class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}
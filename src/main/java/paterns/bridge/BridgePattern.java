package paterns.bridge;

/**
 * Class BridgePattern allows to replace inheritance with composition or aggregation.
 *
 * @author Kamila Meshcheryakova
 * created 06.11.2020
 */
public class BridgePattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        redCircle.draw();
        Shape blackCircle = new Circle(new BlackColor());
        blackCircle.draw();
        Shape greenCircle = new Circle(new GreenColor());
        greenCircle.draw();

        Shape redRectangle = new Rectangle(new RedColor());
        redRectangle.draw();
        Shape blackRectangle = new Rectangle(new BlackColor());
        blackRectangle.draw();
        Shape greenRectangle = new Rectangle(new GreenColor());
        greenRectangle.draw();

        Shape redTriangle = new Triangle (new RedColor());
        redTriangle.draw();
        Shape blackTriangle  = new Triangle (new BlackColor());
        blackTriangle.draw();
        Shape greenTriangle  = new Triangle (new GreenColor());
        greenTriangle.draw();

    }
}

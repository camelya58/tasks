package paterns.creational.builder;

import java.awt.*;

/**
 * Class BuilderPattern demonstrates the work of builder pattern, which
 * allows to create the object without setters with different quantity of its fields.
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Button button = new Button.Builder()
                .width(200)
                .height(100)
                .text("Button")
                .color(Color.RED)
                .build();

        System.out.println(button);
    }
}

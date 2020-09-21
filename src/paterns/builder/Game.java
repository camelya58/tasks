package paterns.builder;

import java.awt.*;

/**
 * Класс Game
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Game {
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

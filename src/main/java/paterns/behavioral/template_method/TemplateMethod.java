package paterns.behavioral.template_method;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TemplateMethod demonstrates the work of template method pattern, which
 * allows to define the algorithm of behavior and invoke it in common abstract class
 * as well as allows heirs to override the steps of the algorithm not touching the structure.
 *
 * @author Kamila Meshcheryakova
 * created by 22.11.2020
 */
public class TemplateMethod {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        games.add(new Football());
        games.add(new Basketball());
        games.add(new Tennis());

        for (Game game : games) {
            game.run();
            System.out.println("---------------------------------------------");
        }
    }
}

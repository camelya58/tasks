package paterns.template_method;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern Template method allows to define the algorithm of behavior and invoke it in common abstract class
 * as well as allows heirs to override the steps of the algorithm not touching the structure.
 */
public class Solution {
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

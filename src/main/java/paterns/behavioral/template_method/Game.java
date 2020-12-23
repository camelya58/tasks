package paterns.behavioral.template_method;

/**
 * Class Game
 *
 * @author Kamila Meshcheryakova
 * created by 03.11.2020
 */
abstract class Game {

    void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
    abstract void prepareForTheGame();
    abstract void playGame();
    abstract void congratulateWinner();
}

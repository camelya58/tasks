package paterns.observer;

/**
 * Класс Observed
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public interface Observed {

    void addObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObserver(String info);
    void addVideo(String video);
}

package paterns.behavioral.observer;

/**
 * Класс Subscriber
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class Subscriber implements MyObserver {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void event(String info) {
        System.out.println("Hi, " + name + ", watch new video: " + info);
    }
}

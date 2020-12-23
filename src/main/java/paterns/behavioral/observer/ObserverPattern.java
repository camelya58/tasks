package paterns.behavioral.observer;

/**
 * Class ObserverPattern demonstrates the realization of observer pattern,
 * which allows to observe something interesting and be notified about new event.
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class ObserverPattern {

    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        Subscriber vasya = new Subscriber("Vasya");
        Subscriber kolya = new Subscriber("Kolya");
        channel.addVideo("Gameplay Minecraft");
        channel.addObserver(vasya);
        channel.addVideo("Gameplay Witcher 3");
        channel.addObserver((kolya));
        channel.addVideo("Gameplay Mario");
        channel.removeObserver(vasya);
        channel.addVideo("Gameplay World of tanks");
    }
}

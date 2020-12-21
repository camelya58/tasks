package paterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс YouTubeChannel
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class YouTubeChannel implements Observed {

    private List<String> videos = new ArrayList<>();
    private List<MyObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String info) {
        observers.forEach(observer -> observer.event(info));
    }

    @Override
    public void addVideo(String video) {
        videos.add(video);
        notifyObserver(video);
    }


}

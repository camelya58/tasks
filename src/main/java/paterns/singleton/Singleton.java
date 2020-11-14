package paterns.singleton;

import lombok.SneakyThrows;

/**
 * Класс Singleton
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Singleton {

    public String value;

    private static Singleton instance;

    public synchronized static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }

    @SneakyThrows
    private Singleton(String value) {
        try {
            Thread.sleep(1000);
            this.value = value;
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "value='" + value + '\'' +
                '}';
    }
}

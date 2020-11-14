package paterns.singleton;

import lombok.SneakyThrows;

/**
 * Class Launcher demonstrates the singleton pattern in work.
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Launcher {
    public static void main(String[] args) {

        ThreadFoo foo = new ThreadFoo();
        Thread threadFoo = new Thread(foo);
        threadFoo.start();

        ThreadBar bar = new ThreadBar();
        Thread threadBar = new Thread(bar);
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            Singleton foo = Singleton.getInstance("Foo");
            System.out.println(foo.value);
        }
    }

    static class ThreadBar implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            Singleton bar = Singleton.getInstance("Bar");
            System.out.println(bar.value);
        }
    }
}

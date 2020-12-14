package multithreading.data_race;

/**
 * Class DataRace demonstrates the example of data race end the decision.
 *
 * @author Kamila Meshcheryakova
 * created 08.12.2020
 */
public class DataRace {

    volatile static int counter = 0;

    public static void increment() {
        counter++;
    }

//    public synchronized static void increment() {
//        counter++;
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            DataRace.increment();
        }
    }
}
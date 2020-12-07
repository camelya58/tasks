package multithreading.phaser;

import java.util.concurrent.Phaser;

/**
 * Class PhaserSample demonstrates the work of Phaser class.
 *
 * @author Kamila Meshcheryakova
 * created by 03.12.2020
 */
public class PhaserSample {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Запуск потоков");

        new MyThread(phsr, "A");
        new MyThread(phsr, "B");
        new MyThread(phsr, "C");

        // ожидать заверешния всеми потоками исполнения первой фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        // ожидать завершения всеми потоками исполнения второй фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена");

        // снять основной поток исполнения с регистрации
        phsr.arriveAndDeregister();

        if(phsr.isTerminated()) {
            System.out.println("Синхронизатор фаз завершен");
        }
    }
}


// Поток исполнения, использующий синхронизатор фаз типа Phaser
class MyThread implements Runnable {
    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    public void run() {

        System.out.println("Поток " + name + " начинает первую фазу");
        phsr.arriveAndAwaitAdvance(); // известить о достижении фазы

        // Небольшая пауза, чтобы не нарушить порядок вывода.
        // Только для иллюстрации, но необязательно для правильного
        // функционирования синхронизатора фаз

        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток " + name + " начинает вторую фазу");
        phsr.arriveAndAwaitAdvance(); // известить о достижении фазы

        // Небольшая пауза, чтобы не нарушить порядок вывода.
        // Только для иллюстрации, но необязательно для правильного
        // функционирования синхронизатора фаз

        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
           e.printStackTrace();
        }

        System.out.println("Поток " + name + " начинает третью фазу");

        // известить о достижении фазы и снять потоки с регистрации
        phsr.arriveAndDeregister();
    }

}

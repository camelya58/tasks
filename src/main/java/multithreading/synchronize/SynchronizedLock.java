package multithreading.synchronize;

/**
 * Класс SynchronizedLock
 *
 * @author Kamila Meshcheryakova
 * created 09.12.2020
 */
public class SynchronizedLock {

    static final Object lock = new Object();

    void mobileCall() {
        synchronized (this) {
//        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (this) {
//        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsUpCall() {
        synchronized (this) {
//        synchronized (lock) {
            System.out.println("WhatsUp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsUp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MobileRunnable());
        Thread thread2 = new Thread(new SkypeRunnable());
        Thread thread3 = new Thread(new WhatsUpRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class MobileRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedLock().mobileCall();
    }
}

class SkypeRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedLock().skypeCall();
    }
}

class WhatsUpRunnable implements Runnable {

    @Override
    public void run() {
        new SynchronizedLock().whatsUpCall();
    }
}


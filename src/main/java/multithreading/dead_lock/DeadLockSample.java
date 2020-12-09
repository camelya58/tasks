package multithreading.dead_lock;

/**
 * Класс DeadLockSample
 *
 * @author Kamila Meshcheryakova
 * created 27.11.2020
 */
public class DeadLockSample {

    public static void kill (Knight knight1, Knight knight2) {

        synchronized (knight1) {
            synchronized (knight2) {
                System.out.println("kill " + Thread.currentThread().getName());
                knight2.live = 0;
                knight1.experience += 100;
                System.out.println("knight1.experience = " + knight1.experience + ", knight1.live = " + knight1.live);
                System.out.println("knight2.experience = " + knight2.experience + ", knight2.live = " + knight2.live);
            }
        }
    }

    public static void main(String[] args) {
        Knight knight1 = new Knight();
        Knight knight2 = new Knight();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run " + Thread.currentThread().getName());
                kill(knight1, knight2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run " + Thread.currentThread().getName());
                kill(knight2, knight1);
            }
        }).start();

//        Knight knight3 = new Knight();
//        Knight knight4 = new Knight();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run " + Thread.currentThread().getName());
//                DeadLockDecision.kill(knight3, knight4);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run " + Thread.currentThread().getName());
//                DeadLockDecision.kill(knight4, knight3);
//            }
//        }).start();
    }
}

class Knight {

    static int id = 0;
    int live;
    int experience;

    public Knight() {
        id++;
        this.live = 100;
        this.experience = 0;
    }
}

class DeadLockDecision {

    public static void kill (Knight knight1, Knight knight2) {

        Knight knightMax = knight1.id > knight2.id ? knight1 : knight2;
        Knight knightMin = knight1.id > knight2.id ? knight2 : knight1;

        synchronized (knightMax) {
            synchronized (knightMin) {
                System.out.println("kill " + Thread.currentThread().getName());
                knight2.live = 0;
                knight1.experience += 100;
                System.out.println("knight1.experience = " + knight1.experience + ", knight1.live = " + knight1.live);
                System.out.println("knight2.experience = " + knight2.experience + ", knight2.live = " + knight2.live);
            }
        }
    }
}
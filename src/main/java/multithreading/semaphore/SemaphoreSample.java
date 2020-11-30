package multithreading.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Class SemaphoreSample demonstrates the work with semaphore.
 *
 * @author Kamila Meshcheryakova
 * created by 30.11.2020
 */
public class SemaphoreSample {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);
        Person person1 = new Person(table);
        Person person2 = new Person(table);
        Person person3 = new Person(table);
        Person person4 = new Person(table);
        Person person5 = new Person(table);
        Person person6 = new Person(table);
        Person person7 = new Person(table);
    }
}

class Person extends Thread {

    private Semaphore semaphore;

    public Person(Semaphore semaphore) {
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " is waiting for a table");
        try {
            semaphore.acquire();
            System.out.println(this.getName() + " is eating at the table");
            Thread.sleep(1000);
            System.out.println(this.getName() + "releases the table");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
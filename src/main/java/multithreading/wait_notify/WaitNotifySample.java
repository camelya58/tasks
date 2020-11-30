package multithreading.wait_notify;

/**
 * Class WaitNotifySample demonstrates the use of wait/notifyAll methods.
 *
 * @author Kamila Meshcheryakova
 * created by 30.11.2020
 */
public class WaitNotifySample {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
} /* Output:
Put: 1
Got: 1
Put: 2
Got: 2
Put: 3
Got: 3
...
*/

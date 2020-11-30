package multithreading.wait_notify;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false;


    // the method should wait for the presence of the value and than return it
    // before returning the value it must change the presence of the value to false and notify all waiting threads
    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notifyAll();
        return value;
    }

    // the method should wait for taking the value and refresh the meaning of the value
    // it must change the presence of the value to true and notify all waiting threads
    public synchronized void put(int value) {
        while(isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        notifyAll();
    }
}

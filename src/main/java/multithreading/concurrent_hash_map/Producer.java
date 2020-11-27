package multithreading.concurrent_hash_map;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.valueOf(++i), "Some text for " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.printf( "[%s] thread was terminated\n", Thread.currentThread().getName());
        }
    }
}
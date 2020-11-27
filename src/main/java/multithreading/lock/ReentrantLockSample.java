package multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class ReentrantLockSample demonstrates the use of ReentrantLock.
 *
 * @author Kamila Meshcheryakova
 * created by 25.11.2020
 */
@SuppressWarnings("unused")
public class ReentrantLockSample {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        boolean check = lock.tryLock();
        try {
            if (check) {
                actionIfLockIsFree();
            } else {
                actionIfLockIsBusy();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (check) {
                lock.unlock();
            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}

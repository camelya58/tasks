package multithreading.dead_lock;

import java.util.concurrent.locks.Lock;

/**
 * Класс DecisionOfDeadLock
 *
 * @author Kamila Meshcheryakova
 * created 27.11.2020
 */
public class DecisionOfDeadLock {

    public void twoLocks(Lock A, Lock B) {
        while(true) {
            if (A.tryLock()) {
                if (B.tryLock()) {
                    try {
                        // do something
                    } finally {
                        B.unlock();
                        A.unlock();
                    }
                } else {
                    A.unlock();
                }
            }
        }
    }
}

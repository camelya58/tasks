package multithreading.fork_join_pool.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * Class BinaryRepresentationTask
 *
 * @author Kamila Meshcheryakova
 * created by 14.12.2020
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {

        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);

        if (b > 0) {
            BinaryRepresentationTask subtask  = new BinaryRepresentationTask(b);
            // method fork() allows to divide the task to simple task
            subtask.fork();
            // method join() allows to join the result of subtasks to common result
            return subtask.join() + result;
        }
        return result;
    }
}

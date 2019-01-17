package example3;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make each thread add its id numeric value to a global variable
 * contained in this class. The last thread is the one in charge to
 * print the final value.
 * Ensure a deterministic result with any synchronization tool.
 */
public class Example3Master {

    /**
     * Number of threads to use.
     */
    public static final int N = 10;

    public static int totalSum = 0;
    public static Semaphore semaphorePrint;

    public static void main(String[] args) {

        // Semaphores
        semaphorePrint = new Semaphore(0);

        // Threads
        Example3Worker[] threads = new Example3Worker[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Example3Worker(i + 1);
            threads[i].start();
        }
    }
}

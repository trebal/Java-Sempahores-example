package Problem2.SectionC;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make each thread add its id value to a global variable
 * contained in this class. The last thread is the one in charge to
 * print the final value.
 * Ensure a deterministic result with any synchronization tool.
 */
public class Problem2C {

    public static final int N = 10;
    public static int totalSum = 0;
    public static Semaphore semaphorePrint;

    public static void main(String[] args) {

        // Semaphores
        semaphorePrint = new Semaphore(0);

        // Threads
        ThreadWorker2C[] threads = new ThreadWorker2C[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new ThreadWorker2C(i + 1);
            threads[i].start();
        }
    }
}

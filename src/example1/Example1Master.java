package example1;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make the thread 1 print its id, then the thread 2. The rest
 * of the threads have to print their id after the 2 has finished.
 * The order of the rest does not matters.
 * Use only semaphores as synchronization tool.
 */
public class Example1Master {

    /**
     * Number of threads to use.
     */
    private static final int N = 10;

    public static Semaphore semaphoreThread2;
    public static Semaphore[] semaphoresRest;

    public static void main(String[] args) {

        // Semaphores
        semaphoreThread2 = new Semaphore(0);
        semaphoresRest = new Semaphore[N - 2];
        for (int i = 0; i < N - 2; i++) {
            semaphoresRest[i] = new Semaphore(0);
        }

        // Threads
        Example2Worker[] threads = new Example2Worker[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Example2Worker(i + 1);
            threads[i].start();
        }
    }
}

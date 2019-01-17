package example2;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make each thread print its id, in ascending order, using
 * only semaphores as synchronization tool.
 */
public class Example2Master {

    /**
     * Number of threads to use.
     */
    public static final int N = 10;
    public static Semaphore[] semaphores;

    public static void main(String[] args) {

        // Semaphores
        semaphores = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            semaphores[i] = new Semaphore(0);
        }
        semaphores[0].release(1);

        // Threads
        Example2Worker[] threads = new Example2Worker[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new Example2Worker(i + 1);
            threads[i].start();
        }
    }
}

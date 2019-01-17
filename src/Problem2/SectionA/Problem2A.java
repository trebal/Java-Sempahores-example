package Problem2.SectionA;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make each thread print its id, in ascending order, using
 * only semaphores as synchronization tool.
 */
public class Problem2A {

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
        ThreadWorker2A[] threads = new ThreadWorker2A[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new ThreadWorker2A(i + 1);
            threads[i].start();
        }
    }
}

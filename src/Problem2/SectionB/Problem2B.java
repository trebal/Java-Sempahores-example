package Problem2.SectionB;

import java.util.concurrent.Semaphore;

/**
 * @author Ramon de Llano Chamorro
 *
 * Statement: make the thread 1 print its id, then the thread 2. The rest
 * of the threads have to print their id after the 2 has finished.
 * Use only semaphores as synchronization tool.
 */
public class Problem2B {

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
        ThreadWorker2B[] threads = new ThreadWorker2B[N];
        for (int i = 0; i < N; i++) {
            threads[i] = new ThreadWorker2B(i + 1);
            threads[i].start();
        }
    }
}

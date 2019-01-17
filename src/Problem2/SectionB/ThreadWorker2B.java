package Problem2.SectionB;

import java.util.concurrent.Semaphore;

public class ThreadWorker2B extends Thread {

    private final int id;

    ThreadWorker2B(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        switch (id) {
            case 1:
                Thread1();
                break;
            case 2:
                try {
                    Thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    ThreadRest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private void Thread1() {

        System.out.println("Thread id: " + id);

        Problem2B.semaphoreThread2.release(1);
    }

    private void Thread2() throws InterruptedException {

        Problem2B.semaphoreThread2.acquire(1);

        System.out.println("Thread id: " + id);

        for(Semaphore sem : Problem2B.semaphoresRest)
        {
            sem.release(1);
        }
    }

    private void ThreadRest() throws InterruptedException {

        Problem2B.semaphoresRest[id - 3].acquire(1);

        System.out.println("Thread id: " + id);
    }
}

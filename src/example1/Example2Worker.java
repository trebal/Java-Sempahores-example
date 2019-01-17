package example1;

import java.util.concurrent.Semaphore;

public class Example2Worker extends Thread {

    private final int id;

    Example2Worker(int id) {
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

        Example1Master.semaphoreThread2.release(1);
    }

    private void Thread2() throws InterruptedException {

        Example1Master.semaphoreThread2.acquire(1);

        System.out.println("Thread id: " + id);

        for(Semaphore sem : Example1Master.semaphoresRest)
        {
            sem.release(1);
        }
    }

    private void ThreadRest() throws InterruptedException {

        Example1Master.semaphoresRest[id - 3].acquire(1);

        System.out.println("Thread id: " + id);
    }
}

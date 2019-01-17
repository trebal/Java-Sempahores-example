package Problem2.SectionA;

public class ThreadWorker2A extends Thread {

    private final int id;

    ThreadWorker2A(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void work() throws InterruptedException {

        Problem2A.semaphores[id - 1].acquire(1);

        System.out.println("Thread id: " + id);

        if (id < Problem2A.N) {
            Problem2A.semaphores[id].release(1);
        }
    }
}

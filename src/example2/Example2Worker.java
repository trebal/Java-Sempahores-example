package example2;

public class Example2Worker extends Thread {

    private final int id;

    Example2Worker(int id) {
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

        Example2Master.semaphores[id - 1].acquire(1);

        System.out.println("Thread id: " + id);

        if (id < Example2Master.N) {
            Example2Master.semaphores[id].release(1);
        }
    }
}

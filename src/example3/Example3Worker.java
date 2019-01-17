package example3;

public class Example3Worker extends Thread {

    private final int id;

    Example3Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (id == Example3Master.N) {
            try {
                ThreadN();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ThreadRest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ThreadRest() throws InterruptedException {

        System.out.println("Thread id: " + id);

        synchronized (Example3Master.class) {
            Example3Master.totalSum += id;
        }

        Example3Master.semaphorePrint.release(1);
    }

    private void ThreadN() throws InterruptedException {

        System.out.println("Thread id: " + id);

        Example3Master.semaphorePrint.acquire(Example3Master.N - 1);

        Example3Master.totalSum+=id;

        /* Print total sum */
        System.out.println("Total sum: " + Example3Master.totalSum);
    }
}

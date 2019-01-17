package Problem2.SectionC;

public class ThreadWorker2C extends Thread {

    private final int id;

    ThreadWorker2C(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (id == Problem2C.N) {
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

        synchronized (Problem2C.class) {
            Problem2C.totalSum += id;
        }

        Problem2C.semaphorePrint.release(1);
    }

    private void ThreadN() throws InterruptedException {

        System.out.println("Thread id: " + id);

        Problem2C.semaphorePrint.acquire(Problem2C.N - 1);

        Problem2C.totalSum+=id;

        /* Print total sum */
        System.out.println("Total sum: " + Problem2C.totalSum);
    }
}

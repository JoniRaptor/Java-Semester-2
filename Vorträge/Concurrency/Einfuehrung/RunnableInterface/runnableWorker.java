package RunnableInterface;

public class runnableWorker implements Runnable {

    private int sharedInt;

    public runnableWorker(int sharedInt) {
        this.sharedInt = sharedInt;
    }

    public void run() {

        System.out.println("Thread " + Thread.currentThread().getId() + " läuft, mein Value ist: " + sharedInt);

        if (this.sharedInt > 10) {

            this.sharedInt = 10;
            System.out.println("Mein Wert war über 10.");
        }
    }
}
package ThreadClass;

public class worker extends Thread {

    private int value;

    public worker(int value) {
        this.value = value;
    }

    public void run() {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " läuft, mein Value ist: " + value);
    }
}

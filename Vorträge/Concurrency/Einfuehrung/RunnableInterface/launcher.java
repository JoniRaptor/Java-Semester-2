package RunnableInterface;

public class launcher {
    public static void main(String[] args) {

        runnableWorker gruppe1 = new runnableWorker(4);
        runnableWorker gruppe2 = new runnableWorker(999);

        // erste Gruppe
        Thread gruppe1Thread1 = new Thread(gruppe1);
        gruppe1Thread1.start();

        Thread gruppe1Thread2 = new Thread(gruppe1);
        gruppe1Thread2.start();

        // zweite Gruppe
        Thread gruppe2Thread1 = new Thread(gruppe2);
        gruppe2Thread1.start();

        Thread gruppe2Thread2 = new Thread(gruppe2);
        gruppe2Thread2.start();
    }
}
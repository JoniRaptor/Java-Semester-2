public class Launcher {
    public static void main(String[] args) {
        DeadlockThread deadlockThread = new DeadlockThread();

        // Thread fängt an, auf System.out zu schreiben — aka. System.out wird gesperrt
        deadlockThread.start();

        // DIESER (Haupt-)Thread schläft 200ms (damit der deadlockThread Zeit hat,
        // anzufangen...)
        try {
            Thread.sleep(200);
        } catch (Exception ex) {
            // nichts
        }

        // deadlockThread wird pausiert
        deadlockThread.suspend();

        // Main Thread läuft (erstmal) noch weiter...
        int i = 5 * 5;

        // Main Thread will auf System.out schreiben (kann aber nicht, also hängt)
        System.out.println(i);

        // deadlockThread soll fortgesetzt werden - wird er aber nie
        deadlockThread.resume();

    }
}

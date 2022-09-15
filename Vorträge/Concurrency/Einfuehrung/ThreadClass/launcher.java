package ThreadClass;

public class launcher {
    public static void main(String[] args) {

        // Anzahl der CPU Cores
        int threads = Runtime.getRuntime().availableProcessors();
        System.out.println("System-Threads: " + threads);

        // Instanzen sind nur im for-loop-Scope gültig
        // → nach loop für garbage collection markiert
        for (int i = 0; i < threads; i++) {

            // Beispiel-Value ist hier einfach der iterator
            worker workerInstanz = new worker(i);

            // run() == kein Multithreading!!
            workerInstanz.start();
            // workerInstanz.interrupt();
        }
    }
}
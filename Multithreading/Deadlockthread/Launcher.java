class Launcher {

    public static void main(String[] args) {

        //ThreadWindow win1 = new ThreadWindow("Deadlock Thread 1");
        //ThreadWindow win2 = new ThreadWindow("Deadlock Thread 2");

        DeadlockThread thread1 = new DeadlockThread();
        DeadlockThread thread2 = new DeadlockThread();
        thread1.start();
        thread2.start();
    }
}
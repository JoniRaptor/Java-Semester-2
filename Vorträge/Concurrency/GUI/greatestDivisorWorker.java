public class greatestDivisorWorker extends Thread {

    private int number;
    public int greatestDivisor;

    public greatestDivisorWorker(int number) {
        this.number = number;
    }

    public void run() {

        System.out.println(String.format("Thread %d: gestartet für %d", Thread.currentThread().getId(), number));

        if (number == 0) {
            throw new ArithmeticException("Das ergibt keinen Sinn.");
        }

        if (number != 1) {
            for (int i = number - 1; i > 0; i--) {
                if (number % i == 0) {
                    greatestDivisor = i;
                    break;
                }
            }
        } else {
            greatestDivisor = 1;
        }

        System.out.println(String.format("Thread %d: gr. Teiler von %d ist %d",
                Thread.currentThread().getId(), number, greatestDivisor));
    }
}
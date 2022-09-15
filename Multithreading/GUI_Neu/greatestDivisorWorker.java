public class greatestDivisorWorker extends Thread {
    
    private int number;
    private int greatestDivisor;

    public greatestDivisorWorker(int number) {
        this.number = number;
    }

    public void run() {
        
        System.out.println("Thread " + Thread.currentThread().getId() + " gestartet für " + number);
        
        for (int i = number-1; i > 0 ; i--) {
            if (number % i == 0) {
                greatestDivisor = i;
                break;
            }
        }

        System.out.println(String.format("Thread %d: gr. Teiler von %d ist %d", Thread.currentThread().getId(), number,
                greatestDivisor));
        //System.out.println("Thread " + Thread.currentThread().getId() + ": gr. Teiler von " + number + " ist " + greatestDivisor);

    } 
}
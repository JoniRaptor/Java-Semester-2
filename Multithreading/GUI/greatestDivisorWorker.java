import java.util.ArrayList;

public class greatestDivisorWorker extends Thread {
    
    private int number;
    public int greatestDivisor;
    public String ThreadID;

    public greatestDivisorWorker(int number, ArrayList<String> Output) {
        this.number = number;
        GlobalArray.Output = Output;
        GlobalArray.OutputArray = GlobalArray.getOutpuArray(Output);
    }

    public void run() {
        
        System.out.println("Thread " + Thread.currentThread().getId() + " gestartet für " + number);
        ThreadID = Long.toString(Thread.currentThread().getId());
        for (int i = number-1; i > 0 ; i--) {
            if (number % i == 0) {
                greatestDivisor = i;
                break;
            }
        }

        System.out.println("Thread " + Thread.currentThread().getId() + ": gr. Teiler von " + number + " ist " + greatestDivisor);

        GlobalArray.Output.add("Thread " + Thread.currentThread().getId() + ": gr. Teiler von " + number + " ist " + greatestDivisor);
        System.out.println(GlobalArray.Output);

    }
}
class DeadlockThread extends Thread {

    protected static boolean hasDataToProcess = false;
    protected boolean personalData = false;
    private String Data1 = "test1";
    private String Data2 = "test2";

    public synchronized boolean hasDataToProcess() {
        return this.personalData;
    }

    public synchronized void setHasDataToProcess(boolean hasData) {
        hasDataToProcess = hasData;
    }

public void run(){

    if (!hasDataToProcess){
        this.setHasDataToProcess(true);
        this.personalData = true;
        System.out.println(Thread.currentThread().getId() + " in bearbeitung");
    }

    if(personalData){
        synchronized (Data1){
            System.out.println(Thread.currentThread().getId() + " hat " + Data1);
            try { Thread.sleep(100);} catch (Exception e) {}
            synchronized (Data2){
                System.out.println(Thread.currentThread().getId() + " hat " + Data2);
            }
        }
    }
    if(!personalData){
        synchronized (Data2){
            System.out.println(Thread.currentThread().getId() + " hat " + Data2);
            try { Thread.sleep(100);} catch (Exception e) {}
            synchronized (Data1){
                System.out.println(Thread.currentThread().getId() + " hat " + Data1);
            }
        }
    }

}
}
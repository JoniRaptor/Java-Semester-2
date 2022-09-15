public class Sortieralgorythmus extends Thread {

    private int arrlength;
    public int[] arrx = new int[arrlength];
    private String konst;

    public Sortieralgorythmus(int[] arr, String s) {
        this.arrlength = arr.length;
        this.arrx = arr;
        this.konst = s;
    }

    public void run() {
        long start2 = System.nanoTime();
        int k;
        for (int i = arrx.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arrx[j] >= arrx[i]) {
                    k = arrx[i];
                    arrx[i] = arrx[j];
                    arrx[j] = k;
                }
            }
            /*System.out.println(i + " InListe");
            for (int x = 0; x < arrx.length; x++){
                System.out.println(x + ": " + arrx[x]);
            }*/
            }
        long end2 = System.nanoTime();
        System.out.println("beende Zeitmessung");
        System.out.println("Zeit für Multithread: " + (end2 - start2));
        System.out.println("InListe " + konst);
        for (int x = 0; x < arrx.length; x++){
            System.out.println(konst + " " +x + ": " + arrx[x]);
        }
    }
}

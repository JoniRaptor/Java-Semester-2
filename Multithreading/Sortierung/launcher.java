public class launcher {
    public static void main(String[] args) {

        int[] arr1 = new int[100];
        int[] arr2 = new int[arr1.length / 2];
        int[] arr3 = new int[arr1.length / 2];

        // Erstellen des Arrays
        for (int i = 0; i < arr1.length; i++) {
            int y = (int) Math.round(Math.random() * 50 + 1);
            arr1[i] = y;
        }
        //int[] arr = sort(arr1);
        /*for (int i = 0; i < arr1.length; i++) {
            System.out.println(i + ": " + arr1[i]);
        }*/
        System.out.println("starte Zeitmessung");
        long start1 = System.nanoTime();
        int[] arr = sort(arr1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(i + ": " + arr[i]);
        }
        long end1 = System.nanoTime();
        System.out.println("beende Zeitmessung");
        System.out.println("Zeit für SimpleSort: " + (end1 - start1));
        System.out.println("starte Zeitmessung");
        for (int i = 0; i <= arr1.length / 2 - 1; i++) {
            arr2[i] = arr1[i];
        }
        for (int i = 0; i <= arr1.length / 2 - 1; i++) {
            arr3[i] = arr1[arr1.length / 2 + i];
        }

        //long start2 = System.nanoTime();
        /*System.out.println("Liste1 before");
        for (int i = 0; i < arr2.length; i++){
            System.out.println(i + ": " + arr2[i]);
        }
        System.out.println("Liste2 before");
        for (int i = 0; i < arr3.length; i++){
            System.out.println(i + ": " + arr3[i]);
        }*/
        Sortieralgorythmus thread1 = new Sortieralgorythmus(arr2, "L1");
        Sortieralgorythmus thread2 = new Sortieralgorythmus(arr3, "L2");
        thread1.start();
        thread2.start();
        //while (thread1.isAlive()) {};
        /*System.out.println("Liste1");
        for (int i = 0; i < thread1.arrx.length; i++){
            System.out.println(i + ": " + thread1.arrx[i]);
        }*/
        //while (thread2.isAlive()) {};
        /*System.out.println("Liste2");
        for (int i = 0; i < thread2.arrx.length; i++){
            System.out.println(i + ": " + thread2.arrx[i]);
        }*/
        /*for (int i = 0; i < thread1.arrx.length; i++) {
            thread1.arrx[i] = arr1[i];
        }
        for (int i = 0; i < thread2.arrx.length; i++) {
            thread2.arrx[i] = arr1[thread1.arrx.length + i];
        }
        System.out.println("finale Liste");
        int[] arr = sort(arr1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }*/
        /*long end2 = System.nanoTime();
        System.out.println("beende Zeitmessung");
        System.out.println("Zeit düe Multithread: " + (end2 - start2));*/
    }

    public static int[] sort(int[] intArr) {
        int k;
        for (int i = intArr.length - 1; i > 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (intArr[j] >= intArr[i]) {
                    k = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = k;
                }
            }
        }
        return intArr;
    }
}

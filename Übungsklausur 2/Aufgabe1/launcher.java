package Aufgabe1;

public class launcher {
    public static void main(String[] args) {
        int[] arr = {3,60,35,2,45,320,5};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);

        //Print sorted array
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}

package Aufgabe1;

public class BubbleSort {
    
    public int[] bubbleSort(int[] arr){
        int n = arr.length;
        int temp = 0; //temp variable for swapping

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){

                if(arr[j-1] > arr[j]){
                    //swap variables
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        return arr;

    }
}

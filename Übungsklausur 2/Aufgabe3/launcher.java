package Aufgabe3;

public class launcher {

    static void print(Kontakt[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }
    }

    static int search(Kontakt[] array, String name){
        int in = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i].getname().contains(name)){
                in = i;
            }
        }
        return in;
    }
    
    public static void main(String[] args) {
        Kontakt[] array = new Kontakt[5];
        array[0] = new Kontakt("Max Mustermann", "Musterstrasse", "Musterstadt");
        array[1] = new Kontakt("Moritz Mustermann", "Musterstrasse", "Musterstadt");
        array[2] = new Kontakt("Max Heber", "Musterstrasse", "Leiptzig");
        array[3] = new Kontakt("Friedrich Ebert", "Bismarckweg", "Wurzen");
        array[4] = new Kontakt("Gustav Stresemann", "Weimarerweg", "Weimar");

        print(array);
        System.out.println(search(array, "Ebert"));
    }
}

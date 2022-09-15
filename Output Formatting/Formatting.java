import java.io.*;

public class Formatting {
    public static void main(String[] args) {
        
        String[] [] Pers = {{"Max", "Mustermann"}, 
                            {"Moritz", "Mustermann"}};
        
        System.out.printf("%s", Pers[0][0]);
        System.out.printf("%S", Pers[0][1]);
        System.out.printf("%s %n", "");


        System.out.printf("%s", Pers[0][0]);
        System.out.printf("%2s", "");
        System.out.printf("%S", Pers[0][1]);
        System.out.printf("%2s %n", "");

        for(int i = 1; i <= 15; i++){
            System.out.printf("%s", String.valueOf(i));
            System.out.printf("%1s", "");
            System.out.printf("%S %n", Integer.toHexString(i)); 
        }

        printName(Pers[0][0], Pers[0][1], "Musterstadt", 1503.45098);
        printName(Pers[1][0], Pers[1][1], "Musterstadt", 50.6);

    }

public static void printName(String Vorname, String Nachname, String Stadt, double Alter){
    System.out.printf("%-5s ", Vorname);
    System.out.printf("%1s", "");
    System.out.printf("%-5s", Vorname);
    System.out.printf("%1s", "");
    System.out.printf("%5.3s", Stadt);
    System.out.printf("%1s %n", "");

    double nachkomma = Alter - (int)Alter;
    String vorkomma = String.valueOf((int) Alter);
    int Nullcount = 0;
    if(vorkomma.length() < 3){
        Nullcount = 3 - vorkomma.length();
    } else if (vorkomma.length() > 3){
        String newAltervorkomma = "";
        for (int i = 0; i < 3; i++){
            newAltervorkomma = vorkomma.charAt(vorkomma.length() - 1 - i) + newAltervorkomma;
        }
        vorkomma = newAltervorkomma;
    }

    double newAlter = Integer.valueOf(vorkomma) + nachkomma;

    if (Nullcount > 0){
        for(int i = 0; i < Nullcount; i++){
            System.out.printf("%s", "0");
        }
    }

    System.out.printf("%.2f %n", newAlter);
}

}

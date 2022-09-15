package Aufgabe4;

import java.io.*;

public class launcher {
    public static void main(String[] args) throws Exception{
        Person P1 = new Person("Jonas", "Pohl", "Lüptiz");
        Person P2 = new Person("Max", "Mustermann", "Musterstadt");
        System.out.println(P1.getvorname() + " " + P1.getnachname() + " " + P1.getwohnort());
        System.out.println(P2.getvorname() + " " + P2.getnachname() + " " + P2.getwohnort());

        FileOutputStream fs = new FileOutputStream("/Personen.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(P1);
        os.writeObject(P2);
        os.close();

        FileInputStream fi = new FileInputStream("/Personen.ser");
        ObjectInputStream oi = new ObjectInputStream(fi);
        Person P3 = (Person) oi.readObject();
        Person P4 = (Person) oi.readObject();
        oi.close();
        System.out.println(P3.getvorname() + " " + P3.getnachname() + " " + P3.getwohnort());
        System.out.println(P4.getvorname() + " " + P4.getnachname() + " " + P4.getwohnort());
    }
}

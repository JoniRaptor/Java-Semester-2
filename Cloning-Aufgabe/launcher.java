public class launcher{
    public static void main(String[] args) {
        Kunde kunde = new Kunde("Hugo Meier", "Hauptsr. 12, 40880 Ratingen");
        Konto konto = new Konto(4711, 10000.0);
        konto.kunde = kunde;
        Konto kontoclone = konto.clone();
        konto.kunde.setadresse("Hauptsr. 42, 40880 Ratingen");

        System.out.println(konto.getid() + ", " + konto.getsaldo() + ", " + konto.kunde.getname() + ", " + konto.kunde.getadresse());
        System.out.println(kontoclone.getid() + ", " + kontoclone.getsaldo() + ", " + kontoclone.kunde.getname() + ", " + kontoclone.kunde.getadresse());
    }
}
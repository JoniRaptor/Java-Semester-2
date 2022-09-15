public class Konto implements Cloneable{
    private int id;
    private double saldo;
    public Kunde kunde;

    public Konto(){
    }

    public Konto(int id, double saldo){
        this.id = id;
        this.saldo = saldo;
    }

    public int getid(){
        return this.id;
    }

    public double getsaldo(){
        return this.saldo;
    }

    public void add(double betrag){
        this.saldo = this.saldo + betrag;
    }

    public boolean equals(Object obj){
        if(obj instanceof Konto){
            return obj.getid() == this.id;
        } else {
            return false;
        }
    }

    public int hashcode(){
        return this.id % 100;
    }

    public Konto clone(){
        Konto kont = new Konto();
        kont.id = this.getid();
        kont.saldo = this.getsaldo();
        kont.kunde = new Kunde();
        kont.kunde.setname(this.kunde.getname());
        kont.kunde.setadresse(this.kunde.getadresse());
        return kont;
    }
}

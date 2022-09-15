public class Kunde{
    private String name;
    private String adresse;

    public Kunde(){
    }

    public Kunde(String name, String adresse){
        this.name = name;
        this.adresse = adresse;
    }

    public Kunde(Kunde kunde){
        this.name = kunde.getname();
        this.adresse = kunde.getadresse();
    }

    public String getname(){
        return this.name;
    }

    public void setname(String name){
        this.name = name;
    }

    public String getadresse(){
        return this.adresse;
    }

    public void setadresse(String adresse){
        this.adresse = adresse;
    }
}
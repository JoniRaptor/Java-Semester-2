package Aufgabe3;

public class Kontakt {
    
    private String name;
    private String strasse;
    private String ort;

    private int Laufkriterium = 3;

    public Kontakt(String name, String strasse, String ort){
        this.name = name;
        this.strasse = strasse;
        this.ort = ort;
    }

    public String getname(){
        return this.name;
    }

    public String getstrasse(){
        return this.strasse;
    }

    public String getort(){
        return this.ort;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "; Straße: " + this.strasse + "; Ort: " + this.ort; 
    }
}

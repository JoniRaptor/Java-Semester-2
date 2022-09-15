package Aufgabe4;

import java.io.Serializable;

public class Person implements Serializable{
    private String vorname;
    private String nachname;
    private String wohnort;
    private static final long serialVersionUID = 123456L; //Person.serialVersionUID

    public void setvorname(String vorname){
        this.vorname = vorname;
    }

    public void setnachname(String nachname){
        this.nachname = nachname;
    }

    public void setwohnort(String wohnort){
        this.wohnort = wohnort;
    }

    public String getvorname(){
        return this.vorname;
    }

    public String getnachname(){
        return this.nachname;
    }

    public String getwohnort(){
        return this.wohnort;
    }

    public Person(String vorname, String nachname, String wohnort){
        this.vorname = vorname;
        this.nachname = nachname;
        this.wohnort = wohnort;
    }
}

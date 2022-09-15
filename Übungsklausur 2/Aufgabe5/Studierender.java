package Aufgabe5;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Studierender {

    private String name;
    private String Jahrgang;
    private String nummer;

    @XmlElement(name = "nachname")
    public void setname(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public void setJahrgang(String Jahrgang){
        this.Jahrgang = Jahrgang;
    }

    public String getJahrgang(){
        return Jahrgang;
    }

    public void setnummer(String nummer){
        this.nummer = nummer;
    }

    public String getnummer(){
        return nummer;
    }
}

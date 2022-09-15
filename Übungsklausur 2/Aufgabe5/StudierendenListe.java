package Aufgabe5;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "studListe")
public class StudierendenListe {
    
    private List<Studierender> studListe;
    private String seminargruppe, studiengang;

    @XmlElement(name = "student")
    public void setstudListe(List<Studierender> studListe){
        this.studListe = studListe;
    }

    public List<Studierender> getstudListe(){
        return studListe;
    }

    public void setseminargruppe(String seminargruppe){
        this.seminargruppe = seminargruppe;
    }

    public String getseminargruppe(){
        return seminargruppe;
    }

    public void setstudiengang(String studiengang){
        this.studiengang = studiengang;
    }

    public String getstudiengang(){
        return studiengang;
    }
}

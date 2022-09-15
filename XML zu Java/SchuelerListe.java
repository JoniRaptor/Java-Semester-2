import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SchuelerListe {
    private List<NewSchueler> Liste;
    private String Seminargruppe;
    @XmlElement(name = "Schueler")
    public List<NewSchueler> getSchuelerList() {
        return Liste;
    }
    public void setSchuelerList(List<NewSchueler> Liste) {
        this.Liste = Liste;
    }

    public String getSeminargruppe() {
        return Seminargruppe;
    }
    public void setSeminargruppe(String Seminargruppe) {
        this.Seminargruppe = Seminargruppe;
    }
}

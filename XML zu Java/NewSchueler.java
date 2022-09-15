import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "schueler")
public class NewSchueler {

    private String name;
    private String jahrgang;
    private int nummer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(String jahrgang) {
        this.jahrgang = jahrgang;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}


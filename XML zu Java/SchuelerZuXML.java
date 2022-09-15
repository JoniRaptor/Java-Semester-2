import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.*;

public class SchuelerZuXML {

    public static void main(String[] args) {

        NewSchueler s1 = new NewSchueler();
        s1.setName("Wolfgang");
        s1.setJahrgang("1986");
        s1.setNummer(11313);

        NewSchueler s2 = new NewSchueler();
        s2.setName("Dieter");
        s2.setJahrgang("1922");
        s2.setNummer(12342);

        NewSchueler s3 = new NewSchueler();
        s3.setName("Herbert");
        s3.setJahrgang("2002");
        s3.setNummer(34543);

        ArrayList<NewSchueler> L = new ArrayList<NewSchueler>();
        L.add(s1);
        L.add(s2);
        L.add(s3);

        SchuelerListe L1 = new SchuelerListe();
        L1.setSchuelerList(L);

        converttoxml(L1);
        /*converttoxml(s1);
        converttoxml(s2);
        converttoxml(s3);*/

    }

    private static void converttoxml(SchuelerListe s) {

        JAXBContext jaxbContext = null;
        
        try {
            jaxbContext = JAXBContext.newInstance(SchuelerListe.class);
            Marshaller jaxMarshaller = jaxbContext.createMarshaller();
            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File schuelerdatei = new File("SchuelerListe.xml");
            jaxMarshaller.marshal(s, schuelerdatei);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    private static void converttoxml(NewSchueler s) {

        JAXBContext jaxbContext = null;
        
        try {
            jaxbContext = JAXBContext.newInstance(NewSchueler.class);
            Marshaller jaxMarshaller = jaxbContext.createMarshaller();
            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File schuelerdatei = new File("newschueler.xml");
            jaxMarshaller.marshal(s, schuelerdatei);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}

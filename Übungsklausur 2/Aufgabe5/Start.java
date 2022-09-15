package Aufgabe5;

import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Start {
    public static void main(String[] args) {
        
        ArrayList<Studierender> sList = new ArrayList<Studierender>();

        Studierender S1 = new Studierender();
        S1.setname("Max");
        S1.setJahrgang("2020");
        S1.setnummer("123");

        Studierender S2 = new Studierender();
        S2.setname("Moritz");
        S2.setJahrgang("2020");
        S2.setnummer("321");

        Studierender S3 = new Studierender();
        S3.setname("Jonas");
        S3.setJahrgang("2021");
        S3.setnummer("456");

        sList.add(S1);
        sList.add(S2);
        sList.add(S3);

        StudierendenListe studListe = new StudierendenListe();
        studListe.setstudListe(sList);

        converttoxml(studListe);
    }

    private static void converttoxml(StudierendenListe studListe){
        JAXBContext jaxbContext = null;

        try{
            jaxbContext = JAXBContext.newInstance(StudierendenListe.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File datei = new File("Aufgabe5/studierendenliste.xml");
            jaxbMarshaller.marshal(studListe, datei);

        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}

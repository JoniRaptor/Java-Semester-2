import org.w3c.dom.Document;

public class Tester {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();

        String filePath = "src/Bestellung_3.xml";
        String filePath1 = "src/Bestellung.xml";
        String filePathError = "src/Bestellung_2.xml";
        String schemPath = "src/Bestellung.xsd";
        Document xmlDoc = parser.ReadXML(filePath);

        parser.searchForTagName(xmlDoc,"Lieferadresse");
        parser.searchForTagName(xmlDoc,"Rechnungsadresse");


        parser.WriteXML(filePath);


        boolean v1 = parser.ValidateXMl(schemPath, filePath);
        boolean v2 = parser.ValidateXMl(schemPath, filePathError);
        boolean v3 = parser.ValidateXMl(schemPath, filePath1);

        System.out.println("Bestellung 3 ist Valide zur XSD: " + v1 );
         System.out.println("Bestellung 2 ist Valide zur XSD: " + v2);
       System.out.println("Bestellung ist Valide zur XSD: " + v3);

    }


}

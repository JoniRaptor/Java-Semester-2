import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.sql.Time;

public class XMLParser {

    public static Document ReadXML(String filepath) {
        Document doc = null;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File("src/Bestellung.xml"));
            doc.getDocumentElement().normalize();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return doc;
    }

    public static void searchForTagName(Document xmlDocument, String tagName) {

        try {
            NodeList nodeList = xmlDocument.getElementsByTagName(tagName);
            System.out.println("Root Element: " + xmlDocument.getDocumentElement().getNodeName());
            System.out.println("------");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node node = nodeList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;


                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    String Straße = element.getElementsByTagName("Straße").item(0).getTextContent();
                    String ort = element.getElementsByTagName("Ort").item(0).getTextContent();
                    String PLZ = element.getElementsByTagName("PLZ").item(0).getTextContent();

                    System.out.println("Current Element: " + node.getNodeName());
                    System.out.println("Name: " + name);
                    System.out.println("Straße: " + Straße);
                    System.out.println("Ort: " + ort);
                    System.out.println("PLZ: " + PLZ);
                    System.out.println("------");


                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static boolean WriteXML(String filepath) {
        {
            boolean ret = false;
            Document dom;

            // instance of a DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {
                // use factory to get an instance of document builder
                DocumentBuilder db = dbf.newDocumentBuilder();
                // create instance of DOM
                dom = db.newDocument();

                // create the root element
                Element rootEle = dom.createElement("Bestellung");
                rootEle.setAttribute("bestelldatum", "2022-26-07");
                dom.appendChild(rootEle);

                // create data elements and place them under root
                Element lieferadresse = dom.createElement("lieferadresse");
                lieferadresse.setAttribute("land", "DE");
                rootEle.appendChild(lieferadresse);

                Element lname = dom.createElement("name");
                lname.setTextContent("Max Mustermann");
                lieferadresse.appendChild(lname);

                Element lstrasse = dom.createElement("straße");
                lstrasse.setTextContent("Karli 100");
                lieferadresse.appendChild(lstrasse);

                Element lstadt = dom.createElement("stadt");
                lstadt.setTextContent("Leipzig");
                lieferadresse.appendChild(lstadt);

                Element lplz = dom.createElement("plz");
                lplz.setTextContent("04275");
                lieferadresse.appendChild(lplz);

                // Rechnungsadressen-block
                Element rechnungsadresse = dom.createElement("rechnungsadresse");
                rechnungsadresse.setAttribute("land", "DE");
                rootEle.appendChild(rechnungsadresse);

                Element rname = dom.createElement("Name");
                rname.setTextContent("Robert Schmid");
                rechnungsadresse.appendChild(rname);

                Element rstrasse = dom.createElement("strasse");
                rstrasse.setTextContent("Haselussweg 3");
                rechnungsadresse.appendChild(rstrasse);

                Element rstadt = dom.createElement("stadt");
                rstadt.setTextContent("Frankfurt/Main");
                rechnungsadresse.appendChild(rstadt);

                Element rplz = dom.createElement("plz");
                rplz.setTextContent("61240");
                rechnungsadresse.appendChild(rplz);

                //Kommentar-BLOCK
                Element kommentar = dom.createElement("kommentar");
                kommentar.setTextContent("Bitte mit Geschenkverpakung!");
                rootEle.appendChild(kommentar);


                //Waren-BLOCK
                Element waren = dom.createElement("waren");
                rootEle.appendChild(waren);

                Element buch1 = dom.createElement("buch");
                buch1.setAttribute("ISBN", "3776622148");
                waren.appendChild(buch1);


                Element title1 = dom.createElement("title");
                title1.setTextContent("Vom Glück der Faulheit. Lebensenergie richtig einteilen.");
                buch1.appendChild(title1);

                Element anzahl1 = dom.createElement("anzahl");
                anzahl1.setTextContent("1");
                buch1.appendChild(anzahl1);

                Element preisEUR1 = dom.createElement("preisEUR");
                preisEUR1.setTextContent("29.90");
                buch1.appendChild(preisEUR1);

                Element kommentarbuch1 = dom.createElement("Kommentar");
                kommentarbuch1.setTextContent("Bitte Liefertermin bis Weihnachten bestätigen.");
                buch1.appendChild(kommentarbuch1);

                Element buch2 = dom.createElement("buch");
                buch2.setAttribute("ISBN", "3551551677");
                waren.appendChild(buch2);

                Element title2 = dom.createElement("title");
                title2.setTextContent("Harry Potter und der Stein der Weisen");
                buch2.appendChild(title2);

                Element anzahl2 = dom.createElement("anzahl");
                anzahl2.setTextContent("1");
                buch2.appendChild(anzahl2);

                Element preisEUR2 = dom.createElement("preisEUR");
                preisEUR2.setTextContent("29.90");
                buch2.appendChild(preisEUR2);

                Element lieferdatum = dom.createElement("lieferdatum");
                lieferdatum.setTextContent("2033-04-29");
                buch2.appendChild(lieferdatum);

                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream("src/Bestellung_3.xml")));

                ret = true;
            } catch (ParserConfigurationException pce) {
                System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
            } catch (TransformerConfigurationException transformerConfigurationException) {
                transformerConfigurationException.printStackTrace();
            } catch (TransformerException transformerException) {
                transformerException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            return ret;
        }
    }

    public static boolean ValidateXMl(String schemaPath, String filePath) {
        boolean ret = false;
        File schemaFile = new File(schemaPath);
        Source xmlFile = new StreamSource(new File(filePath));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            ret = true;
        } catch (SAXException e) {
        } catch (IOException e) {
        }
        return ret;
    }


}


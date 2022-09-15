import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.*;

import javax.xml.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

public class XMLtoHTML {
    public static void main(String[] args) {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslDoc = new StreamSource("XML2HTML.xsl");
        Source xmlDoc = new StreamSource("Schuelerliste.xml");

        String outputFileName = ("Schueler.html");
        try{
            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer transform = tFactory.newTransformer(xslDoc);
            transform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
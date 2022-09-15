import java.io.*;

public class Streams_und_eingaben {
    public static void main(String[] args) throws IOException{

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(in);
        System.out.println("Bitte Dateipfad eingeben.");

        String Pfad = buff.readLine();

        Boolean echt = false;
        while(echt == false){
            try {
                FileOutputStream file = new FileOutputStream(Pfad);
                echt = true;
                System.out.println("Wie viele Zeilen?");

                int linesCount = Integer.parseInt(buff.readLine());

                String line = "";

                String nextline = "\n";

                for(int i = 0; i < linesCount; i++){
                    System.out.println("Bitte eingeben, was in Zeile " + (i+1) + " stehen soll");
                    line = buff.readLine();
                    String writeline = line + nextline;
                    file.write(writeline.getBytes());
                }
                
                buff.close();
                in.close();
                file.close();
            }
            catch (FileNotFoundException fe){
                System.out.println("Die Datein Konnte nicht gefunden werden.");
                System.out.println("Bitte verscuhen sie es erneut!");
                Pfad = buff.readLine();
            }
        }
        buff.close();
        in.close();
    }
}

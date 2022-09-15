import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Aufgabe2{
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        File newpath = new File(path + "/log/uebungsklausur");
        if (!newpath.exists()){
            newpath.mkdirs();
        }
        try{
            FileWriter in = new FileWriter(newpath + "/meine_log_datei.txt");
            PrintWriter writer = new PrintWriter(in);
            writer.println("Error Log:");

            //DateTime Error String
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            for(int i = 0; i < 3; i++){
                LocalDateTime time = LocalDateTime.now();
                String formattime = time.format(format);
                writer.println("Error 500: Internal Error. " + formattime);
            }
            
            in.close();
        }catch(IOException e){

        }     
    }
}
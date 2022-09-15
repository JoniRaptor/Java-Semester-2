import java.util.*;

public class DateTime {
    public static void main(String[] args) {
        //System.out.format("Aktuelle Zeit, lokal: %tT %tZ %n", Calendar.getInstance(), Calendar.getInstance());

        Calendar c = new GregorianCalendar(1995, Calendar.MAY, 23);

        String s = String.format("Geburtstag: %1$tm %1$te, %1$tY %n", c);

        System.out.println(s);
    }
}

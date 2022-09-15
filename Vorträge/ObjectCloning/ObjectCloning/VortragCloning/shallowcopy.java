package ObjectCloning.VortragCloning;

class schüler {
    int alter;
    String name;
}

public class shallowcopy {
    public static void main(String[] args) {
        schüler ersterSchüler = new schüler();
        ersterSchüler.alter = 5;
        ersterSchüler.name = "helmut";

        schüler zweiterSchüler = ersterSchüler;

        System.out.println(zweiterSchüler.name);

        zweiterSchüler.alter = 2;

        System.out.println(ersterSchüler.alter);

        System.out.println(System.identityHashCode(ersterSchüler));
        System.out.println(System.identityHashCode(zweiterSchüler));
    }
}
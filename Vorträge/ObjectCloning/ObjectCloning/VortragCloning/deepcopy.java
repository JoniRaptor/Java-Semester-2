package ObjectCloning.VortragCloning;

class Busfahrer {
    int alter;
    String name;
    int gehalt;
    String busmodell;
}

public class deepcopy {
    public static void main(String[] args) {
        Busfahrer ersteBusfahrer = new Busfahrer();
        ersteBusfahrer.alter = 55;
        ersteBusfahrer.name = "Heinz";

        Busfahrer zweiterBusfahrer = new Busfahrer();
        zweiterBusfahrer.alter = ersteBusfahrer.alter;
        zweiterBusfahrer.name = ersteBusfahrer.name;

        System.out.println(zweiterBusfahrer.name + ": " + zweiterBusfahrer.alter);

        zweiterBusfahrer.alter = 22;

        System.out.println(ersteBusfahrer.alter);
        System.out.println(zweiterBusfahrer.alter);

        System.out.println(System.identityHashCode(ersteBusfahrer));
        System.out.println(System.identityHashCode(zweiterBusfahrer));
    }
}
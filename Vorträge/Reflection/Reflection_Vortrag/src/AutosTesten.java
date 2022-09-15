import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class AutosTesten {

    public static void main(String[] args) throws Exception {
        Auto auto = new Auto("Das Oberauto", 100);
        ElektroAuto elektroAuto = new ElektroAuto("Das Elektroauto", 130);

        auto.fahren(50);

        System.out.print("Wert des Autos: ");
        System.out.println(auto.wertBerechnen());


        // Reflection der Klasse und der Superklasse


        Class c_auto = auto.getClass();

//        System.out.println("Name der Klasse von c_auto: " + c_auto.getName());
//        System.out.println("Sichbarkeit/Modifier von c_auto: " + Modifier.toString(c_auto.getModifiers()));


        Class c_elektroauto = elektroAuto.getClass();

        Class c_super_elektroauto = c_elektroauto.getSuperclass();

//        System.out.println("Name der Klasse c_elektroauto: " + c_elektroauto.getName());
//        System.out.println("Name der Klasse c_super_elektroauto: " + c_super_elektroauto.getName());
//
//        System.out.print("Vergleich c_auto und c_super_elektroauto: ");
//        System.out.println(c_super_elektroauto == c_auto);  // Autoklkasse = Autoklasse

        // neue Instanzen
//        Object o = null;
//        Class myClass = Auto.class;
//        Constructor<?>[] constructors = myClass.getConstructors();
//        for (Constructor<?> constructor : constructors) {
//            o = constructor.newInstance( "Auto neu", 80);
//        }
//
//        System.out.print("Ist o eine Instanz von Auto: ");
//        System.out.println(o instanceof Auto);
//
//        Class auto_instanziert = o.getClass();
//        System.out.println("Name der Klasse auto_instanziert: " + auto_instanziert.getName());


        //Reflektion der Methoden einer Klasse

//        Method[] methods_auto = c_auto.getDeclaredMethods();
//        Method[] methods_elektroAuto = c_elektroauto.getDeclaredMethods();
//
//        for (Method method : methods_auto) {
//            System.out.print("Methode von Auto: ");
//            System.out.println(method);
//        }
//
//        for (Method method : methods_elektroAuto) {
//            System.out.print("Methode von ElektroAuto: ");
//            System.out.println(method);
//
//            int modifier = method.getModifiers();
//
//            System.out.println("Modifier von method: " + Modifier.toString(modifier));
//            System.out.print("Rueckgabetyp der Methode: ");
//            System.out.println(method.getReturnType());
//        }
//
//
//        // Reflektion der Felder
//
//        System.out.print("Wert des Autos: ");
//        System.out.println(auto.wertBerechnen());
//
//        Field f_gefahreneKilometer = c_auto.getDeclaredField("gefahreneKilometer");
//
//        f_gefahreneKilometer.setAccessible(true);
//
//        int f_gefahreneKilometer_value = (Integer) f_gefahreneKilometer.get(auto);
//        System.out.print("bereits gefahrene Kilometer: ");
//        System.out.println(f_gefahreneKilometer_value);
//
//        f_gefahreneKilometer.set(auto, 0);
//
//        f_gefahreneKilometer_value = (Integer) f_gefahreneKilometer.get(auto);
//        System.out.print("geaenderte gefahrene Kilometer: ");
//        System.out.println(f_gefahreneKilometer_value);
//
//        int f_name_mod = f_gefahreneKilometer.getModifiers();
//
//        // convert the access modifier to String form
//        String f_gefahreneKilometer_modifier = Modifier.toString(f_name_mod);
//        System.out.print("Modifier: " + f_gefahreneKilometer_modifier + " ");
//        System.out.println(f_name_mod);
//
//        System.out.print("Wert des Autos: ");
//        System.out.println(auto.wertBerechnen());

    }
}
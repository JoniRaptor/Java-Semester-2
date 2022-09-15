package ObjectCloning.VortragCloning;

public class main1 {
    public static void main(String[] args) {
        Moped m1 = new Moped();
        m1.setHubraum(1200);
        m1.setPs(98);
        Moped m2 = (Moped) m1.clone(); // casting
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(System.identityHashCode(m1));
        System.out.println(System.identityHashCode(m2));
    }
}
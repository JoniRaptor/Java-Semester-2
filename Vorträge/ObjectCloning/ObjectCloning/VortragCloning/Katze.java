package ObjectCloning.VortragCloning;

public class Katze implements Cloneable{
    int schönheit;
    String name;

public Katze(int schönheit, String name) {
    this.schönheit = schönheit;
    this.name = name;
}

public Object clone()throws CloneNotSupportedException{
    return super.clone();
}

public static void main(String args[]){
    try{
        Katze k1=new Katze(10,"Kaitlyn");

        Katze k2=(Katze)k1.clone();

        System.out.println("schönheit: " + k1.schönheit+" von 10 und heißt " + k1.name);
        System.out.println("schönheit: " + k2.schönheit+" von 10 und heißt " + k2.name);
        System.out.println(System.identityHashCode(k1));
        System.out.println(System.identityHashCode(k2));

        k1.schönheit = 5;
        System.out.println(k1.schönheit);
        System.out.println(k2.schönheit);
    }
    catch(CloneNotSupportedException c){}
    }
}
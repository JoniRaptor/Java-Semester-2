public class ElektroAuto extends Auto {


    public ElektroAuto(String bezeichnung, int ps) {
        super(bezeichnung, ps);
    }

    @Override
    public void fahren(int kilometer) {
        super.fahren(kilometer);
        System.out.println("Der neue Kilometerstand betraegt " + this.gefahreneKilometer);
    }
}
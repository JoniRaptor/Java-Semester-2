public class Auto {

    String bezeichnung;
    int ps;
    protected int gefahreneKilometer;

    public Auto(String bezeichnung, int ps) {
        this.bezeichnung = bezeichnung;
        this.ps = ps;
        this.gefahreneKilometer = 0;
    }

    public void fahren(int kilometer){
        if (this.gefahreneKilometer + kilometer < 0){
            return;
        }

        this.gefahreneKilometer += kilometer;
    }


    public int wertBerechnen(){
        return this.gefahreneKilometer * 100;
    }


}
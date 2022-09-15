package ObjectCloning.VortragCloning;

public class Moped {
    private int hubraum;
    private int ps;
    
    public int getHubraum() {
        return hubraum;
    }
    public void setHubraum(int hubraum) {
        this.hubraum = hubraum;
    }
    public int getPs() {
        return ps;
    }
    public void setPs(int ps) {
        this.ps = ps;
    }
    
    @Override
    public Object clone() {
        Moped moped = new Moped();
        moped.setHubraum(hubraum);
        moped.setPs(ps);
        return moped;
    }

    @Override
    public String toString() {
        return "Moped [Hubraum: " + hubraum + ", PS: " + ps + "]";
    }
}
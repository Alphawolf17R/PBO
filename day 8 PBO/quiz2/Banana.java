package quiz2;
public class Banana extends Fruits {
    private boolean isRipe;

    public Banana(double weight, boolean isRipe) {
        super("Pisang", "Kuning", weight);
        this.isRipe = isRipe;
    }

    @Override
    public void taste() {
        System.out.println("Rasa   : " + (isRipe ? "Manis" : "Sepat"));
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Matang : " + (isRipe ? "Ya" : "Belum"));
    }
}
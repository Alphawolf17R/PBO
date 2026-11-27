package quiz2;
public class Orange extends Fruits {
    private int segments;

    public Orange(double weight, int segments) {
        super("Jeruk", "Oranye", weight);
        this.segments = segments;
    }

    @Override
    public void taste() {
        System.out.println("Rasa   : Manis segar dan asam");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Jumlah siung: " + segments);
    }
}
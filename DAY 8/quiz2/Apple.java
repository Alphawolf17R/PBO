package quiz2;
public class Apple extends Fruits {
    private String variety;

    public Apple(String color, double weight, String variety) {
        super("Apel", color, weight);
        this.variety = variety;
    }

    @Override
    public void taste() {
        System.out.println("Rasa   : Manis dan sedikit asam");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Varietas: " + variety);
    }
}
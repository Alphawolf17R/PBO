package quiz2;
public class Fruits {
    protected String name;
    protected String color;
    protected double weight; // dalam gram

    public Fruits(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public void info() {
        System.out.println("Nama   : " + name);
        System.out.println("Warna  : " + color);
        System.out.println("Berat  : " + weight + " gram");
    }

    public void taste() {
        System.out.println("Rasa   : -");
    }
}
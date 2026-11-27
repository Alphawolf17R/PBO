package quiz2;
public class Main {
    public static void main(String[] args) {
        Fruits[] fruits = {
            new Apple("Merah", 180, "Fuji"),
            new Banana(120, true),
            new Orange(150, 10)
        };

        for (Fruits f : fruits) {
            f.info();
            f.taste();
            System.out.println("------------------------");
        }
    }
}
    import java.util.Scanner;

public class soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah bilangan: ");
        int n = input.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " adalah bilangan genap");
        } else {
            System.out.println(n + " adalah bilangan ganjil");
        }
    }
}

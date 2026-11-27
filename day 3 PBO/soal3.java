import java.util.Scanner;

public class soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan total pembelian: ");
        double total = input.nextDouble();
        double diskon;

        if (total >= 500000) {
            diskon = 0.20;
        } else if (total >= 200000) {
            diskon = 0.10;
        } else if (total >= 100000) {
            diskon = 0.05;
        } else {
            diskon = 0;
        }

        double potongan = total * diskon;
        double bayar = total - potongan;

        System.out.println("Diskon: " + (diskon * 100) + "%");
        System.out.println("Potongan: Rp" + potongan);
        System.out.println("Total bayar: Rp" + bayar);
    }
}
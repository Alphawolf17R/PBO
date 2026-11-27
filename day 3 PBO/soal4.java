import java.util.Scanner;

public class soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan kode hari (0-6): ");
        int kode = input.nextInt();

        if (kode == 0) {
            System.out.println("Minggu");
        } else if (kode == 1) {
            System.out.println("Senin");
        } else if (kode == 2) {
            System.out.println("Selasa");
        } else if (kode == 3) {
            System.out.println("Rabu");
        } else if (kode == 4) {
            System.out.println("Kamis");
        } else if (kode == 5) {
            System.out.println("Jumat");
        } else if (kode == 6) {
            System.out.println("Sabtu");
        } else {
            System.out.println("Kode tidak valid");
        }
    }
}
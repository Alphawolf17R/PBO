import java.util.Scanner;

public class sistempengelolaankasbuku1 {
    static Scanner in = new Scanner(System.in);

    static long hitungSaldo(long awal, long masuk, long keluar) {
        return awal + masuk - keluar;                       // P4: function return
    }

    static void laporan(String buku, String jenis, long jumlah, long saldo) {
        System.out.printf("%s - %s Rp%d | Saldo Rp%d\n", buku, jenis, jumlah, saldo); // P4: void
    }
    public static void main(String[] args) {
        final long BATAS = 10000;                           // P2: konstanta
        long[] kas = new long[2];                           // P2: [0] masuk, [1] keluar

        System.out.print("Nama buku kas : ");
        String buku = in.nextLine();                        // P2: String
        System.out.print("Saldo awal    : ");
        long awal = in.nextLong();                          // P2: long
        System.out.print("Jenis (1=Masuk, 2=Keluar): ");
        int pilih = (int) in.nextLong();                    // P2: casting
        System.out.print("Jumlah        : ");
        long jumlah = in.nextLong();

        String jenis;
        switch (pilih) {                                    // P3: switch
            case 1 -> jenis = "Masuk";
            case 2 -> jenis = "Keluar";
            default -> { System.out.println("Pilihan salah!"); return; }
        }

        if (jumlah <= 0 || (pilih == 2 && jumlah > awal)) { // P3: if + operator logika
            System.out.println("Jumlah tidak valid / saldo tidak cukup!");
            return;
        }

        kas[pilih - 1] += jumlah;                           // P2: assignment +=
        long akhir = hitungSaldo(awal, kas[0], kas[1]);
        laporan(buku, jenis, jumlah, akhir);

        if (akhir >= BATAS) System.out.println("Kas AMAN");
        else System.out.println("Kas MENIPIS, kurang Rp" + (BATAS - akhir));
    }
}
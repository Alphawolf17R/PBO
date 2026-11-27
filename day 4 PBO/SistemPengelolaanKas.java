import java.util.Scanner;

// =====================================================
// SISTEM PENGELOLAAN KAS
// Pertemuan 2: Tipe Data, Variabel, Method, Ekspresi
// Pertemuan 3: Control Statement (if-else, switch)
// Pertemuan 4: Function dan Parameter
// =====================================================
public class SistemPengelolaanKas {
    static Scanner input = new Scanner(System.in);

    static String inputTeks(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }
    static long inputAngka(String pesan) {
        System.out.print(pesan);
        long angka = input.nextLong();
        input.nextLine();                                  // buang enter sisa input
        return angka;
    }
    static long hitungSaldo(long saldoAwal, long masuk, long keluar) {
        return saldoAwal + masuk - keluar;                 // [P2] ekspresi aritmatika
    }
    static void catatTransaksi(long[] transaksi, int jenis, long jumlah) {
        transaksi[jenis - 1] += jumlah;                    // [P2] assignment +=
    }
    static void tampilkanLaporan(String kas, String jenis, String ket, long jumlah, long saldo) {
        System.out.printf("\n%s - %s (%s) | Rp%d | Saldo Rp%d\n", kas, jenis, ket, jumlah, saldo); // [P2] printf
    }

    public static void main(String[] args) {
        final long BATAS_AMAN = 10000;                     // [P2] konstanta final
        long[] transaksi = new long[2];                    // [P2] array 2 isi: [0] = masuk, [1] = keluar
        String namaKas = inputTeks("Nama kas                 : ");   // [P2] String
        long saldoAwal = inputAngka("Saldo awal (Rp)          : ");  // [P2] long
        int pilihan = (int) inputAngka("Jenis (1=Masuk, 2=Keluar): "); // [P2] casting long ke int
        String jenis;
        switch (pilihan) {                                 // [P3] switch-case
            case 1 -> { jenis = "Masuk"; }
            case 2 -> { jenis = "Keluar"; }
            default -> { System.out.println("Pilihan salah!"); return; }   // [P3] return
        }
        String keterangan = inputTeks("Keterangan               : ");
        long jumlah = inputAngka("Jumlah (Rp)              : ");
        if (jumlah <= 0 || (pilihan == 2 && jumlah > saldoAwal)) {         // [P3] if + operator logika
            System.out.println("Jumlah tidak valid / saldo tidak cukup!");
            return;
        }
        catatTransaksi(transaksi, pilihan, jumlah);        // [P4] array asli ikut berubah
        long saldoAkhir = hitungSaldo(saldoAwal, transaksi[0], transaksi[1]); // [P4] panggil function return
        tampilkanLaporan(namaKas, jenis, keterangan, jumlah, saldoAkhir);     // [P4] panggil function void
        boolean aman = saldoAkhir >= BATAS_AMAN;           // [P2] boolean
        if (aman) System.out.println("Kondisi kas AMAN, saldo Rp" + saldoAkhir);          // [P3] if - else
        else System.out.println("Kas MENIPIS, kurang Rp" + (BATAS_AMAN - saldoAkhir));
    }
} 
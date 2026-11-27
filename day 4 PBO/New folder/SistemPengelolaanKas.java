import java.util.Scanner;

// =====================================================
// SISTEM PENGELOLAAN KAS (versi menu)
// P2: tipe data, variabel, ekspresi | P3: if-else, switch | P4: function
// =====================================================
public class SistemPengelolaanKas {
    static Scanner input = new Scanner(System.in);

    static final int MAKS_KAS = 20;
    static final long BATAS_AMAN = 10000;
    static final String[] NAMA_BULAN = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun",
                                        "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

    // Data disimpan di array paralel: index yang sama = kas yang sama
    static String[] namaKas = new String[MAKS_KAS];
    static long[] saldoAwal = new long[MAKS_KAS];
    static long[][] masuk = new long[MAKS_KAS][12];    // [kas][bulan]
    static long[][] keluar = new long[MAKS_KAS][12];
    static int jumlahKas = 0;

    // ---------- function input ----------
    static String inputTeks(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }
    static long inputAngka(String pesan) {
        System.out.print(pesan);
        long angka = input.nextLong();
        input.nextLine();                              // buang enter sisa input
        return angka;
    }

    // ---------- function logika ----------
    static int cariKas(String nama) {
        for (int i = 0; i < jumlahKas; i++) {
            if (namaKas[i].equalsIgnoreCase(nama)) return i;
        }
        return -1;                                     // tidak ketemu
    }
    static long totalBulan(long[] data) {
        long total = 0;
        for (int i = 0; i < 12; i++) total += data[i];
        return total;
    }
    static long hitungSaldo(int idx) {
        return saldoAwal[idx] + totalBulan(masuk[idx]) - totalBulan(keluar[idx]);
    }

    // ---------- function tampilan ----------
    static void tampilkanMenu() {
        System.out.println("\n===== SISTEM PENGELOLAAN KAS =====");
        System.out.println("1. Info kas");
        System.out.println("2. Daftar kas");
        System.out.println("3. Input kas");
        System.out.println("4. Data report per bulan");
        System.out.println("5. Keluar");
    }

    static void infoKas() {
        if (jumlahKas == 0) { System.out.println("Belum ada kas."); return; }
        int idx = cariKas(inputTeks("Nama kas: "));
        if (idx == -1) { System.out.println("Kas tidak ditemukan!"); return; }

        long saldo = hitungSaldo(idx);
        System.out.println("\nNama kas     : " + namaKas[idx]);
        System.out.println("Saldo awal   : Rp" + saldoAwal[idx]);
        System.out.println("Total masuk  : Rp" + totalBulan(masuk[idx]));
        System.out.println("Total keluar : Rp" + totalBulan(keluar[idx]));
        System.out.println("Saldo akhir  : Rp" + saldo);
        if (saldo >= BATAS_AMAN) System.out.println("Kondisi kas AMAN");
        else System.out.println("Kas MENIPIS, kurang Rp" + (BATAS_AMAN - saldo));
    }

    static void daftarKas() {
        if (jumlahKas == 0) { System.out.println("Belum ada kas."); return; }
        System.out.println("\n--- Daftar Kas ---");
        for (int i = 0; i < jumlahKas; i++) {
            System.out.printf("%d. %-15s Saldo Rp%d\n", i + 1, namaKas[i], hitungSaldo(i));
        }
    }

    static void inputKas() {
        String nama = inputTeks("Nama kas                 : ");
        int idx = cariKas(nama);

        if (idx == -1) {                               // kas baru
            if (jumlahKas >= MAKS_KAS) { System.out.println("Kapasitas kas penuh!"); return; }
            idx = jumlahKas;
            namaKas[idx] = nama;
            saldoAwal[idx] = inputAngka("Kas baru, saldo awal (Rp): ");
            jumlahKas++;
        }

        int pilihan = (int) inputAngka("Jenis (1=Masuk, 2=Keluar): ");
        String jenis;
        switch (pilihan) {
            case 1 -> jenis = "Masuk";
            case 2 -> jenis = "Keluar";
            default -> { System.out.println("Pilihan salah!"); return; }
        }
        int bulan = (int) inputAngka("Bulan (1-12)             : ");
        if (bulan < 1 || bulan > 12) { System.out.println("Bulan tidak valid!"); return; }

        String keterangan = inputTeks("Keterangan               : ");
        long jumlah = inputAngka("Jumlah (Rp)              : ");
        if (jumlah <= 0 || (pilihan == 2 && jumlah > hitungSaldo(idx))) {
            System.out.println("Jumlah tidak valid / saldo tidak cukup!");
            return;
        }

        if (pilihan == 1) masuk[idx][bulan - 1] += jumlah;
        else keluar[idx][bulan - 1] += jumlah;

        System.out.printf("\n%s - %s (%s) | Rp%d | Saldo Rp%d\n",
                namaKas[idx], jenis, keterangan, jumlah, hitungSaldo(idx));
    }

    static void reportPerBulan() {
        if (jumlahKas == 0) { System.out.println("Belum ada kas."); return; }
        int idx = cariKas(inputTeks("Nama kas: "));
        if (idx == -1) { System.out.println("Kas tidak ditemukan!"); return; }

        System.out.println("\n--- Report Bulanan: " + namaKas[idx] + " ---");
        System.out.printf("%-6s %12s %12s\n", "Bulan", "Masuk", "Keluar");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-6s %12d %12d\n", NAMA_BULAN[i], masuk[idx][i], keluar[idx][i]);
        }
        System.out.printf("%-6s %12d %12d\n", "TOTAL", totalBulan(masuk[idx]), totalBulan(keluar[idx]));
    }

    public static void main(String[] args) {
        int menu = 0;
        while (menu != 5) {
            tampilkanMenu();
            menu = (int) inputAngka("Pilih menu: ");
            switch (menu) {
                case 1 -> infoKas();
                case 2 -> daftarKas();
                case 3 -> inputKas();
                case 4 -> reportPerBulan();
                case 5 -> System.out.println("Terima kasih!");
                default -> System.out.println("Menu tidak tersedia!");
            }
        }
    }
}

import java.util.Scanner;

// =====================================================
// PROGRAM UTAMA — SISTEM PENGELOLAAN KAS (simpel)
// P3: switch | P5/6: memakai class & getter/setter | P7: inheritance & overriding
// =====================================================
public class SistemPengelolaankas10 {
    static Scanner input = new Scanner(System.in);

    static void tampilkanMenu() {
        System.out.println("\n===== SISTEM PENGELOLAAN KAS =====");
        System.out.println("1. Info kas");
        System.out.println("2. Uang masuk");
        System.out.println("3. Uang keluar");
        System.out.println("4. Ubah nama kas");
        System.out.println("5. Keluar");
        System.out.println("6. Demo inheritance");
        System.out.print("Pilih menu: ");
    }

    static void infoKas(Kas kas) {
        System.out.println("\nNama kas     : " + kas.getNama());
        System.out.println("Total masuk  : Rp" + kas.getTotalMasuk());
        System.out.println("Total keluar : Rp" + kas.getTotalKeluar());
        System.out.println("Saldo        : Rp" + kas.getSaldo());
        System.out.println("Status       : " + kas.getStatus());
    }

    // Demo inheritance: memanggil method langsung pada masing-masing objek
    static void demoInheritance(Kas kasUtama) {
        KasTabungan tabungan = new KasTabungan("Tabungan Liburan", 250000, 5);
        tabungan.tambahMasuk(100000);
        tabungan.tambahBunga();

        KasUsaha usaha = new KasUsaha("Kas Usaha", 1000000, 200000);
        usaha.tambahMasuk(500000);
        boolean diterima = usaha.tambahKeluar(300000); // akan ditolak

        System.out.println("\n===== DEMO INHERITANCE =====");
        System.out.println("- " + kasUtama.getNama()
                + " | saldo Rp" + kasUtama.getSaldo()
                + " | status " + kasUtama.getStatus());
        System.out.println("- " + tabungan.getNama()
                + " | saldo Rp" + tabungan.getSaldo()
                + " | status " + tabungan.getStatus());
        System.out.println("- " + usaha.getNama()
                + " | saldo Rp" + usaha.getSaldo()
                + " | status " + usaha.getStatus());
        System.out.println("Bunga tabungan: " + tabungan.getBunga() + "%");
        System.out.println("Pengeluaran Rp300000 di Kas Usaha: "
                + (diterima ? "diterima" : "ditolak (melebihi batas Rp200000)"));
    }

    public static void main(String[] args) {
        System.out.print("Nama kas   : ");
        String nama = input.nextLine();
        System.out.print("Saldo awal : Rp");
        long saldoAwal = input.nextLong();

        Kas kas = new Kas(nama, saldoAwal);            // panggil constructor

        int menu = 0;
        while (menu != 5) {
            tampilkanMenu();
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    infoKas(kas);
                    break;
                case 2:
                    System.out.print("Jumlah masuk (Rp): ");
                    long masuk = input.nextLong();
                    if (kas.tambahMasuk(masuk)) System.out.println("Berhasil! Saldo: Rp" + kas.getSaldo());
                    else System.out.println("Jumlah tidak valid!");
                    break;
                case 3:
                    System.out.print("Jumlah keluar (Rp): ");
                    long keluar = input.nextLong();
                    if (kas.tambahKeluar(keluar)) System.out.println("Berhasil! Saldo: Rp" + kas.getSaldo());
                    else System.out.println("Jumlah tidak valid / saldo tidak cukup!");
                    break;
                case 4:
                    input.nextLine(); // buang sisa enter dari nextInt()
                    System.out.print("Nama kas baru: ");
                    String namaBaru = input.nextLine();
                    kas.setNama(namaBaru);
                    System.out.println("Nama kas sekarang: " + kas.getNama());
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                case 6:
                    demoInheritance(kas);
                    break;
                default:
                    System.out.println("Menu tidak tersedia!");
            }
        }
    }
}

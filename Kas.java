// =====================================================
// CLASS KAS (induk / superclass)
// P2: tipe data, variabel, ekspresi | P3: if-else
// P4: method & parameter            | P5/6: encapsulation & constructor, SETTER AND GETTER
// =====================================================
public class Kas {
    // Encapsulation: field dibuat private
    private String nama;
    private long saldo;
    private long totalMasuk;
    private long totalKeluar;

    // Constructor
    public Kas(String nama, long saldoAwal) {
        this.nama = nama;
        this.saldo = saldoAwal;
        this.totalMasuk = 0;
        this.totalKeluar = 0;
    }

    // Getter
    public String getNama() { return nama; }
    public long getSaldo() { return saldo; }
    public long getTotalMasuk() { return totalMasuk; }
    public long getTotalKeluar() { return totalKeluar; }

    // Setter
    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        }
    }

    // Method dengan parameter + validasi
    public boolean tambahMasuk(long jumlah) {
        if (jumlah <= 0) return false;
        saldo += jumlah;
        totalMasuk += jumlah;
        return true;
    }

    public boolean tambahKeluar(long jumlah) {
        if (jumlah <= 0 || jumlah > saldo) return false;
        saldo -= jumlah;
        totalKeluar += jumlah;
        return true;
    }

    public String getStatus() {
        if (saldo >= 10000) return "AMAN";
        else return "MENIPIS";
    }
}

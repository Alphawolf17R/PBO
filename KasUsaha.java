// =====================================================
// INHERITANCE: KasUsaha extends Kas
// P7: inheritance & overriding
// =====================================================
public class KasUsaha extends Kas {
    private long batasKeluar; // batas maksimal per transaksi

    public KasUsaha(String nama, long saldoAwal, long batasKeluar) {
        super(nama, saldoAwal);
        this.batasKeluar = batasKeluar;
    }

    public long getBatasKeluar() { return batasKeluar; }

    public void setBatasKeluar(long batasKeluar) {
        if (batasKeluar > 0) this.batasKeluar = batasKeluar;
    }

    // Override: tambah validasi, lalu tetap pakai logika induk lewat super
    @Override
    public boolean tambahKeluar(long jumlah) {
        if (jumlah > batasKeluar) return false;
        return super.tambahKeluar(jumlah);
    }

    @Override
    public String getStatus() {
        if (getSaldo() >= 1000000) return "LANCAR (USAHA)";
        if (getSaldo() >= 10000) return "CUKUP (USAHA)";
        return "MENIPIS (USAHA)";
    }
}

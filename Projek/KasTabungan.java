// =====================================================
// INHERITANCE: KasTabungan extends Kas
// P7: inheritance & overriding
// =====================================================
public class KasTabungan extends Kas {
    private double bunga; // 
    
    public KasTabungan(String nama, long saldoAwal, double bunga){
        super(nama, saldoAwal);
        this.bunga = bunga;
    }
    public double getBunga() {
        return bunga;
    }
     public void setBunga(double bunga) {
        if (bunga >= 0) this.bunga = bunga;
    }

    
    public long hitungBunga() {
        return (long) (getSaldo() * bunga / 100);
    }

    public void tambahBunga() {
        long b = hitungBunga();
        if (b > 0) tambahMasuk(b); 
    }

    @Override
    public String getStatus() {
        if ( getSaldo () >=  500000) return "SEHAT (TABUNGAN)";
        return "MENIPIS (TABUNGAN)";
    }

}
import java.util.Scanner;

class Barang {

    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int stok;

    // Constructor 
    public Barang(String kodeBarang, String namaBarang, double harga, int stok) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Peringatan: Harga harus > 0. Diatur default ke 1.0");
            this.harga = 1.0;
        }

        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Peringatan: Stok awal tidak boleh negatif. Diatur ke 0.");
            this.stok = 0;
        }
    }

    // Getter untuk membaca data barang
    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Method tambahStok
    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            stok += jumlah;
            System.out.println("Berhasil menambah stok. Stok sekarang: " + stok);
        } else {
            System.out.println("Gagal menambah stok: Jumlah harus lebih dari 0.");
        }
    }

    // Method jualBarang (Tolak pembelian melebihi stok atau jumlah <= 0)
    public boolean jualBarang(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Gagal transaksi: Jumlah beli harus lebih dari 0.");
            return false;
        }
        if (jumlah > stok) {
            System.out.println("Gagal transaksi: Pembelian melebihi stok yang tersedia (" + stok + ").");
            return false;
        }
        
        stok -= jumlah; // Stok berubah lewat method transaksi yang valid
        System.out.println("Transaksi penjualan berhasil! Sisa stok: " + stok);
        return true;
    }

    // Method hitungTotal dengan ketentuan diskon 10% jika subtotal >= Rp500.000
    public void hitungTotal(int jumlahBeli) {
        double subtotal = harga * jumlahBeli;
        double diskon = 0;
        double totalBayar = subtotal;

        System.out.println("\n--- RINCIAN TRANSAKSI ---");
        System.out.println("Nama Barang : " + namaBarang);
        System.out.println("Harga Satuan: Rp " + harga);
        System.out.println("Jumlah Beli : " + jumlahBeli);
        System.out.println("Subtotal    : Rp " + subtotal);

     
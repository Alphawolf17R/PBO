class KasBuku {
    protected String nama;
    protected long saldo;

    KasBuku(String nama, long saldo) {
        this.nama = nama;
        this.saldo = saldo;
    }

    void catat(int jenis, long jumlah) {
        if (jenis == 1) saldo += jumlah;
        else saldo -= jumlah;
    }

    String info() { return nama + " | Saldo Rp" + saldo; }
}

class KasBukuKampus extends KasBuku {
    KasBukuKampus(String nama, long saldo) {
        super(nama, saldo);                    // panggil constructor induk
    }

    @Override
    String info() { return "[Kampus] " + super.info(); }
}

class KasBukuSekolah extends KasBuku {
    KasBukuSekolah(String nama, long saldo) {
        super(nama, saldo);
    }

    @Override
    String info() { return "[Sekolah] " + super.info(); }
}

public class Main {
    public static void main(String[] args) {
        KasBuku a = new KasBukuKampus("Kas Himpunan", 50000);
        KasBuku b = new KasBukuSekolah("Kas Kelas", 20000);

        a.catat(1, 10000);
        b.catat(2, 5000);

        System.out.println(a.info());   // [Kampus] Kas Himpunan | Saldo Rp60000
        System.out.println(b.info());   // [Sekolah] Kas Kelas | Saldo Rp15000
    }
}
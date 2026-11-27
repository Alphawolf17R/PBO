import java.util.Scanner;

public class PengelolaanNilaiMahasiswa {
    private String nim;
    private String nama;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;

    // Constructor
    public PengelolaanNilaiMahasiswa(String nim, String nama, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        setNilaiTugas(nilaiTugas);
        setNilaiUTS(nilaiUTS);
        setNilaiUAS(nilaiUAS);
    }

    // Getter dan Setter dengan Validasi (0 - 100)
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public void setNilaiTugas(double nilaiTugas) {
        if (nilaiTugas >= 0 && nilaiTugas <= 100) {
            this.nilaiTugas = nilaiTugas;
        } else {
            System.out.println("Error: Nilai Tugas harus antara 0 - 100! Diatur ke 0.");
            this.nilaiTugas = 0;
        }
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    public void setNilaiUTS(double nilaiUTS) {
        if (nilaiUTS >= 0 && nilaiUTS <= 100) {
            this.nilaiUTS = nilaiUTS;
        } else {
            System.out.println("Error: Nilai UTS harus antara 0 - 100! Diatur ke 0.");
            this.nilaiUTS = 0;
        }
    }

    public double getNilaiUAS() {
        return nilaiUAS;
    }

    public void setNilaiUAS(double nilaiUAS) {
        if (nilaiUAS >= 0 && nilaiUAS <= 100) {
            this.nilaiUAS = nilaiUAS;
        } else {
            System.out.println("Error: Nilai UAS harus antara 0 - 100! Diatur ke 0.");
            this.nilaiUAS = 0;
        }
    }

    // Method hitung nilai akhir 30% Tugas, 30% UTS, 40% UAS
    public double hitungNilaiAkhir() {
        return (0.30 * nilaiTugas) + (0.30 * nilaiUTS) + (0.40 * nilaiUAS);
    }

    // Method tentukanStatus: LULUS jika nilai akhir >= 60
    public String tentukanStatus() {
        if (hitungNilaiAkhir() >= 60) {
            return "lulus anjay";
        } else {
            return "ga lulus";
        }
    }

    // Method Main  Scanner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PROGRAM PENGELOLAAN NILAI MAHASISWA ===");
        System.out.print("Masukkan NIM    : ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Nama   : ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Nilai Tugas (0-100): ");
        double tugas = scanner.nextDouble();

        System.out.print("Masukkan Nilai UTS (0-100)  : ");
        double uts = scanner.nextDouble();

        System.out.print("Masukkan Nilai UAS (0-100)  : ");
        double uas = scanner.nextDouble();

        // Membuat objek mahasiswa
        PengelolaanNilaiMahasiswa mhs = new PengelolaanNilaiMahasiswa(nim, nama, tugas, uts, uas);

        // Menampilkan data, nilai akhir, dan status kelulusan sesuai soal
        System.out.println("\n--- HASIL DATA MAHASISWA ---");
        System.out.println("NIM         : " + mhs.getNim());
        System.out.println("Nama        : " + mhs.getNama());
        System.out.println("Nilai Tugas : " + mhs.getNilaiTugas());
        System.out.println("Nilai UTS   : " + mhs.getNilaiUTS());
        System.out.println("Nilai UAS   : " + mhs.getNilaiUAS());
        System.out.println("Nilai Akhir : " + mhs.hitungNilaiAkhir());
        System.out.println("Status      : " + mhs.tentukanStatus());

        scanner.close();
    }
}
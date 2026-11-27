import java.util.Scanner;
public class SistemInformasiBuku {
    String judul, penulis;
    int tahunTerbit;
    // Constructor
    public  SistemInformasiBuku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void tampilkanInformasi() {
       System.out.println("Informasi Buku:");
       System.out.println();
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
    }

    // Tambahkan metode untuk mengubah informasi buku
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan judul buku: ");
        String judul = input.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = input.nextLine();
        System.out.print("Masukkan tahun terbit buku: ");
        int tahunTerbit = input.nextInt();
        input.nextLine(); // Membersihkan newline setelah membaca integer

        System.out.println();

        System.out.print("Masukkan judul buku2: ");
        String judul2 = input.nextLine();
        System.out.print("Masukkan penulis buku2: ");
        String penulis2 = input.nextLine();
        System.out.print("Masukkan tahun terbit buku2: ");
        int tahunTerbit2 = input.nextInt();
        input.nextLine(); // Membersihkan newline setelah membaca integer

        // Membuat objek SistemInformasiBuku untuk masing-masing buku
        SistemInformasiBuku buku1 = new SistemInformasiBuku(judul,penulis,tahunTerbit);
        SistemInformasiBuku buku2 = new SistemInformasiBuku(judul2,penulis2,tahunTerbit2);
        
        System.out.println();
        System.out.println("===============================");
        System.out.println(" HASIL OUTPUT SISTEM INFORMASI BUKU ");
        System.out.println("===============================");

        // Menampilkan informasi buku
        buku1.tampilkanInformasi();
        System.out.println("===============================");
        buku2.tampilkanInformasi();
    input.close();
    }
}



package quiz3;

public class Teacher extends Person {
    private String nip;
    private String subject;

    public Teacher(String name, int age, String address, String nip, String subject) {
        super(name, age, address);
        this.nip = nip;
        this.subject = subject;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("NIP    : " + nip);
        System.out.println("Mapel  : " + subject);
    }

    @Override
    public void work() {
        System.out.println("Aktivitas : Mengajar dan membimbing mahasiswa");
    }
}
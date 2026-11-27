package quiz3;

public class Student extends Person {
    private String nim;
    private String major;

    public Student(String name, int age, String address, String nim, String major) {
        super(name, age, address);
        this.nim = nim;
        this.major = major;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("NIM    : " + nim);
        System.out.println("Jurusan: " + major);
    }

    @Override
    public void work() {
        System.out.println("Aktivitas : Belajar dan mengerjakan tugas kuliah");
    }
}
package quiz3;

public class Employee extends Person {
    private String position;
    private double salary;

    public Employee(String name, int age, String address, String position, double salary) {
        super(name, age, address);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Jabatan: " + position);
        System.out.println("Gaji   : Rp" + salary);
    }

    @Override
    public void work() {
        System.out.println("Aktivitas : Bekerja sesuai jabatan di perusahaan");
    }
}